package com.fourkingdoms.mod.item;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

/**
 * <h1>Daydream Spear Item</h1>
 * <p>
 * Custom weapon class representing <b>Daydream's Spear</b> — the signature melee polearm weapon
 * of the Dream Kingdom's hero character.
 * </p>
 *
 * <h2>Special Characteristics</h2>
 * <ul>
 *   <li><b>Extended Attack Reach:</b> Adds +1.5 blocks to standard player entity interaction range via {@link Attributes#ENTITY_INTERACTION_RANGE}.</li>
 *   <li><b>High Attack Damage:</b> Scales with {@link Tier#getAttackDamageBonus()}.</li>
 *   <li><b>Balanced Attack Speed:</b> Configured for responsive thrusting combat.</li>
 * </ul>
 *
 * @author EnGarcia
 * @see Tier
 */
public class DaydreamSpearItem extends Item {
    /**
     * Constructs a new DaydreamSpearItem instance.
     *
     * @param tier         The {@link Tier} defining durability and attack bonus.
     * @param attackDamage Additional attack damage bonus for the spear.
     * @param attackSpeed  Attack speed modifier (negative value relative to base 4.0 speed).
     * @param properties   Base item properties.
     */
    public DaydreamSpearItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties
                .durability(tier.getUses())
                .attributes(createSpearAttributes(tier, attackDamage, attackSpeed)));
    }

    /**
     * Builds attribute modifiers for the spear when held in the main hand.
     *
     * @param tier         Tool tier material properties.
     * @param attackDamage Spear attack damage bonus.
     * @param attackSpeed  Spear attack speed modifier.
     * @return Formatted {@link ItemAttributeModifiers} containing damage, speed, and entity reach bonuses.
     */
    private static ItemAttributeModifiers createSpearAttributes(Tier tier, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID.withSuffix(".reach"), 1.5D, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }
}
