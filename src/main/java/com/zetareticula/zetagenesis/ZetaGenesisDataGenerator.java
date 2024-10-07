package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.data.generator.GenesisWorldGenerator;
import com.zetareticula.zetagenesis.data.provider.GenesisBlockTagProvider;
import com.zetareticula.zetagenesis.data.provider.GenesisModelProvider;
import com.zetareticula.zetagenesis.data.provider.GenesisRecipeProvider;
import com.zetareticula.zetagenesis.worldgen.GenesisConfiguredFeature;
import com.zetareticula.zetagenesis.worldgen.GenesisPlacedFeature;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ZetaGenesisDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(GenesisModelProvider::new);
		pack.addProvider(GenesisBlockTagProvider::new);
		pack.addProvider(GenesisWorldGenerator::new);
		pack.addProvider(GenesisRecipeProvider::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, GenesisConfiguredFeature::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, GenesisPlacedFeature::bootstrap);
	}
}
