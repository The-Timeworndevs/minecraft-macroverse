package net.timeworndevs.macroverse;

import net.fabricmc.api.ModInitializer;

import net.timeworndevs.macroverse.common.MacroverseBlocks;
import net.timeworndevs.macroverse.common.MacroverseTabs;
import net.timeworndevs.macroverse.common.MacroverseItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {

	public static final String MOD_ID = "macroverse";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Loading the Macroverse...");

        LOGGER.info("Iniditalizing Blocks");
        MacroverseBlocks.init();

        LOGGER.info("Initializing Items");
        MacroverseItems.init();

        LOGGER.info("Initializing Tabs");
        MacroverseTabs.init();

	}
}