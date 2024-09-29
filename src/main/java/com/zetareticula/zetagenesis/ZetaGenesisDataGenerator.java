package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.datagen.GenesisBlockTagProvider;
import com.zetareticula.zetagenesis.datagen.GenesisModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ZetaGenesisDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(GenesisModelProvider::new);
		pack.addProvider(GenesisBlockTagProvider::new);

	}
}
