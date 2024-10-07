package com.zetareticula.zetagenesis.worldgen;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.utils.GenesisTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class GenesisConfiguredFeature {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERIUM_ORE_KEY = registerKey("enderium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> contex) {
        RuleTest endOreReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> endOreTargets = List.of(
                OreFeatureConfig.createTarget(endOreReplaceables, GenesisBlocks.ENDERIUM_ORE.getDefaultState()));

        register(contex, ENDERIUM_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(endOreTargets, 2, 1));
    }


    private static final RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, ZetaGenesis.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> contex,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature,
                                                                                   FC featureConfig) {
        contex.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
