package com.zetareticula.zetagenesis.data.provider;

import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.utils.GenesisTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class GenesisBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public GenesisBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(GenesisBlocks.OAK_CABINET)
                .add(GenesisBlocks.SPRUCE_CABINET)
                .add(GenesisBlocks.BIRCH_CABINET)
                .add(GenesisBlocks.JUNGLE_CABINET)
                .add(GenesisBlocks.ACACIA_CABINET)
                .add(GenesisBlocks.DARK_OAK_CABINET)
                .add(GenesisBlocks.MANGROVE_CABINET)
                .add(GenesisBlocks.CHERRY_CABINET)
                .add(GenesisBlocks.BAMBOO_CABINET)
                .add(GenesisBlocks.CRIMSON_CABINET)
                .add(GenesisBlocks.WARPED_CABINET)
                //CRAFTING TABLES
                .add(GenesisBlocks.ACACIA_CRAFTING_TABLE)
                .add(GenesisBlocks.BAMBOO_CRAFTING_TABLE)
                .add(GenesisBlocks.BIRCH_CRAFTING_TABLE)
                .add(GenesisBlocks.CHERRY_CRAFTING_TABLE)
                .add(GenesisBlocks.CRIMSON_CRAFTING_TABLE)
                .add(GenesisBlocks.DARK_OAK_CRAFTING_TABLE)
                .add(GenesisBlocks.JUNGLE_CRAFTING_TABLE)
                .add(GenesisBlocks.MANGROVE_CRAFTING_TABLE)
                .add(GenesisBlocks.SPRUCE_CRAFTING_TABLE)
                .add(GenesisBlocks.WARPED_CRAFTING_TABLE)

                .add(GenesisBlocks.BASKET);
    }
}
