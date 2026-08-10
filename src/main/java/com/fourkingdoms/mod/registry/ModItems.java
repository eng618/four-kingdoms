package com.fourkingdoms.mod.registry;

import com.fourkingdoms.mod.FourKingdomsMod;
import com.fourkingdoms.mod.item.DaydreamSpearItem;
import com.fourkingdoms.mod.material.ModArmorMaterials;
import com.fourkingdoms.mod.material.ModToolMaterials;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * <h1>ModItems Registry</h1>
 * <p>
 * Central registry for all item instances in the <b>Four Kingdoms Mod</b> using NeoForge {@link DeferredRegister.Items}.
 * </p>
 *
 * <h2>Daydream Character Set (Dream Kingdom)</h2>
 * <ul>
 *   <li><b>Primary Weapon:</b> {@link #DAYDREAM_SPEAR} - Custom polearm weapon with bonus attack reach.</li>
 *   <li><b>Armor Set:</b> {@link #DAYDREAM_HELMET}, {@link #DAYDREAM_CHESTPLATE}, {@link #DAYDREAM_LEGGINGS}, {@link #DAYDREAM_BOOTS}.</li>
 *   <li><b>Tool Suite:</b> {@link #DAYDREAM_PICKAXE}, {@link #DAYDREAM_AXE}, {@link #DAYDREAM_SHOVEL}, {@link #DAYDREAM_HOE}.</li>
 * </ul>
 *
 * <h2>How to Add a New Item in the Future</h2>
 * <pre>{@code
 * public static final DeferredItem<Item> MY_NEW_ITEM = ITEMS.register("my_new_item",
 *         () -> new Item(new Item.Properties()));
 * }</pre>
 *
 * @author EnGarcia
 * @see DaydreamSpearItem
 * @see ModArmorMaterials
 * @see ModToolMaterials
 */
public class ModItems {
    /**
     * Primary DeferredRegister instance for all items in {@code four_kingdoms}.
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FourKingdomsMod.MOD_ID);

    // =========================================================================
    // DAYDREAM CHARACTER SET - DREAM KINGDOM
    // =========================================================================

    /**
     * Daydream's Signature Weapon: A specialized spear featuring extended entity reach (+1.5 blocks)
     * and rapid thrusting attack capability.
     */
    public static final DeferredItem<Item> DAYDREAM_SPEAR = ITEMS.register("daydream_spear",
            () -> new DaydreamSpearItem(ModToolMaterials.DAYDREAM, 4.5F, -2.4F, new Item.Properties()));

    /**
     * Daydream's Helmet - Ethereal headpiece crafted from amethyst and diamonds.
     */
    public static final DeferredItem<ArmorItem> DAYDREAM_HELMET = ITEMS.registerItem("daydream_helmet",
            props -> new ArmorItem(ModArmorMaterials.DAYDREAM, ArmorItem.Type.HELMET, props));

    /**
     * Daydream's Chestplate - Radiantly forged chest armor with high protection and knockback resistance.
     */
    public static final DeferredItem<ArmorItem> DAYDREAM_CHESTPLATE = ITEMS.registerItem("daydream_chestplate",
            props -> new ArmorItem(ModArmorMaterials.DAYDREAM, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Daydream's Leggings - Lightweight grey-white leg armor offering mobility and defense.
     */
    public static final DeferredItem<ArmorItem> DAYDREAM_LEGGINGS = ITEMS.registerItem("daydream_leggings",
            props -> new ArmorItem(ModArmorMaterials.DAYDREAM, ArmorItem.Type.LEGGINGS, props));

    /**
     * Daydream's Boots - Amethyst-trimmed boots completing the Daydream set.
     */
    public static final DeferredItem<ArmorItem> DAYDREAM_BOOTS = ITEMS.registerItem("daydream_boots",
            props -> new ArmorItem(ModArmorMaterials.DAYDREAM, ArmorItem.Type.BOOTS, props));

    /**
     * Daydream's Pickaxe - High-durability pickaxe capable of mining diamond-tier ores swiftly.
     */
    public static final DeferredItem<PickaxeItem> DAYDREAM_PICKAXE = ITEMS.register("daydream_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.DAYDREAM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.DAYDREAM, 1.0F, -2.8F))));

    /**
     * Daydream's Axe - Heavy woodsman tool and devastating secondary weapon.
     */
    public static final DeferredItem<AxeItem> DAYDREAM_AXE = ITEMS.register("daydream_axe",
            () -> new AxeItem(ModToolMaterials.DAYDREAM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.DAYDREAM, 5.0F, -3.0F))));

    /**
     * Daydream's Shovel - Excavation tool infused with amethyst speed.
     */
    public static final DeferredItem<ShovelItem> DAYDREAM_SHOVEL = ITEMS.register("daydream_shovel",
            () -> new ShovelItem(ModToolMaterials.DAYDREAM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.DAYDREAM, 1.5F, -3.0F))));

    /**
     * Daydream's Hoe - Agricultural tool with high enchantability.
     */
    public static final DeferredItem<HoeItem> DAYDREAM_HOE = ITEMS.register("daydream_hoe",
            () -> new HoeItem(ModToolMaterials.DAYDREAM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.DAYDREAM, -3.0F, 0.0F))));
}
