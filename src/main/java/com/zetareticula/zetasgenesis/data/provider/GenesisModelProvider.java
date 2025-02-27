package com.zetareticula.zetasgenesis.data.provider;

import com.zetareticula.zetasgenesis.block.GenesisBlocks;
import com.zetareticula.zetasgenesis.item.GenesisItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;

public class GenesisModelProvider extends FabricModelProvider {
    public GenesisModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CALCITE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CHISELED_CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.BRASS_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GenesisItems.NETHER_SHARD, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.BRASS_INGOT, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_HELMET, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_BOOTS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.DIAMOND_PICK_AXE, Models.HANDHELD);

    }
}
