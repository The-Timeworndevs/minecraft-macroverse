package net.timeworndevs.macroverse;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.timeworndevs.macroverse.common.MacroverseBlocks;

public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(MacroverseBlocks.UMBEROAK_LEAVES, ChunkSectionLayer.CUTOUT);
	}
}