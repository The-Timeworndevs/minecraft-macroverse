package net.tws.macroverse.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.tws.macroverse.common.init.MacroverseBlocks;

public abstract class SpreadingShadesoilBlock extends SnowyBlock {

    protected SpreadingShadesoilBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeGrass(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.above();
        BlockState blockState2 = levelReader.getBlockState(blockPos2);
        if (blockState2.is(Blocks.SNOW) && (Integer) blockState2.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockState2.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightDampeningInto(blockState, blockState2, Direction.UP, blockState.getLightDampening());
            return i < 15;
        }
    }
    private static boolean canPropagate(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.above();
        return canBeGrass(blockState, levelReader, blockPos) && !levelReader.getFluidState(blockPos2).is(FluidTags.WATER);
    }

    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {

        if (!canBeGrass(blockState, serverLevel, blockPos)) {
            serverLevel.setBlockAndUpdate(blockPos, MacroverseBlocks.SHADESOIL.defaultBlockState());
        } else {
            if (serverLevel.getMaxLocalRawBrightness(blockPos.above())>= 0) {
                BlockState blockState2 = this.defaultBlockState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockPos2 = blockPos.offset(randomSource.nextInt(3) -1, randomSource.nextInt(5) - 3, randomSource.nextInt(3) -1);
                    if (serverLevel.getBlockState(blockPos2).is(MacroverseBlocks.SHADESOIL) && canPropagate(blockState2, serverLevel, blockPos2)) {
                        serverLevel.setBlockAndUpdate(blockPos2, (BlockState) blockState2.setValue(SNOWY, isSnowySetting(serverLevel.getBlockState(blockPos2.above()))));
                    }
                }
            }
        }
    }
}
