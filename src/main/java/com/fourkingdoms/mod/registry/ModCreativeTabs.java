package com.fourkingdoms.mod.registry;

import com.fourkingdoms.mod.FourKingdomsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * <h1>ModCreativeTabs Registry</h1>
 * <p>
 * Registers custom Creative Mode tabs for the <b>Four Kingdoms Mod</b>.
 * </p>
 *
 * <h2>Current Creative Tabs</h2>
 * <ul>
 *   <li><b>Four Kingdoms: Dream Kingdom</b> - Contains all items, armor, weapons, and tools for Dream Kingdom characters.</li>
 *   <li><b>Four Kingdoms: Element Kingdom</b> - Contains all items, armor, weapons, and tools for Element Kingdom characters.</li>
 * </ul>
 *
 * <h2>Adding New Kingdom Tabs</h2>
 * To add a new tab for another kingdom (e.g. Wild Kingdom), create a new {@link DeferredHolder} entry:
 * <pre>{@code
 * public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WILD_KINGDOM_TAB =
 *         CREATIVE_MODE_TABS.register("wild_kingdom_tab", () -> CreativeModeTab.builder()
 *                 .title(Component.translatable("creativetab.four_kingdoms.wild_kingdom"))
 *                 .icon(() -> new ItemStack(ModItems.WILD_ITEM.get()))
 *                 .displayItems((parameters, output) -> {
 *                     output.accept(ModItems.WILD_ITEM.get());
 *                 })
 *                 .build());
 * }</pre>
 *
 * @author EnGarcia
 * @see ModItems
 */
