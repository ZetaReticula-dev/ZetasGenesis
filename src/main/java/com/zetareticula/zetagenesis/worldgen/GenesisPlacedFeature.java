package com.zetareticula.zetagenesis.worldgen;

import com.zetareticula.zetagenesis.ZetaGenesis;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class GenesisPlacedFeature {
    public static final RegistryKey<PlacedFeature> ENDERIUM_ORE_KEY = registerKey("enderium_ore");

    public static void bootstrap(Registerable<PlacedFeature> contex) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = contex.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(contex, ENDERIUM_ORE_KEY, registryLookup.getOrThrow(GenesisConfiguredFeature.ENDERIUM_ORE_KEY),
                Modifiers.modifiersCount(2, HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(24))));

    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, ZetaGenesis.id(name));
    }

    private static void register(Registerable<PlacedFeature> contex,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        contex.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
public static class Modifiers {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
}
