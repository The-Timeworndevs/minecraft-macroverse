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

    public static final ResourceKey<CreativeModeTab> SHADDOW_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Main.MOD_ID, "shaddow"));
    public static final CreativeModeTab SHADDOW_TAB = FabricCreativeModeTab.builder().icon(() -> new ItemStack(MacroverseBlocks.SHADESHALE)).title(Component.translatable("itemGroup.macroverse.shaddow")).displayItems(((parameters, output) -> {
        output.accept(MacroverseBlocks.SHADESHALE);
        output.accept(MacroverseBlocks.COBBLED_SHADESHALE);
        output.accept(MacroverseBlocks.SHADESHALE_BRICKS);
        output.accept(MacroverseBlocks.SHADESOIL);
        output.accept(MacroverseBlocks.UMBRAL_GRASS_BLOCK);
        output.accept(MacroverseBlocks.SHORT_UMBRAL_GRASS);
        output.accept(MacroverseBlocks.UMBEROAK_LOG);
        output.accept(MacroverseBlocks.STRIPPED_UMBEROAK_LOG);
        output.accept(MacroverseBlocks.UMBEROAK_WOOD);
        output.accept(MacroverseBlocks.STRIPPED_UMBEROAK_WOOD);
        output.accept(MacroverseBlocks.UMBEROAK_LEAVES);
        output.accept(MacroverseBlocks.UMBEROAK_PLANKS);
    })).build();

    public static void init() {

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, SHADDOW_TAB_KEY, SHADDOW_TAB);

        Main.LOGGER.info("Creative Item Tabs Registry Successful");
    }

}
