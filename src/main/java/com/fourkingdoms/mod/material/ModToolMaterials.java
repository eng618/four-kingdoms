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

    public static final Tier CRYSTAL = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1700,
            8.5F,
            3.5F,
            16,
            () -> Ingredient.of(Items.HEART_OF_THE_SEA, Items.DIAMOND));

    public static final Tier SPEED = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1500,
            9.0F,
            3.0F,
            20,
            () -> Ingredient.of(Items.COPPER_INGOT, Items.IRON_INGOT));

    public static final Tier BLACK = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            2200,
            7.5F,
            4.5F,
            12,
            () -> Ingredient.of(Items.NETHERITE_SCRAP));

    public static final Tier PEARL = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1600,
            8.0F,
            3.5F,
            18,
            () -> Ingredient.of(Items.ENDER_PEARL, Items.DIAMOND));

    public static final Tier LAZULI = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1750,
            8.0F,
            3.5F,
            14,
            () -> Ingredient.of(Items.PACKED_ICE, Items.DIAMOND));

    public static final Tier LEAFY = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1500,
            8.0F,
            3.0F,
            16,
            () -> Ingredient.of(Items.JUNGLE_LEAVES, Items.DIAMOND));

    public static final Tier SYLVIA = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            2000,
            8.0F,
            4.0F,
            18,
            () -> Ingredient.of(Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT));

    public static final Tier SUNSHINE = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1700,
            8.5F,
            3.5F,
            16,
            () -> Ingredient.of(Items.IRON_INGOT));
}
