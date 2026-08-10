package com.fourkingdoms.mod;

import com.fourkingdoms.mod.material.ModArmorMaterials;
import com.fourkingdoms.mod.registry.ModCreativeTabs;
import com.fourkingdoms.mod.registry.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * <h1>Four Kingdoms Mod</h1>
 * <p>
 * Main entry point for the <b>Four Kingdoms Minecraft Mod</b> targeting NeoForge 1.21.1.
 * </p>
 *
 * <h2>The Four Kingdoms</h2>
 * <ul>
 *   <li><b>Element Kingdom</b> - Elemental forces and primal gear.</li>
 *   <li><b>Wild Kingdom</b> - Untamed wilderness and organic equipment.</li>
 *   <li><b>Dream Kingdom</b> - Ethereal, uplifting gear associated with characters like <i>Daydream</i>.</li>
 *   <li><b>Forgotten Kingdom</b> - Ancient lost relics and subterranean items.</li>
 * </ul>
 *
 * <h2>Mod Lifecycle</h2>
 * NeoForge discovers this class via the {@link Mod} annotation using the MOD_ID {@value #MOD_ID}.
 * During initialization, all deferred registries (items, armor materials, creative tabs) are bound to the mod event bus.
 *
 * @author EnGarcia
 * @version 1.0.0
 * @see ModItems
 * @see ModArmorMaterials
 * @see ModCreativeTabs
 */
@Mod(FourKingdomsMod.MOD_ID)
public class FourKingdomsMod {
    /**
     * Unique namespace ID for the Four Kingdoms mod.
     * All assets and registry names use this ID as their domain prefix (e.g., {@code four_kingdoms:daydream_spear}).
     */
    public static final String MOD_ID = "four_kingdoms";

    /**
     * Global SLF4J logger instance for debugging, warning, and startup diagnostic messages.
     */
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Constructor invoked by NeoForge FML framework during mod loading.
     *
     * @param modEventBus The primary mod event bus supplied by NeoForge for registering game objects.
     */
    public FourKingdomsMod(IEventBus modEventBus) {
        LOGGER.info("Initializing Four Kingdoms Mod - Dream Kingdom & Daydream Set!");

        // Register registries to mod event bus
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // Register lifecycle event handlers
        modEventBus.addListener(this::commonSetup);
    }

    /**
     * Common setup handler fired during FML initialization.
     * Use this method to configure cross-mod integrations, network payloads, or capabilities.
     *
     * @param event The common setup lifecycle event.
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Four Kingdoms Mod common setup completed successfully.");
    }
}
