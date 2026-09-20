package com.fourkingdoms.mod.event;

import com.fourkingdoms.mod.material.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>ArmorSetEffectHandler</h1>
 * <p>
 * Server-side handler implementing hero armor set bonuses.
 * Registered on {@code NeoForge.EVENT_BUS} from {@code FourKingdomsMod} (game bus, not the mod bus).
 * </p>
 *
 * <h2>Chance model (additive)</h2>
 * <p>
 * Each worn piece adds {@value #PER_PIECE_CHANCE} to a single roll per trigger, so 1 piece = 25%,
 * 2 = 50%, 3 = 75%, and a full 4-piece set always triggers (100%).
 * </p>
 *
 * <h2>Bonuses</h2>
 * <ul>
 *   <li><b>Daydream:</b> interval roll → Speed II + Regeneration I.</li>
 *   <li><b>Nightmare:</b> incoming Wither/Poison/Slowness blocked on roll; active ones halved/cleansed.</li>
 *   <li><b>Flare:</b> interval roll → Fire Resistance.</li>
 *   <li><b>Crystal:</b> interval roll → Water Breathing + Dolphin's Grace.</li>
 *   <li><b>Speed:</b> interval roll → Speed I + Haste I.</li>
 *   <li><b>Black:</b> interval roll → Invisibility (short) + Night Vision.</li>
 *   <li><b>Pearl:</b> interval roll → Slow Falling; ender-pearl landing damage negated on roll.</li>
 *   <li><b>Lazuli:</b> attackers chilled with Slowness II on roll (thorns-style, damage hook).</li>
 *   <li><b>Leafy:</b> interval roll → Regeneration I + Saturation.</li>
 *   <li><b>Sylvia:</b> interval roll → Absorption II (4 bonus hearts).</li>
 *   <li><b>Sunshine:</b> interval roll → Night Vision + cleanse of Darkness/Blindness.</li>
 * </ul>
 */
public final class ArmorSetEffectHandler {
    /** Bonus roll interval: 20 seconds. */
    public static final int INTERVAL_TICKS = 400;

    /** Chance added per worn piece to the single roll (0.25 x pieces; full set = guaranteed). */
    public static final float PER_PIECE_CHANCE = 0.25F;

    /** Duration of standard interval buffs. */
    public static final int BUFF_DURATION_TICKS = 400;

    /** Shorter duration for stealth-flavored buffs. */
    public static final int SHORT_BUFF_DURATION_TICKS = 200;

    /** Retaliation debuff duration for Lazuli's chill. */
    public static final int RETALIATION_DURATION_TICKS = 100;

    /** Remaining durations at or below this are cleansed instead of halved. */
    public static final int CLEANSE_THRESHOLD_TICKS = 100;

    /** Bad effects Nightmare mitigates. Extend here for future "and more" coverage. */
    private static final List<Holder<MobEffect>> NIGHTMARE_MITIGATED = List.of(
            MobEffects.WITHER, MobEffects.POISON, MobEffects.MOVEMENT_SLOWDOWN);

    /** Debuffs Sunshine cleanses outright on a successful roll. */
    private static final List<Holder<MobEffect>> SUNSHINE_CLEANSED =
            List.of(MobEffects.DARKNESS, MobEffects.BLINDNESS);

    private static final SetBonus DAYDREAM_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BUFF_DURATION_TICKS, 1));
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, BUFF_DURATION_TICKS, 0));
    };

    private static final SetBonus NIGHTMARE_BONUS = (player, piecesWorn) -> {
        for (Holder<MobEffect> badEffect : NIGHTMARE_MITIGATED) {
            MobEffectInstance active = player.getEffect(badEffect);
            if (active == null) {
                continue;
            }
            if (!rollSucceeds(player, piecesWorn)) {
                continue;
            }
            if (active.getDuration() <= CLEANSE_THRESHOLD_TICKS) {
                player.removeEffect(badEffect);
            } else {
                int halved = active.getDuration() / 2;
                player.removeEffect(badEffect);
                player.addEffect(new MobEffectInstance(
                        badEffect, halved, active.getAmplifier(), active.isAmbient(), active.isVisible(), active.showIcon()));
            }
        }
    };

    private static final SetBonus FLARE_BONUS = intervalBuff(MobEffects.FIRE_RESISTANCE, 0, BUFF_DURATION_TICKS);

    private static final SetBonus CRYSTAL_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, BUFF_DURATION_TICKS, 0));
        player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, BUFF_DURATION_TICKS, 0));
    };

    private static final SetBonus SPEED_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BUFF_DURATION_TICKS, 0));
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, BUFF_DURATION_TICKS, 0));
    };

    private static final SetBonus BLACK_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, SHORT_BUFF_DURATION_TICKS, 0));
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, BUFF_DURATION_TICKS, 0));
    };

    private static final SetBonus PEARL_BONUS = intervalBuff(MobEffects.SLOW_FALLING, 0, BUFF_DURATION_TICKS);

    private static final SetBonus LEAFY_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, BUFF_DURATION_TICKS, 0));
        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, SHORT_BUFF_DURATION_TICKS, 0));
    };

    private static final SetBonus SYLVIA_BONUS = intervalBuff(MobEffects.ABSORPTION, 1, BUFF_DURATION_TICKS);

    private static final SetBonus SUNSHINE_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, BUFF_DURATION_TICKS, 0));
        for (Holder<MobEffect> debuff : SUNSHINE_CLEANSED) {
            if (player.getEffect(debuff) != null) {
                player.removeEffect(debuff);
            }
        }
    };

    /**
     * Interval bonuses keyed by armor material. Lazuli is handled purely in the damage hook
     * (thorns-style retaliation needs an attacker, which the interval tick lacks).
     */
    private static final Map<Holder<ArmorMaterial>, SetBonus> INTERVAL_BONUSES = buildIntervalBonuses();

    private static Map<Holder<ArmorMaterial>, SetBonus> buildIntervalBonuses() {
        Map<Holder<ArmorMaterial>, SetBonus> map = new LinkedHashMap<>();
        map.put(ModArmorMaterials.DAYDREAM, DAYDREAM_BONUS);
        map.put(ModArmorMaterials.NIGHTMARE, NIGHTMARE_BONUS);
        map.put(ModArmorMaterials.FLARE, FLARE_BONUS);
        map.put(ModArmorMaterials.CRYSTAL, CRYSTAL_BONUS);
        map.put(ModArmorMaterials.SPEED, SPEED_BONUS);
        map.put(ModArmorMaterials.BLACK, BLACK_BONUS);
        map.put(ModArmorMaterials.PEARL, PEARL_BONUS);
        map.put(ModArmorMaterials.LEAFY, LEAFY_BONUS);
        map.put(ModArmorMaterials.SYLVIA, SYLVIA_BONUS);
        map.put(ModArmorMaterials.SUNSHINE, SUNSHINE_BONUS);
        return Map.copyOf(map);
    }

    private ArmorSetEffectHandler() {
    }

    /**
     * Builds a single-effect interval bonus.
     *
     * @param effect The effect to apply.
     * @param amplifier The effect amplifier.
     * @param durationTicks The effect duration.
     * @return A bonus applying the effect on a successful additive roll.
     */
    private static SetBonus intervalBuff(Holder<MobEffect> effect, int amplifier, int durationTicks) {
        return (player, piecesWorn) -> {
            if (!rollSucceeds(player, piecesWorn)) {
                return;
            }
            player.addEffect(new MobEffectInstance(effect, durationTicks, amplifier));
        };
    }

    /**
     * Single additive roll: each worn piece contributes {@value #PER_PIECE_CHANCE}, so a full set
     * always succeeds.
     *
     * @param player The player rolling.
     * @param piecesWorn Number of matching armor pieces worn (1-4).
     * @return True when the bonus triggers.
     */
    static boolean rollSucceeds(Player player, int piecesWorn) {
        return player.getRandom().nextFloat() < PER_PIECE_CHANCE * piecesWorn;
    }

    /**
     * Fires once per player per tick (both sides); filters to the server-side interval tick.
     *
     * @param event The post-tick player event.
     */
    @SubscribeEvent
    public static void onPlayerPostTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide) {
            return;
        }
        if (player.tickCount % INTERVAL_TICKS != 0) {
            return;
        }
        if (player.isSpectator() || player.isDeadOrDying()) {
            return;
        }
        for (Map.Entry<Holder<ArmorMaterial>, SetBonus> entry : INTERVAL_BONUSES.entrySet()) {
            Holder<ArmorMaterial> material = entry.getKey();
            if (material == null) {
                continue;
            }
            int pieces = countWornPieces(player, material);
            if (pieces > 0) {
                entry.getValue().apply(player, pieces);
            }
        }
    }

    /**
     * Blocks incoming mitigated effects outright on a successful additive Nightmare roll, so
     * Wither/Poison/Slowness damage is prevented before it starts.
     *
     * @param event The effect-applicability event.
     */
    @SubscribeEvent
    public static void onEffectApplicable(MobEffectEvent.Applicable event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) {
            return;
        }
        if (player.level().isClientSide) {
            return;
        }
        MobEffectInstance incoming = event.getEffectInstance();
        if (incoming == null || !NIGHTMARE_MITIGATED.contains(incoming.getEffect())) {
            return;
        }
        if (ModArmorMaterials.NIGHTMARE == null) {
            return;
        }
        int nightmarePieces = countWornPieces(player, ModArmorMaterials.NIGHTMARE);
        if (nightmarePieces > 0 && rollSucceeds(player, nightmarePieces)) {
            event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
        }
    }

    /**
     * Damage hook for Lazuli's thorns-style retaliation: attackers are chilled with Slowness II
     * on a successful additive roll.
     *
     * @param event The pre-damage event.
     */
    @SubscribeEvent
    public static void onLivingDamagePre(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (player.level().isClientSide) {
            return;
        }
        if (ModArmorMaterials.LAZULI == null) {
            return;
        }
        Entity attacker = event.getSource().getEntity();
        if (!(attacker instanceof LivingEntity livingAttacker)) {
            return;
        }
        int lazuliPieces = countWornPieces(player, ModArmorMaterials.LAZULI);
        if (lazuliPieces > 0 && rollSucceeds(player, lazuliPieces)) {
            livingAttacker.addEffect(
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, RETALIATION_DURATION_TICKS, 1));
        }
    }

    /**
     * Negates ender-pearl landing damage for Pearl wearers on a successful additive roll.
     *
     * @param event The server-side ender-pearl landing event.
     */
    @SubscribeEvent
    public static void onEnderPearlLand(EntityTeleportEvent.EnderPearl event) {
        if (ModArmorMaterials.PEARL == null) {
            return;
        }
        Player player = event.getPlayer();
        int pearlPieces = countWornPieces(player, ModArmorMaterials.PEARL);
        if (pearlPieces > 0 && rollSucceeds(player, pearlPieces)) {
            event.setAttackDamage(0.0F);
        }
    }

    /**
     * Counts armor slots whose {@link ArmorItem} material matches the given holder.
     *
     * @param player The player whose armor slots to inspect.
     * @param material The armor material holder to match.
     * @return Number of matching worn pieces (0-4).
     */
    static int countWornPieces(Player player, Holder<ArmorMaterial> material) {
        ArmorMaterial target;
        try {
            target = material.value();
        } catch (IllegalStateException notBoundYet) {
            return 0;
        }
        int count = 0;
        for (ItemStack stack : player.getInventory().armor) {
            if (stack.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial().value() == target) {
                count++;
            }
        }
        return count;
    }
}
