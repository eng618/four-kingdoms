package com.fourkingdoms.mod.material;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolMaterials {
    public static final Tier DAYDREAM = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1750,                                    // Durability (uses)
            8.5F,                                    // Mining Speed
            3.5F,                                    // Attack Damage Bonus
            18,                                      // Enchantability
            () -> Ingredient.of(Items.AMETHYST_SHARD, Items.DIAMOND)
    );
}
