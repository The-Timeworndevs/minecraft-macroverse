package net.timeworndevs.macroverse.common;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.timeworndevs.macroverse.Main;

public class MacroverseTabs {

    public static final ResourceKey<CreativeModeTab> MV_NATURAL_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, "natural_blocks"));
    public static final CreativeModeTab MV_NATURAL_TAB = FabricItemGroup.builder().icon(()-> new ItemStack(MacroverseBlocks.SHADESHALE.asItem())).title(Component.translatable("itemGroup.macroverse.natural_blocks")).build();
    public static final ResourceKey<CreativeModeTab> MV_BUILDING_BLOCKS_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, "building_blocks"));
    public static final CreativeModeTab MV_BUILDING_BLOCKS_TAB = FabricItemGroup.builder().icon(()-> new ItemStack(MacroverseBlocks.COBBLED_SHADESHALE.asItem())).title(Component.translatable("itemGroup.macroverse.building_blocks")).build();

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MV_NATURAL_TAB_KEY, MV_NATURAL_TAB);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MV_BUILDING_BLOCKS_TAB_KEY, MV_BUILDING_BLOCKS_TAB);

        ItemGroupEvents.modifyEntriesEvent(MV_NATURAL_TAB_KEY).register((entries) -> {
            entries.accept(MacroverseBlocks.UMBRAL_SOIL.asItem());
            entries.accept(MacroverseBlocks.UMBRAL_GRASS.asItem());
            entries.accept(MacroverseBlocks.SHADESHALE.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(MV_BUILDING_BLOCKS_TAB_KEY).register((entries) -> {
            entries.accept(MacroverseBlocks.COBBLED_SHADESHALE.asItem());
            entries.accept(MacroverseBlocks.SHADESHALE_BRICKS.asItem());
        });
    }
}
