package com.fourkingdoms.mod.registry;

import com.fourkingdoms.mod.FourKingdomsMod;
import com.fourkingdoms.mod.item.DaydreamSpearItem;
import com.fourkingdoms.mod.item.KingdomSpearItem;
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
    // FLARE CHARACTER SET - ELEMENT KINGDOM (pilot slice, Phase 3)
    // =========================================================================

    /**
     * Flare's Signature Weapon: A fire-tempered sword with heavy damage.
     */
    public static final DeferredItem<SwordItem> FLARE_SWORD = ITEMS.register("flare_sword",
            () -> new SwordItem(ModToolMaterials.FLARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.FLARE, 3.0F, -2.4F))));

    /**
     * Flare's Helmet - Heat-forged helm crackling with blaze energy.
     */
    public static final DeferredItem<ArmorItem> FLARE_HELMET = ITEMS.registerItem("flare_helmet",
            props -> new ArmorItem(ModArmorMaterials.FLARE, ArmorItem.Type.HELMET, props));

    /**
     * Flare's Chestplate - Offense-skewed fire plate trading defense for power.
     */
    public static final DeferredItem<ArmorItem> FLARE_CHESTPLATE = ITEMS.registerItem("flare_chestplate",
            props -> new ArmorItem(ModArmorMaterials.FLARE, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Flare's Leggings - Swift ember-guards favoring mobility.
     */
    public static final DeferredItem<ArmorItem> FLARE_LEGGINGS = ITEMS.registerItem("flare_leggings",
            props -> new ArmorItem(ModArmorMaterials.FLARE, ArmorItem.Type.LEGGINGS, props));

    /**
     * Flare's Boots - Cinder-step boots completing the Flare set.
     */
    public static final DeferredItem<ArmorItem> FLARE_BOOTS = ITEMS.registerItem("flare_boots",
            props -> new ArmorItem(ModArmorMaterials.FLARE, ArmorItem.Type.BOOTS, props));

    /**
     * Flare's Pickaxe - Blaze-hardened pickaxe for nether delving.
     */
    public static final DeferredItem<PickaxeItem> FLARE_PICKAXE = ITEMS.register("flare_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.FLARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.FLARE, 1.0F, -2.8F))));

    /**
     * Flare's Axe - Wildfire axe doubling as a weapon.
     */
    public static final DeferredItem<AxeItem> FLARE_AXE = ITEMS.register("flare_axe",
            () -> new AxeItem(ModToolMaterials.FLARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.FLARE, 5.0F, -3.0F))));

    /**
     * Flare's Shovel - Excavation tool radiating furnace heat.
     */
    public static final DeferredItem<ShovelItem> FLARE_SHOVEL = ITEMS.register("flare_shovel",
            () -> new ShovelItem(ModToolMaterials.FLARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.FLARE, 1.5F, -3.0F))));

    /**
     * Flare's Hoe - Ashen tilling tool with a warm touch.
     */
    public static final DeferredItem<HoeItem> FLARE_HOE = ITEMS.register("flare_hoe",
            () -> new HoeItem(ModToolMaterials.FLARE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.FLARE, -3.0F, 0.0F))));

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

    // =========================================================================
    // CRYSTAL CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Crystal's Trident - ocean-forged trident humming with tide energy.
     */
    public static final DeferredItem<Item> CRYSTAL_TRIDENT = ITEMS.register("crystal_trident",
            () -> new KingdomSpearItem(ModToolMaterials.CRYSTAL, 5.0F, -2.8F, 1.5D, new Item.Properties()));

    /**
     * Crystal's Helmet.
     */
    public static final DeferredItem<ArmorItem> CRYSTAL_HELMET = ITEMS.registerItem("crystal_helmet",
            props -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.HELMET, props));

    /**
     * Crystal's Chestplate.
     */
    public static final DeferredItem<ArmorItem> CRYSTAL_CHESTPLATE = ITEMS.registerItem("crystal_chestplate",
            props -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Crystal's Leggings.
     */
    public static final DeferredItem<ArmorItem> CRYSTAL_LEGGINGS = ITEMS.registerItem("crystal_leggings",
            props -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.LEGGINGS, props));

    /**
     * Crystal's Boots.
     */
    public static final DeferredItem<ArmorItem> CRYSTAL_BOOTS = ITEMS.registerItem("crystal_boots",
            props -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.BOOTS, props));

    /**
     * Crystal's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.CRYSTAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.CRYSTAL, 1.0F, -2.8F))));

    /**
     * Crystal's Axe.
     */
    public static final DeferredItem<AxeItem> CRYSTAL_AXE = ITEMS.register("crystal_axe",
            () -> new AxeItem(ModToolMaterials.CRYSTAL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.CRYSTAL, 5.0F, -3.0F))));

    /**
     * Crystal's Shovel.
     */
    public static final DeferredItem<ShovelItem> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel",
            () -> new ShovelItem(ModToolMaterials.CRYSTAL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.CRYSTAL, 1.5F, -3.0F))));

    /**
     * Crystal's Hoe.
     */
    public static final DeferredItem<HoeItem> CRYSTAL_HOE = ITEMS.register("crystal_hoe",
            () -> new HoeItem(ModToolMaterials.CRYSTAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.CRYSTAL, -3.0F, 0.0F))));

    // =========================================================================
    // SPEED CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Speed's Longsword - storm-quickness blade built for rapid strikes.
     */
    public static final DeferredItem<SwordItem> SPEED_LONGSWORD = ITEMS.register("speed_longsword",
            () -> new SwordItem(ModToolMaterials.SPEED, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.SPEED, 3.0F, -2.2F))));

    /**
     * Speed's Helmet.
     */
    public static final DeferredItem<ArmorItem> SPEED_HELMET = ITEMS.registerItem("speed_helmet",
            props -> new ArmorItem(ModArmorMaterials.SPEED, ArmorItem.Type.HELMET, props));

    /**
     * Speed's Chestplate.
     */
    public static final DeferredItem<ArmorItem> SPEED_CHESTPLATE = ITEMS.registerItem("speed_chestplate",
            props -> new ArmorItem(ModArmorMaterials.SPEED, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Speed's Leggings.
     */
    public static final DeferredItem<ArmorItem> SPEED_LEGGINGS = ITEMS.registerItem("speed_leggings",
            props -> new ArmorItem(ModArmorMaterials.SPEED, ArmorItem.Type.LEGGINGS, props));

    /**
     * Speed's Boots.
     */
    public static final DeferredItem<ArmorItem> SPEED_BOOTS = ITEMS.registerItem("speed_boots",
            props -> new ArmorItem(ModArmorMaterials.SPEED, ArmorItem.Type.BOOTS, props));

    /**
     * Speed's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> SPEED_PICKAXE = ITEMS.register("speed_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.SPEED, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.SPEED, 1.0F, -2.8F))));

    /**
     * Speed's Axe.
     */
    public static final DeferredItem<AxeItem> SPEED_AXE = ITEMS.register("speed_axe",
            () -> new AxeItem(ModToolMaterials.SPEED, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.SPEED, 5.0F, -3.0F))));

    /**
     * Speed's Shovel.
     */
    public static final DeferredItem<ShovelItem> SPEED_SHOVEL = ITEMS.register("speed_shovel",
            () -> new ShovelItem(ModToolMaterials.SPEED, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.SPEED, 1.5F, -3.0F))));

    /**
     * Speed's Hoe.
     */
    public static final DeferredItem<HoeItem> SPEED_HOE = ITEMS.register("speed_hoe",
            () -> new HoeItem(ModToolMaterials.SPEED, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.SPEED, -3.0F, 0.0F))));

    // =========================================================================
    // BLACK CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Black's Blade - heavy shadow blade trading speed for brutal damage.
     */
    public static final DeferredItem<SwordItem> BLACK_BLADE = ITEMS.register("black_blade",
            () -> new SwordItem(ModToolMaterials.BLACK, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.BLACK, 4.0F, -2.6F))));

    /**
     * Black's Helmet.
     */
    public static final DeferredItem<ArmorItem> BLACK_HELMET = ITEMS.registerItem("black_helmet",
            props -> new ArmorItem(ModArmorMaterials.BLACK, ArmorItem.Type.HELMET, props));

    /**
     * Black's Chestplate.
     */
    public static final DeferredItem<ArmorItem> BLACK_CHESTPLATE = ITEMS.registerItem("black_chestplate",
            props -> new ArmorItem(ModArmorMaterials.BLACK, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Black's Leggings.
     */
    public static final DeferredItem<ArmorItem> BLACK_LEGGINGS = ITEMS.registerItem("black_leggings",
            props -> new ArmorItem(ModArmorMaterials.BLACK, ArmorItem.Type.LEGGINGS, props));

    /**
     * Black's Boots.
     */
    public static final DeferredItem<ArmorItem> BLACK_BOOTS = ITEMS.registerItem("black_boots",
            props -> new ArmorItem(ModArmorMaterials.BLACK, ArmorItem.Type.BOOTS, props));

    /**
     * Black's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> BLACK_PICKAXE = ITEMS.register("black_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.BLACK, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.BLACK, 1.0F, -2.8F))));

    /**
     * Black's Axe.
     */
    public static final DeferredItem<AxeItem> BLACK_AXE = ITEMS.register("black_axe",
            () -> new AxeItem(ModToolMaterials.BLACK, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.BLACK, 5.0F, -3.0F))));

    /**
     * Black's Shovel.
     */
    public static final DeferredItem<ShovelItem> BLACK_SHOVEL = ITEMS.register("black_shovel",
            () -> new ShovelItem(ModToolMaterials.BLACK, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.BLACK, 1.5F, -3.0F))));

    /**
     * Black's Hoe.
     */
    public static final DeferredItem<HoeItem> BLACK_HOE = ITEMS.register("black_hoe",
            () -> new HoeItem(ModToolMaterials.BLACK, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.BLACK, -3.0F, 0.0F))));

    // =========================================================================
    // PEARL CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Pearl's Scythe - ender-touched scythe that falls softly and strikes true.
     */
    public static final DeferredItem<SwordItem> PEARL_SCYTHE = ITEMS.register("pearl_scythe",
            () -> new SwordItem(ModToolMaterials.PEARL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.PEARL, 3.0F, -2.4F))));

    /**
     * Pearl's Helmet.
     */
    public static final DeferredItem<ArmorItem> PEARL_HELMET = ITEMS.registerItem("pearl_helmet",
            props -> new ArmorItem(ModArmorMaterials.PEARL, ArmorItem.Type.HELMET, props));

    /**
     * Pearl's Chestplate.
     */
    public static final DeferredItem<ArmorItem> PEARL_CHESTPLATE = ITEMS.registerItem("pearl_chestplate",
            props -> new ArmorItem(ModArmorMaterials.PEARL, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Pearl's Leggings.
     */
    public static final DeferredItem<ArmorItem> PEARL_LEGGINGS = ITEMS.registerItem("pearl_leggings",
            props -> new ArmorItem(ModArmorMaterials.PEARL, ArmorItem.Type.LEGGINGS, props));

    /**
     * Pearl's Boots.
     */
    public static final DeferredItem<ArmorItem> PEARL_BOOTS = ITEMS.registerItem("pearl_boots",
            props -> new ArmorItem(ModArmorMaterials.PEARL, ArmorItem.Type.BOOTS, props));

    /**
     * Pearl's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> PEARL_PICKAXE = ITEMS.register("pearl_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.PEARL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.PEARL, 1.0F, -2.8F))));

    /**
     * Pearl's Axe.
     */
    public static final DeferredItem<AxeItem> PEARL_AXE = ITEMS.register("pearl_axe",
            () -> new AxeItem(ModToolMaterials.PEARL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.PEARL, 5.0F, -3.0F))));

    /**
     * Pearl's Shovel.
     */
    public static final DeferredItem<ShovelItem> PEARL_SHOVEL = ITEMS.register("pearl_shovel",
            () -> new ShovelItem(ModToolMaterials.PEARL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.PEARL, 1.5F, -3.0F))));

    /**
     * Pearl's Hoe.
     */
    public static final DeferredItem<HoeItem> PEARL_HOE = ITEMS.register("pearl_hoe",
            () -> new HoeItem(ModToolMaterials.PEARL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.PEARL, -3.0F, 0.0F))));

    // =========================================================================
    // LAZULI CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Lazuli's Sickle - frostbitten sickle that chills whatever it reaps.
     */
    public static final DeferredItem<SwordItem> LAZULI_SICKLE = ITEMS.register("lazuli_sickle",
            () -> new SwordItem(ModToolMaterials.LAZULI, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.LAZULI, 3.0F, -2.4F))));

    /**
     * Lazuli's Helmet.
     */
    public static final DeferredItem<ArmorItem> LAZULI_HELMET = ITEMS.registerItem("lazuli_helmet",
            props -> new ArmorItem(ModArmorMaterials.LAZULI, ArmorItem.Type.HELMET, props));

    /**
     * Lazuli's Chestplate.
     */
    public static final DeferredItem<ArmorItem> LAZULI_CHESTPLATE = ITEMS.registerItem("lazuli_chestplate",
            props -> new ArmorItem(ModArmorMaterials.LAZULI, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Lazuli's Leggings.
     */
    public static final DeferredItem<ArmorItem> LAZULI_LEGGINGS = ITEMS.registerItem("lazuli_leggings",
            props -> new ArmorItem(ModArmorMaterials.LAZULI, ArmorItem.Type.LEGGINGS, props));

    /**
     * Lazuli's Boots.
     */
    public static final DeferredItem<ArmorItem> LAZULI_BOOTS = ITEMS.registerItem("lazuli_boots",
            props -> new ArmorItem(ModArmorMaterials.LAZULI, ArmorItem.Type.BOOTS, props));

    /**
     * Lazuli's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> LAZULI_PICKAXE = ITEMS.register("lazuli_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.LAZULI, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.LAZULI, 1.0F, -2.8F))));

    /**
     * Lazuli's Axe.
     */
    public static final DeferredItem<AxeItem> LAZULI_AXE = ITEMS.register("lazuli_axe",
            () -> new AxeItem(ModToolMaterials.LAZULI, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.LAZULI, 5.0F, -3.0F))));

    /**
     * Lazuli's Shovel.
     */
    public static final DeferredItem<ShovelItem> LAZULI_SHOVEL = ITEMS.register("lazuli_shovel",
            () -> new ShovelItem(ModToolMaterials.LAZULI, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.LAZULI, 1.5F, -3.0F))));

    /**
     * Lazuli's Hoe.
     */
    public static final DeferredItem<HoeItem> LAZULI_HOE = ITEMS.register("lazuli_hoe",
            () -> new HoeItem(ModToolMaterials.LAZULI, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.LAZULI, -3.0F, 0.0F))));

    // =========================================================================
    // LEAFY CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Leafy's Spear - living-wood spear with druidic reach.
     */
    public static final DeferredItem<Item> LEAFY_SPEAR = ITEMS.register("leafy_spear",
            () -> new KingdomSpearItem(ModToolMaterials.LEAFY, 4.5F, -2.4F, 1.5D, new Item.Properties()));

    /**
     * Leafy's Helmet.
     */
    public static final DeferredItem<ArmorItem> LEAFY_HELMET = ITEMS.registerItem("leafy_helmet",
            props -> new ArmorItem(ModArmorMaterials.LEAFY, ArmorItem.Type.HELMET, props));

    /**
     * Leafy's Chestplate.
     */
    public static final DeferredItem<ArmorItem> LEAFY_CHESTPLATE = ITEMS.registerItem("leafy_chestplate",
            props -> new ArmorItem(ModArmorMaterials.LEAFY, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Leafy's Leggings.
     */
    public static final DeferredItem<ArmorItem> LEAFY_LEGGINGS = ITEMS.registerItem("leafy_leggings",
            props -> new ArmorItem(ModArmorMaterials.LEAFY, ArmorItem.Type.LEGGINGS, props));

    /**
     * Leafy's Boots.
     */
    public static final DeferredItem<ArmorItem> LEAFY_BOOTS = ITEMS.registerItem("leafy_boots",
            props -> new ArmorItem(ModArmorMaterials.LEAFY, ArmorItem.Type.BOOTS, props));

    /**
     * Leafy's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> LEAFY_PICKAXE = ITEMS.register("leafy_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.LEAFY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.LEAFY, 1.0F, -2.8F))));

    /**
     * Leafy's Axe.
     */
    public static final DeferredItem<AxeItem> LEAFY_AXE = ITEMS.register("leafy_axe",
            () -> new AxeItem(ModToolMaterials.LEAFY, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.LEAFY, 5.0F, -3.0F))));

    /**
     * Leafy's Shovel.
     */
    public static final DeferredItem<ShovelItem> LEAFY_SHOVEL = ITEMS.register("leafy_shovel",
            () -> new ShovelItem(ModToolMaterials.LEAFY, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.LEAFY, 1.5F, -3.0F))));

    /**
     * Leafy's Hoe.
     */
    public static final DeferredItem<HoeItem> LEAFY_HOE = ITEMS.register("leafy_hoe",
            () -> new HoeItem(ModToolMaterials.LEAFY, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.LEAFY, -3.0F, 0.0F))));

    // =========================================================================
    // SYLVIA CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Sylvia's Sword - royal tri-metal sword of the gilded court.
     */
    public static final DeferredItem<SwordItem> SYLVIA_SWORD = ITEMS.register("sylvia_sword",
            () -> new SwordItem(ModToolMaterials.SYLVIA, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.SYLVIA, 4.0F, -2.4F))));

    /**
     * Sylvia's Helmet.
     */
    public static final DeferredItem<ArmorItem> SYLVIA_HELMET = ITEMS.registerItem("sylvia_helmet",
            props -> new ArmorItem(ModArmorMaterials.SYLVIA, ArmorItem.Type.HELMET, props));

    /**
     * Sylvia's Chestplate.
     */
    public static final DeferredItem<ArmorItem> SYLVIA_CHESTPLATE = ITEMS.registerItem("sylvia_chestplate",
            props -> new ArmorItem(ModArmorMaterials.SYLVIA, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Sylvia's Leggings.
     */
    public static final DeferredItem<ArmorItem> SYLVIA_LEGGINGS = ITEMS.registerItem("sylvia_leggings",
            props -> new ArmorItem(ModArmorMaterials.SYLVIA, ArmorItem.Type.LEGGINGS, props));

    /**
     * Sylvia's Boots.
     */
    public static final DeferredItem<ArmorItem> SYLVIA_BOOTS = ITEMS.registerItem("sylvia_boots",
            props -> new ArmorItem(ModArmorMaterials.SYLVIA, ArmorItem.Type.BOOTS, props));

    /**
     * Sylvia's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> SYLVIA_PICKAXE = ITEMS.register("sylvia_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.SYLVIA, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.SYLVIA, 1.0F, -2.8F))));

    /**
     * Sylvia's Axe.
     */
    public static final DeferredItem<AxeItem> SYLVIA_AXE = ITEMS.register("sylvia_axe",
            () -> new AxeItem(ModToolMaterials.SYLVIA, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.SYLVIA, 5.0F, -3.0F))));

    /**
     * Sylvia's Shovel.
     */
    public static final DeferredItem<ShovelItem> SYLVIA_SHOVEL = ITEMS.register("sylvia_shovel",
            () -> new ShovelItem(ModToolMaterials.SYLVIA, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.SYLVIA, 1.5F, -3.0F))));

    /**
     * Sylvia's Hoe.
     */
    public static final DeferredItem<HoeItem> SYLVIA_HOE = ITEMS.register("sylvia_hoe",
            () -> new HoeItem(ModToolMaterials.SYLVIA, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.SYLVIA, -3.0F, 0.0F))));

    // =========================================================================
    // SUNSHINE CHARACTER SET - ELEMENT KINGDOM
    // =========================================================================

    /**
     * Sunshine's Sword - sunlit blade that banishes the dark.
     */
    public static final DeferredItem<SwordItem> SUNSHINE_SWORD = ITEMS.register("sunshine_sword",
            () -> new SwordItem(ModToolMaterials.SUNSHINE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolMaterials.SUNSHINE, 3.0F, -2.4F))));

    /**
     * Sunshine's Helmet.
     */
    public static final DeferredItem<ArmorItem> SUNSHINE_HELMET = ITEMS.registerItem("sunshine_helmet",
            props -> new ArmorItem(ModArmorMaterials.SUNSHINE, ArmorItem.Type.HELMET, props));

    /**
     * Sunshine's Chestplate.
     */
    public static final DeferredItem<ArmorItem> SUNSHINE_CHESTPLATE = ITEMS.registerItem("sunshine_chestplate",
            props -> new ArmorItem(ModArmorMaterials.SUNSHINE, ArmorItem.Type.CHESTPLATE, props));

    /**
     * Sunshine's Leggings.
     */
    public static final DeferredItem<ArmorItem> SUNSHINE_LEGGINGS = ITEMS.registerItem("sunshine_leggings",
            props -> new ArmorItem(ModArmorMaterials.SUNSHINE, ArmorItem.Type.LEGGINGS, props));

    /**
     * Sunshine's Boots.
     */
    public static final DeferredItem<ArmorItem> SUNSHINE_BOOTS = ITEMS.registerItem("sunshine_boots",
            props -> new ArmorItem(ModArmorMaterials.SUNSHINE, ArmorItem.Type.BOOTS, props));

    /**
     * Sunshine's Pickaxe.
     */
    public static final DeferredItem<PickaxeItem> SUNSHINE_PICKAXE = ITEMS.register("sunshine_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.SUNSHINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolMaterials.SUNSHINE, 1.0F, -2.8F))));

    /**
     * Sunshine's Axe.
     */
    public static final DeferredItem<AxeItem> SUNSHINE_AXE = ITEMS.register("sunshine_axe",
            () -> new AxeItem(ModToolMaterials.SUNSHINE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolMaterials.SUNSHINE, 5.0F, -3.0F))));

    /**
     * Sunshine's Shovel.
     */
    public static final DeferredItem<ShovelItem> SUNSHINE_SHOVEL = ITEMS.register("sunshine_shovel",
            () -> new ShovelItem(ModToolMaterials.SUNSHINE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolMaterials.SUNSHINE, 1.5F, -3.0F))));

    /**
     * Sunshine's Hoe.
     */
    public static final DeferredItem<HoeItem> SUNSHINE_HOE = ITEMS.register("sunshine_hoe",
            () -> new HoeItem(ModToolMaterials.SUNSHINE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolMaterials.SUNSHINE, -3.0F, 0.0F))));
}
