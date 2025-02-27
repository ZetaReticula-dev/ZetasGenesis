package com.zetareticula.zetasgenesis;

import com.zetareticula.zetasgenesis.data.provider.GenesisModelProvider;
import com.zetareticula.zetasgenesis.data.provider.GenesisRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ZetasGenesisDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

			pack.addProvider(GenesisModelProvider::new);
			pack.addProvider(GenesisRecipeProvider::new);


	}
}
