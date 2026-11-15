package net.tws.macroverse.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tws.macroverse.client.datagen.LootTableProvider;
import net.tws.macroverse.client.datagen.ModelProvider;
import org.jspecify.annotations.NonNull;

public class Datagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(@NonNull FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModelProvider::new);
		pack.addProvider(LootTableProvider::new);
	}
}
