package net.tws.macroverse.common.init;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tws.macroverse.Main;

public class MacroverseTabs {

    public static final ResourceKey<CreativeModeTab> MACROVERSE_BUILDING_BLOCKS_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Main.MOD_ID, "macroverse_building_blocks"));
    public static final CreativeModeTab MACROVERSE_BUILDING_BLOCKS = FabricCreativeModeTab.builder().icon(() -> new ItemStack(MacroverseBlocks.SHADESHALE)).title(Component.translatable("itemGroup.macroverse.macroverse_building_blocks")).displayItems(((parameters, output) -> {
        output.accept(MacroverseBlocks.SHADESHALE);
        output.accept(MacroverseBlocks.SHADESOIL);
        output.accept(MacroverseBlocks.UMBRAL_GRASS_BLOCK);
    })).build();

    public static void init() {

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MACROVERSE_BUILDING_BLOCKS_KEY, MACROVERSE_BUILDING_BLOCKS);

        Main.LOGGER.info("Creative Item Tabs Registry Successful");
    }

}
