package com.zetareticula.zetasgenesis.data.provider;

import com.zetareticula.zetasgenesis.ZetasGenesis;
import com.zetareticula.zetasgenesis.block.GenesisBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class GenesisBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public GenesisBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Block> PICKANDAXE_MINEABLE = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ZetasGenesis.MOD_ID, "mineable/pick_and_axe"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(GenesisBlocks.CALCITE_BRICKS);

        getOrCreateTagBuilder(PICKANDAXE_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE);

    }
}
