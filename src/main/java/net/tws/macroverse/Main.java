package net.tws.macroverse;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.tws.macroverse.common.init.MacroverseBlocks;
import net.tws.macroverse.common.init.MacroverseItems;
import net.tws.macroverse.common.init.MacroverseTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final String MOD_ID = "macroverse";

	public static final Logger LOGGER = LoggerFactory.getLogger("Macroverse");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing...");

		MacroverseBlocks.init();

		MacroverseTabs.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