public class ModCreativeTabs {
    /**
     * DeferredRegister instance for CreativeModeTab entries in {@code four_kingdoms}.
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FourKingdomsMod.MOD_ID);

    /**
     * Creative Mode Tab for the Dream Kingdom, displaying the Daydream Spear as its primary emblem.
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOUR_KINGDOMS_TAB =
            CREATIVE_MODE_TABS.register("four_kingdoms_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.four_kingdoms.dream_kingdom"))
                    .icon(() -> new ItemStack(ModItems.DAYDREAM_SPEAR.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.DAYDREAM_SPEAR.get());
                        output.accept(ModItems.DAYDREAM_HELMET.get());
                        output.accept(ModItems.DAYDREAM_CHESTPLATE.get());
                        output.accept(ModItems.DAYDREAM_LEGGINGS.get());
                        output.accept(ModItems.DAYDREAM_BOOTS.get());
                        output.accept(ModItems.DAYDREAM_PICKAXE.get());
                        output.accept(ModItems.DAYDREAM_AXE.get());
                        output.accept(ModItems.DAYDREAM_SHOVEL.get());
                        output.accept(ModItems.DAYDREAM_HOE.get());

                        output.accept(ModItems.NIGHTMARE_SWORD.get());
                        output.accept(ModItems.NIGHTMARE_HELMET.get());
                        output.accept(ModItems.NIGHTMARE_CHESTPLATE.get());
                        output.accept(ModItems.NIGHTMARE_LEGGINGS.get());
                        output.accept(ModItems.NIGHTMARE_BOOTS.get());
                        output.accept(ModItems.NIGHTMARE_PICKAXE.get());
                        output.accept(ModItems.NIGHTMARE_AXE.get());
                        output.accept(ModItems.NIGHTMARE_SHOVEL.get());
                        output.accept(ModItems.NIGHTMARE_HOE.get());

                        // Infused Leathers
                        output.accept(ModItems.AMETHYST_INFUSED_LEATHER.get());
                        output.accept(ModItems.COPPER_INFUSED_LEATHER.get());
                        output.accept(ModItems.DIAMOND_INFUSED_LEATHER.get());
                        output.accept(ModItems.ECHO_INFUSED_LEATHER.get());
                        output.accept(ModItems.GOLD_INFUSED_LEATHER.get());
                        output.accept(ModItems.IRON_INFUSED_LEATHER.get());
                        output.accept(ModItems.NETHERITE_INFUSED_LEATHER.get());
                        output.accept(ModItems.QUARTZ_INFUSED_LEATHER.get());
                    })
                    .build());

    /**
     * Creative Mode Tab for the Element Kingdom, displaying Flare's Sword as its primary emblem.
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ELEMENT_KINGDOM_TAB =
            CREATIVE_MODE_TABS.register("element_kingdom_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.four_kingdoms.element_kingdom"))
                    .icon(() -> new ItemStack(ModItems.FLARE_SWORD.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.FLARE_SWORD.get());
                        output.accept(ModItems.FLARE_HELMET.get());
                        output.accept(ModItems.FLARE_CHESTPLATE.get());
                        output.accept(ModItems.FLARE_LEGGINGS.get());
                        output.accept(ModItems.FLARE_BOOTS.get());
                        output.accept(ModItems.FLARE_PICKAXE.get());
                        output.accept(ModItems.FLARE_AXE.get());
                        output.accept(ModItems.FLARE_SHOVEL.get());
                        output.accept(ModItems.FLARE_HOE.get());

                        output.accept(ModItems.CRYSTAL_TRIDENT.get());
                        output.accept(ModItems.CRYSTAL_HELMET.get());
                        output.accept(ModItems.CRYSTAL_CHESTPLATE.get());
                        output.accept(ModItems.CRYSTAL_LEGGINGS.get());
                        output.accept(ModItems.CRYSTAL_BOOTS.get());
                        output.accept(ModItems.CRYSTAL_PICKAXE.get());
                        output.accept(ModItems.CRYSTAL_AXE.get());
                        output.accept(ModItems.CRYSTAL_SHOVEL.get());
                        output.accept(ModItems.CRYSTAL_HOE.get());
                        output.accept(ModItems.SPEED_LONGSWORD.get());
                        output.accept(ModItems.SPEED_HELMET.get());
                        output.accept(ModItems.SPEED_CHESTPLATE.get());
                        output.accept(ModItems.SPEED_LEGGINGS.get());
                        output.accept(ModItems.SPEED_BOOTS.get());
                        output.accept(ModItems.SPEED_PICKAXE.get());
                        output.accept(ModItems.SPEED_AXE.get());
                        output.accept(ModItems.SPEED_SHOVEL.get());
                        output.accept(ModItems.SPEED_HOE.get());
                        output.accept(ModItems.BLACK_BLADE.get());
                        output.accept(ModItems.BLACK_HELMET.get());
                        output.accept(ModItems.BLACK_CHESTPLATE.get());
                        output.accept(ModItems.BLACK_LEGGINGS.get());
                        output.accept(ModItems.BLACK_BOOTS.get());
                        output.accept(ModItems.BLACK_PICKAXE.get());
                        output.accept(ModItems.BLACK_AXE.get());
                        output.accept(ModItems.BLACK_SHOVEL.get());
                        output.accept(ModItems.BLACK_HOE.get());
                        output.accept(ModItems.PEARL_SCYTHE.get());
                        output.accept(ModItems.PEARL_HELMET.get());
                        output.accept(ModItems.PEARL_CHESTPLATE.get());
                        output.accept(ModItems.PEARL_LEGGINGS.get());
                        output.accept(ModItems.PEARL_BOOTS.get());
                        output.accept(ModItems.PEARL_PICKAXE.get());
                        output.accept(ModItems.PEARL_AXE.get());
                        output.accept(ModItems.PEARL_SHOVEL.get());
                        output.accept(ModItems.PEARL_HOE.get());
                        output.accept(ModItems.LAZULI_SICKLE.get());
                        output.accept(ModItems.LAZULI_HELMET.get());
                        output.accept(ModItems.LAZULI_CHESTPLATE.get());
                        output.accept(ModItems.LAZULI_LEGGINGS.get());
                        output.accept(ModItems.LAZULI_BOOTS.get());
                        output.accept(ModItems.LAZULI_PICKAXE.get());
                        output.accept(ModItems.LAZULI_AXE.get());
                        output.accept(ModItems.LAZULI_SHOVEL.get());
                        output.accept(ModItems.LAZULI_HOE.get());
                        output.accept(ModItems.LEAFY_SPEAR.get());
                        output.accept(ModItems.LEAFY_HELMET.get());
                        output.accept(ModItems.LEAFY_CHESTPLATE.get());
                        output.accept(ModItems.LEAFY_LEGGINGS.get());
                        output.accept(ModItems.LEAFY_BOOTS.get());
                        output.accept(ModItems.LEAFY_PICKAXE.get());
                        output.accept(ModItems.LEAFY_AXE.get());
                        output.accept(ModItems.LEAFY_SHOVEL.get());
                        output.accept(ModItems.LEAFY_HOE.get());
                        output.accept(ModItems.SYLVIA_SWORD.get());
                        output.accept(ModItems.SYLVIA_HELMET.get());
                        output.accept(ModItems.SYLVIA_CHESTPLATE.get());
                        output.accept(ModItems.SYLVIA_LEGGINGS.get());
                        output.accept(ModItems.SYLVIA_BOOTS.get());
                        output.accept(ModItems.SYLVIA_PICKAXE.get());
                        output.accept(ModItems.SYLVIA_AXE.get());
                        output.accept(ModItems.SYLVIA_SHOVEL.get());
                        output.accept(ModItems.SYLVIA_HOE.get());
                        output.accept(ModItems.SUNSHINE_SWORD.get());
                        output.accept(ModItems.SUNSHINE_HELMET.get());
                        output.accept(ModItems.SUNSHINE_CHESTPLATE.get());
                        output.accept(ModItems.SUNSHINE_LEGGINGS.get());
                        output.accept(ModItems.SUNSHINE_BOOTS.get());
                        output.accept(ModItems.SUNSHINE_PICKAXE.get());
                        output.accept(ModItems.SUNSHINE_AXE.get());
                        output.accept(ModItems.SUNSHINE_SHOVEL.get());
                        output.accept(ModItems.SUNSHINE_HOE.get());
                    })
                    .build());
}
