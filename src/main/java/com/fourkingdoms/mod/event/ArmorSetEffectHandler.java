package com.fourkingdoms.mod.event;

import com.fourkingdoms.mod.material.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.List;

/**
 * <h1>ArmorSetEffectHandler</h1>
 * <p>
 * Server-side handler implementing hero armor set bonuses.
 * Registered on {@code NeoForge.EVENT_BUS} from {@code FourKingdomsMod} (game bus, not the mod bus).
 * </p>
 *
 * <h2>Chance model (additive)</h2>
 * <p>
 * Each worn piece adds {@value #PER_PIECE_CHANCE} to a single roll per interval, so 1 piece = 25%,
 * 2 = 50%, 3 = 75%, and a full 4-piece set always triggers (100%).
 * </p>
 *
 * <h2>Bonuses</h2>
 * <ul>
 *   <li><b>Daydream:</b> every {@value #INTERVAL_TICKS} ticks, one additive roll; on success the player
 *       gains Speed II + Regeneration I for {@value #BUFF_DURATION_TICKS} ticks.</li>
 *   <li><b>Nightmare (prevent + cleanse):</b> incoming Wither/Poison/Slowness is blocked outright on a
 *       successful additive roll ({@code MobEffectEvent.Applicable} denied); effects already active are
 *       halved in remaining duration on the interval tick (cleansed outright when under
 *       {@value #CLEANSE_THRESHOLD_TICKS} ticks remain).</li>
 *   <li><b>Flare (Element pilot):</b> every {@value #INTERVAL_TICKS} ticks, one additive roll;
 *       on success the player gains Fire Resistance for {@value #BUFF_DURATION_TICKS} ticks.</li>
 * </ul>
 */
public final class ArmorSetEffectHandler {
    /** Bonus roll interval: 20 seconds. */
    public static final int INTERVAL_TICKS = 400;

    /** Chance added per worn piece to the single roll (0.25 x pieces; full set = guaranteed). */
    public static final float PER_PIECE_CHANCE = 0.25F;

    /** Duration of the Daydream buffs. */
    public static final int BUFF_DURATION_TICKS = 400;

    /** Remaining durations at or below this are cleansed instead of halved. */
    public static final int CLEANSE_THRESHOLD_TICKS = 100;

    /** Bad effects Nightmare mitigates. Extend here for future "and more" coverage. */
    private static final List<Holder<MobEffect>> NIGHTMARE_MITIGATED = List.of(
            MobEffects.WITHER, MobEffects.POISON, MobEffects.MOVEMENT_SLOWDOWN);

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

    private static final SetBonus FLARE_BONUS = (player, piecesWorn) -> {
        if (!rollSucceeds(player, piecesWorn)) {
            return;
        }
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, BUFF_DURATION_TICKS, 0));
    };

    private ArmorSetEffectHandler() {
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
        int daydreamPieces = countWornPieces(player, ModArmorMaterials.DAYDREAM);
        if (daydreamPieces > 0) {
            DAYDREAM_BONUS.apply(player, daydreamPieces);
        }
        // Nightmare material is registered alongside Daydream; guard for load order safety.
        if (ModArmorMaterials.NIGHTMARE != null) {
            int nightmarePieces = countWornPieces(player, ModArmorMaterials.NIGHTMARE);
            if (nightmarePieces > 0) {
                NIGHTMARE_BONUS.apply(player, nightmarePieces);
            }
        }
        if (ModArmorMaterials.FLARE != null) {
            int flarePieces = countWornPieces(player, ModArmorMaterials.FLARE);
            if (flarePieces > 0) {
                FLARE_BONUS.apply(player, flarePieces);
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
