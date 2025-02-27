package com.zetareticula.zetasgenesis;

import com.zetareticula.zetasgenesis.data.provider.*;
import com.zetareticula.zetasgenesis.item.GenesisItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ZetasGenesisDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

			pack.addProvider(GenesisModelProvider::new);
			pack.addProvider(GenesisRecipeProvider::new);
			pack.addProvider(GenesisBlockTagProvider::new);
			pack.addProvider(GenesisItemTagProvider::new);


	}
}
