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

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }
}
