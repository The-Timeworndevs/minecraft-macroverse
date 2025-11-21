package net.timeworndevs.macroverse.common;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.MyceliumBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.timeworndevs.macroverse.Main;
import net.timeworndevs.macroverse.common.block.UmbralGrassBlock;

import java.util.function.Function;

public class MacroverseBlocks {

    public static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings, boolean shouldregister) {

        ResourceKey<Block> blockkey = keyOfBlock(name);

        Block block = factory.apply(settings.setId(blockkey));

        if (shouldregister) {
            ResourceKey<Item> itemkey = keyOfItem(name);

            BlockItem blockitem = new BlockItem(block, new Item.Properties().setId(itemkey).useBlockDescriptionPrefix());

            Registry.register(BuiltInRegistries.ITEM, itemkey, blockitem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockkey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, name));
    }


    public static final Block UMBRAL_SOIL = register("umbral_soil", Block::new, BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).mapColor(MapColor.COLOR_GRAY), true);
    public static final Block UMBRAL_GRASS = register("umbral_grass", (properties) -> new UmbralGrassBlock(properties), BlockBehaviour.Properties.of().sound(SoundType.GRASS).mapColor(MapColor.TERRACOTTA_CYAN).randomTicks(), true);
    public static final Block SHADESHALE = register("shadeshale", Block::new, BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK), true);
    public static final Block COBBLED_SHADESHALE = register("cobbled_shadeshale", Block::new, BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK), true);
    public static final Block SHADESHALE_BRICKS = register("shadeshale_bricks", Block::new, BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.COLOR_BLACK), true);


    public static void init() {

    }
}
