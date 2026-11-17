package net.tws.macroverse.common.init;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.tws.macroverse.Main;
import net.tws.macroverse.common.block.TallUmbralGrassBlock;
import net.tws.macroverse.common.block.UmbralGrassBlock;

import java.util.function.Function;

public class MacroverseBlocks {

    //Natural Blocks
    public static final Block SHADESHALE = registerBlock("shadeshale", properties -> new Block(properties
            .mapColor(MapColor.COLOR_GRAY)
            .strength(1.5F, 6.0F)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()));
    public static final Block COBBLED_SHADESHALE = registerBlock("cobbled_shadeshale", properties -> new Block(properties
            .mapColor(MapColor.COLOR_GRAY)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(2.0F, 6.0F)));
    public static final Block SHADESHALE_BRICKS = registerBlock("shadeshale_bricks", properties -> new Block(properties
            .mapColor(MapColor.COLOR_GRAY)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final Block SHADESOIL = registerBlock("shadesoil", properties ->  new Block(properties
            .mapColor(MapColor.TERRACOTTA_CYAN)
            .sound(SoundType.GRAVEL)
            .strength(0.5F)));
    public static final Block UMBRAL_GRASS_BLOCK = registerBlock("umbral_grass_block", properties -> new UmbralGrassBlock(properties
            .mapColor(MapColor.LAPIS)
            .sound(SoundType.GRASS)
            .randomTicks()
            .strength(0.6F)));
    public static final Block SHORT_UMBRAL_GRASS = registerBlock("short_umbral_grass", properties -> new TallUmbralGrassBlock(properties
            .mapColor(MapColor.LAPIS)
            .sound(SoundType.GRASS)
            .instabreak()
            .pushReaction(PushReaction.POPPED)
            .offsetType(BlockBehaviour.OffsetType.XYZ)
            .noCollision()
            .noOcclusion()
            .replaceable()
            .ignitedByLava()));

    //Wood Sets
    public static final Block UMBEROAK_LEAVES = registerBlock("umberoak_leaves", properties -> new TintedParticleLeavesBlock(0.0F, properties
            .mapColor(MapColor.LAPIS)
            .strength(0.2F)
            .randomTicks()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .isValidSpawn(Blocks::ocelotOrParrot)
            .isSuffocating(Blocks::never)
            .ignitedByLava()
            .pushReaction(PushReaction.POPPED)
            .isRedstoneConductor(Blocks::never)));
    //Sapling
    public static final Block UMBEROAK_LOG = registerBlock("umberoak_log", properties -> new RotatedPillarBlock(properties
            .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_PURPLE : MapColor.TERRACOTTA_CYAN)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    public static final Block UMBEROAK_WOOD = registerBlock("umberoak_wood", properties -> new RotatedPillarBlock(properties
            .mapColor(MapColor.TERRACOTTA_CYAN)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    public static final Block STRIPPED_UMBEROAK_LOG = registerBlock("stripped_umberoak_log", properties -> new RotatedPillarBlock(properties
            .mapColor(MapColor.COLOR_PURPLE)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    public static final Block STRIPPED_UMBEROAK_WOOD = registerBlock("stripped_umberoak_wood", properties -> new RotatedPillarBlock(properties
            .mapColor(MapColor.COLOR_PURPLE)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava()));
    public static final Block UMBEROAK_PLANKS = registerBlock("umberoak_planks", properties -> new Block(properties
            .mapColor(MapColor.COLOR_PURPLE)
            .sound(SoundType.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .ignitedByLava()
            .strength(2.0F, 3.0F)));

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
