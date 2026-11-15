package net.tws.macroverse.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

import static net.tws.macroverse.client.datagen.LootTables.*;

public class LootTableProvider extends FabricBlockLootSubProvider {


    public LootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        for (Block block : SLABS) {
            add(block, createSlabItemTable(block));
        }

        for (Block block : DROPS_SELF) {
            dropSelf(block);
        }

    }
}
