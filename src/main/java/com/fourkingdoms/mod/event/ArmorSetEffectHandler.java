package com.fourkingdoms.mod.event;

import com.fourkingdoms.mod.material.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.List;

/**
 * <h1>ArmorSetEffectHandler</h1>
 * <p>
 * Server-side tick handler implementing hero armor set bonuses.
 * Registered on {@code NeoForge.EVENT_BUS} from {@code FourKingdomsMod} (game bus, not the mod bus).
 * </p>
 *
 * <h2>Bonuses</h2>
 * <ul>
 *   <li><b>Daydream:</b> every {@value #INTERVAL_TICKS} ticks, each worn piece rolls
 *       {@value #PER_PIECE_CHANCE} independently; on any success the player gains
 *       Speed II + Regeneration I for {@value #BUFF_DURATION_TICKS} ticks.</li>
 *   <li><b>Nightmare (option A — shorten/cleanse):</b> same interval and per-piece roll, but only
 *       while the wearer suffers Wither, Poison, or Slowness. Each success halves the remaining
 *       duration of one bad effect (cleansing it outright when under {@value #CLEANSE_THRESHOLD_TICKS}
 *       ticks remain).</li>
 * </ul>
 */
public final class ArmorSetEffectHandler {
    /** Bonus roll interval: 20 seconds. */
    public static final int INTERVAL_TICKS = 400;

    /** Independent success chance per worn piece. */
    public static final float PER_PIECE_CHANCE = 0.25F;

    /** Duration of the Daydream buffs. */
    public static final int BUFF_DURATION_TICKS = 400;

    /** Remaining durations at or below this are cleansed instead of halved. */
    public static final int CLEANSE_THRESHOLD_TICKS = 100;

    /** Bad effects Nightmare mitigates. */
    private static final List<Holder<MobEffect>> NIGHTMARE_MITIGATED = List.of(
            MobEffects.WITHER, MobEffects.POISON, MobEffects.MOVEMENT_SLOWDOWN);

    private static final SetBonus DAYDREAM_BONUS = (player, piecesWorn) -> {
        boolean triggered = false;
        for (int i = 0; i < piecesWorn; i++) {
            if (player.getRandom().nextFloat() < PER_PIECE_CHANCE) {
                triggered = true;
                break;
            }
        }
        if (!triggered) {
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
            boolean mitigated = false;
            for (int i = 0; i < piecesWorn; i++) {
                if (player.getRandom().nextFloat() < PER_PIECE_CHANCE) {
                    mitigated = true;
                    break;
                }
            }
            if (!mitigated) {
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

    private ArmorSetEffectHandler() {
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
