package com.fourkingdoms.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

/**
 * <h1>Daydream Spear Item</h1>
 * <p>
 * <b>Daydream's Spear</b> — the signature melee polearm of the Dream Kingdom's hero character.
 * Thin specialization of {@link KingdomSpearItem} with Daydream's tuned reach.
 * </p>
 *
 * @author EnGarcia
 * @see KingdomSpearItem
 * @see Tier
 */
public class DaydreamSpearItem extends KingdomSpearItem {
    /** Daydream's bonus entity interaction reach in blocks. */
    public static final double REACH = 1.5D;

    /**
     * Constructs a new DaydreamSpearItem instance.
     *
     * @param tier The {@link Tier} defining durability and attack bonus.
     * @param attackDamage Additional attack damage bonus for the spear.
     * @param attackSpeed Attack speed modifier (negative value relative to base 4.0 speed).
     * @param properties Base item properties.
     */
    public DaydreamSpearItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, REACH, properties);
    }
}
