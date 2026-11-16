package net.tws.macroverse.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.tws.macroverse.Main;
import net.tws.macroverse.common.block.UmbralGrassBlock;

import java.util.function.Function;

public class MacroverseBlocks {

    public static final Block SHADESHALE = registerBlock("shadeshale", properties -> new Block(properties.mapColor(MapColor.COLOR_GRAY).strength(1.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final Block SHADESOIL = registerBlock("shadesoil", properties ->  new Block(properties.mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.GRAVEL).strength(0.5F)));
    public static final Block UMBRAL_GRASS_BLOCK = registerBlock("umbral_grass_block", properties -> new UmbralGrassBlock(properties.mapColor(MapColor.LAPIS).sound(SoundType.GRASS).randomTicks().strength(0.6F)));

    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Main.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Main.MOD_ID, name), toRegister);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Main.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Main.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Main.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Main.MOD_ID, name)))));
    }

    public static void init() {
        Main.LOGGER.info("Block Registry Successful");
    }
}
