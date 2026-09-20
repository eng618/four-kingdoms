package com.fourkingdoms.mod.material;

import com.fourkingdoms.mod.FourKingdomsMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, FourKingdomsMod.MOD_ID);

    public static final Holder<ArmorMaterial> DAYDREAM = ARMOR_MATERIALS.register("daydream", () -> new ArmorMaterial(
            // 1. Defense map (Helmet: 3, Chestplate: 8, Leggings: 6, Boots: 3)
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            // 2. Enchantability
            18,
            // 3. Equip Sound
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            // 4. Repair Ingredient (Amethyst Shard & Diamond)
            () -> Ingredient.of(Items.AMETHYST_SHARD, Items.DIAMOND),
            // 5. Equipment Layer Texture
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "daydream"))),
            // 6. Toughness
            2.0F,
            // 7. Knockback Resistance
            0.05F
    ));

    public static final Holder<ArmorMaterial> NIGHTMARE = ARMOR_MATERIALS.register("nightmare", () -> new ArmorMaterial(
            // 1. Defense map (Helmet: 3, Chestplate: 8, Leggings: 6, Boots: 3) — shadow mirror of Daydream
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            // 2. Enchantability
            15,
            // 3. Equip Sound
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            // 4. Repair Ingredient (Echo Shard & Netherite Scrap, per hero roster)
            () -> Ingredient.of(Items.ECHO_SHARD, Items.NETHERITE_SCRAP),
            // 5. Equipment Layer Texture
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "nightmare"))),
            // 6. Toughness
            2.5F,
            // 7. Knockback Resistance
            0.1F
    ));

    public static final Holder<ArmorMaterial> FLARE = ARMOR_MATERIALS.register("flare", () -> new ArmorMaterial(
            // 1. Defense map (Helmet: 3, Chestplate: 7, Leggings: 5, Boots: 3) — offense-skewed fire set
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            // 2. Enchantability
            15,
            // 3. Equip Sound
            SoundEvents.ARMOR_EQUIP_IRON,
            // 4. Repair Ingredient (Blaze Rod & Iron Ingot, per hero roster)
            () -> Ingredient.of(Items.BLAZE_ROD, Items.IRON_INGOT),
            // 5. Equipment Layer Texture
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "flare"))),
            // 6. Toughness
            1.5F,
            // 7. Knockback Resistance
            0.0F
    ));

    public static final Holder<ArmorMaterial> CRYSTAL = ARMOR_MATERIALS.register("crystal", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            16,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            () -> Ingredient.of(Items.HEART_OF_THE_SEA, Items.DIAMOND),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "crystal"))),
            2.0F,
            0.05F));

    public static final Holder<ArmorMaterial> SPEED = ARMOR_MATERIALS.register("speed", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.BOOTS, 2);
            }),
            20,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            () -> Ingredient.of(Items.COPPER_INGOT, Items.IRON_INGOT),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "speed"))),
            0.5F,
            0.0F));

    public static final Holder<ArmorMaterial> BLACK = ARMOR_MATERIALS.register("black", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 4);
            }),
            12,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(Items.NETHERITE_SCRAP),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "black"))),
            3.0F,
            0.1F));

    public static final Holder<ArmorMaterial> PEARL = ARMOR_MATERIALS.register("pearl", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            18,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(Items.ENDER_PEARL, Items.DIAMOND),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "pearl"))),
            1.0F,
            0.0F));

    public static final Holder<ArmorMaterial> LAZULI = ARMOR_MATERIALS.register("lazuli", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            14,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(Items.PACKED_ICE, Items.DIAMOND),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "lazuli"))),
            2.0F,
            0.05F));

    public static final Holder<ArmorMaterial> LEAFY = ARMOR_MATERIALS.register("leafy", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            16,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(Items.JUNGLE_LEAVES, Items.DIAMOND),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "leafy"))),
            1.0F,
            0.0F));

    public static final Holder<ArmorMaterial> SYLVIA = ARMOR_MATERIALS.register("sylvia", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            18,
            SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "sylvia"))),
            2.0F,
            0.1F));

    public static final Holder<ArmorMaterial> SUNSHINE = ARMOR_MATERIALS.register("sunshine", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            16,
            SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(Items.IRON_INGOT),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(FourKingdomsMod.MOD_ID, "sunshine"))),
            1.0F,
            0.05F));
}
