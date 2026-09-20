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

    // =========================================================================
    // NIGHTMARE CHARACTER SET - DREAM KINGDOM
    // =========================================================================

    /**
     * Nightmare's Signature Weapon: A shadow-forged sword balancing heavy damage with steady speed.
     */
    public static final DeferredItem<SwordItem> NIGHTMARE_SWORD = ITEMS.register("nightmare_sword",
            () -> new SwordItem(ModToolMaterials.NIGHTMARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.NIGHTMARE, 3.0F, -2.4F))));

    /**
     * Nightmare's Helmet - Shadow-veiled helm that shrugs off dark afflictions.
     */
    public static final DeferredItem<ArmorItem> NIGHTMARE_HELMET = ITEMS.registerItem("nightmare_helmet",
            props -> new ArmorItem(ModArmorMaterials.NIGHTMARE, ArmorItem.Type.HELMET, props));

    /**
     * Nightmare's Chestplate - Heavy shadow plate with added knockback resistance.
     */
    public static final DeferredItem<ArmorItem> NIGHTMARE_CHESTPLATE = ITEMS.registerItem("nightmare_chestplate",
            props -> new ArmorItem(ModArmorMaterials.NIGHTMARE, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Nightmare's Leggings - Dark leg guards echoing with sculk resonance.
     */
    public static final DeferredItem<ArmorItem> NIGHTMARE_LEGGINGS = ITEMS.registerItem("nightmare_leggings",
            props -> new ArmorItem(ModArmorMaterials.NIGHTMARE, ArmorItem.Type.LEGGINGS, props));

    /**
     * Nightmare's Boots - Silent shadow-treading boots completing the Nightmare set.
     */
    public static final DeferredItem<ArmorItem> NIGHTMARE_BOOTS = ITEMS.registerItem("nightmare_boots",
            props -> new ArmorItem(ModArmorMaterials.NIGHTMARE, ArmorItem.Type.BOOTS, props));

    /**
     * Nightmare's Pickaxe - Sculk-hardened pickaxe for deep delving.
     */
    public static final DeferredItem<PickaxeItem> NIGHTMARE_PICKAXE = ITEMS.register("nightmare_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.NIGHTMARE, 1.0F, -2.8F))));

    /**
     * Nightmare's Axe - Brutal shadow axe doubling as a weapon.
     */
    public static final DeferredItem<AxeItem> NIGHTMARE_AXE = ITEMS.register("nightmare_axe",
            () -> new AxeItem(ModToolMaterials.NIGHTMARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.NIGHTMARE, 5.0F, -3.0F))));

    /**
     * Nightmare's Shovel - Excavation tool humming with echo energy.
     */
    public static final DeferredItem<ShovelItem> NIGHTMARE_SHOVEL = ITEMS.register("nightmare_shovel",
            () -> new ShovelItem(ModToolMaterials.NIGHTMARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.NIGHTMARE, 1.5F, -3.0F))));

    /**
     * Nightmare's Hoe - Tilling tool touched by the deep dark.
     */
    public static final DeferredItem<HoeItem> NIGHTMARE_HOE = ITEMS.register("nightmare_hoe",
            () -> new HoeItem(ModToolMaterials.NIGHTMARE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.NIGHTMARE, -3.0F, 0.0F))));

    // =========================================================================
    // INFUSED LEATHERS (ARMOR CRAFTING MATERIALS)
    // =========================================================================

    /**
     * Amethyst-Infused Leather - Specialized leather infused with amethyst essence.
     */
    public static final DeferredItem<Item> AMETHYST_INFUSED_LEATHER = ITEMS.registerSimpleItem("amethyst_infused_leather");

    /**
     * Copper-Infused Leather - Flexible leather infused with copper conductivity.
     */
    public static final DeferredItem<Item> COPPER_INFUSED_LEATHER = ITEMS.registerSimpleItem("copper_infused_leather");

    /**
     * Diamond-Infused Leather - High-durability leather infused with diamond resilience.
     */
    public static final DeferredItem<Item> DIAMOND_INFUSED_LEATHER = ITEMS.registerSimpleItem("diamond_infused_leather");

    /**
     * Echo-Infused Leather - Mystical leather infused with sculk and echo shards.
     */
    public static final DeferredItem<Item> ECHO_INFUSED_LEATHER = ITEMS.registerSimpleItem("echo_infused_leather");

    /**
     * Gold-Infused Leather - Gilded leather offering magical receptivity.
     */
    public static final DeferredItem<Item> GOLD_INFUSED_LEATHER = ITEMS.registerSimpleItem("gold_infused_leather");

    /**
     * Iron-Infused Leather - Reinforced leather hardened with iron plates.
     */
    public static final DeferredItem<Item> IRON_INFUSED_LEATHER = ITEMS.registerSimpleItem("iron_infused_leather");

    /**
     * Netherite-Infused Leather - Heavy-duty heat-resistant leather infused with netherite.
     */
    public static final DeferredItem<Item> NETHERITE_INFUSED_LEATHER = ITEMS.registerSimpleItem("netherite_infused_leather");

    /**
     * Quartz-Infused Leather - Crystal-infused leather with sharp energetic properties.
     */
    public static final DeferredItem<Item> QUARTZ_INFUSED_LEATHER = ITEMS.registerSimpleItem("quartz_infused_leather");
}
