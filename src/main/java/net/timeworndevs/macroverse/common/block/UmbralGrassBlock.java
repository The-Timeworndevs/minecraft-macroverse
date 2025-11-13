package net.timeworndevs.macroverse.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UmbralGrassBlock extends SpreadingUmbralDirtBlock {
    public static final MapCodec<UmbralGrassBlock> CODEC = simpleCodec(UmbralGrassBlock::new);

    public MapCodec codec() {
        return CODEC;
    }

    public UmbralGrassBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
}
