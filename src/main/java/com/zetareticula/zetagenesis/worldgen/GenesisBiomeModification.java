package com.zetareticula.zetagenesis.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class GenesisBiomeModification {
    public static void load(){
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                GenesisPlacedFeature.ENDERIUM_ORE_KEY
        );
    }
}
