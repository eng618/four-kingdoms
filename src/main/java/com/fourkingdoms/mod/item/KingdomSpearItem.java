package com.fourkingdoms.mod.item;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

/**
 * <h1>Kingdom Spear Item</h1>
 * <p>
 * Shared base class for polearm weapons (spears, tridents) across all kingdom hero sets.
 * Adds bonus damage, attack speed, and extended entity interaction reach when held in the main hand.
 * </p>
 *
 * @author EnGarcia
 * @see Tier
 */
public class KingdomSpearItem extends Item {
    /**
     * Constructs a new KingdomSpearItem instance.
     *
     * @param tier The {@link Tier} defining durability and attack bonus.
     * @param attackDamage Additional attack damage bonus for the weapon.
     * @param attackSpeed Attack speed modifier (negative value relative to base 4.0 speed).
     * @param reach Bonus blocks added to entity interaction range.
     * @param properties Base item properties.
     */
    public KingdomSpearItem(Tier tier, float attackDamage, float attackSpeed, double reach, Item.Properties properties) {
        super(properties.durability(tier.getUses()).attributes(createSpearAttributes(tier, attackDamage, attackSpeed, reach)));
    }

    /**
     * Builds attribute modifiers for the weapon when held in the main hand.
     *
     * @param tier Tool tier material properties.
     * @param attackDamage Weapon attack damage bonus.
     * @param attackSpeed Weapon attack speed modifier.
     * @param reach Bonus entity interaction range.
     * @return Formatted {@link ItemAttributeModifiers} containing damage, speed, and entity reach bonuses.
     */
    protected static ItemAttributeModifiers createSpearAttributes(Tier tier, float attackDamage, float attackSpeed, double reach) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID.withSuffix(".reach"), reach, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .build();
    }
}
