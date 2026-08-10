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
                    })
                    .build());
}
