package com.fourkingdoms.mod.event;

import net.minecraft.world.entity.player.Player;

/**
 * <h1>SetBonus</h1>
 * <p>
 * Strategy interface for hero armor set bonuses. Each hero set (Daydream, Nightmare, future
 * Element/Forgotten sets) provides one implementation; {@link ArmorSetEffectHandler} invokes it
 * once per bonus interval with the number of matching pieces currently worn.
 * </p>
 *
 * <p>
 * Implementations must be server-side safe (called only when
 * {@code !player.level().isClientSide}) and cheap — they run at most once every
 * {@link ArmorSetEffectHandler#INTERVAL_TICKS} ticks per player.
 * </p>
 */
public interface SetBonus {
    /**
     * Applies this set's bonus effect.
     *
     * @param player The server-side player wearing the armor.
     * @param piecesWorn Number of matching armor pieces worn (1-4).
     */
    void apply(Player player, int piecesWorn);
}
