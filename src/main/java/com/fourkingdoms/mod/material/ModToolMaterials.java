package com.fourkingdoms.mod.material;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolMaterials {
    public static final Tier DAYDREAM = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1750, // Durability (uses)
            8.5F, // Mining Speed
            3.5F, // Attack Damage Bonus
            18, // Enchantability
            () -> Ingredient.of(Items.AMETHYST_SHARD, Items.DIAMOND));

    public static final Tier NIGHTMARE = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1800, // Durability (uses)
            8.0F, // Mining Speed
            4.0F, // Attack Damage Bonus
            15, // Enchantability
            () -> Ingredient.of(Items.ECHO_SHARD, Items.NETHERITE_SCRAP));

    public static final Tier FLARE = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1600, // Durability (uses)
            8.0F, // Mining Speed
            4.0F, // Attack Damage Bonus
            14, // Enchantability
            () -> Ingredient.of(Items.BLAZE_ROD, Items.IRON_INGOT));
}
