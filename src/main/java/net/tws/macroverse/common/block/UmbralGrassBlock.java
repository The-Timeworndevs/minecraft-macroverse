package net.tws.macroverse.common.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.tws.macroverse.common.init.MacroverseBlocks;

public class UmbralGrassBlock extends SpreadingShadesoilBlock {

    public UmbralGrassBlock(BlockBehaviour.Properties properties) {
        super(properties, MacroverseBlocks.SHADESOIL.properties().blockId());
    }
}
