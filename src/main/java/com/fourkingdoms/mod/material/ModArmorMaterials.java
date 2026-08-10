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
}
