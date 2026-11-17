package net.tws.macroverse.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;
import static net.minecraft.client.data.models.model.TexturedModel.createDefault;

import static net.tws.macroverse.client.datagen.Models.*;
import static net.tws.macroverse.common.init.MacroverseBlocks.*;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    public static TextureMapping column(final Block block) {
        return (new TextureMapping()).put(TextureSlot.SIDE, getBlockTexture(block)).put(TextureSlot.END, getBlockTexture(block, "_top"));
    }

    private static void generatePillarBlockStates(@NonNull BlockModelGenerators blockModelGenerators) {
        final TexturedModel.Provider COLUMN = createDefault(ModelProvider::column, ModelTemplates.CUBE_COLUMN);
        final TexturedModel.Provider HORIZONTAL = createDefault(ModelProvider::column, ModelTemplates.CUBE_COLUMN_HORIZONTAL);

        for (Block pillar : PILLARS) {
            blockModelGenerators.createRotatedPillarWithHorizontalVariant(pillar, COLUMN, HORIZONTAL);
        }
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        generatePillarBlockStates(blockModelGenerators);

        for (Block block : BASIC_BLOCKS) {
            blockModelGenerators.createTrivialCube(block);
        }

        blockModelGenerators.createRotatedVariantBlock(SHADESOIL);

        blockModelGenerators.createCrossBlockWithDefaultItem(SHORT_UMBRAL_GRASS, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.woodProvider(UMBEROAK_LOG).logUVLocked(UMBEROAK_LOG).wood(UMBEROAK_WOOD);
        blockModelGenerators.woodProvider(STRIPPED_UMBEROAK_LOG).logUVLocked(STRIPPED_UMBEROAK_LOG).wood(STRIPPED_UMBEROAK_WOOD);
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        for (Item item : BASIC_ITEMS) {
        }
        for (Item item : HANDHELD_ITEMS) {
        }

        for (Item item : SPEARS) {
            itemModelGenerators.generateSpear(item);
        }
    }
}
