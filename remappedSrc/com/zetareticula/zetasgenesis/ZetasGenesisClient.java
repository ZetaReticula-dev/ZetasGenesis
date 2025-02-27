package com.zetareticula.zetasgenesis;

import com.zetareticula.zetasgenesis.block.GenesisBlockEntity;
import com.zetareticula.zetasgenesis.block.render.StoveBlockEntityRender;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ZetasGenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        //Bind Screen to  Handler


        //Block renderer
        BlockEntityRendererFactories.register(GenesisBlockEntity.STOVE_BLOCK_ENTITY, StoveBlockEntityRender::new);

        //Events

    }
}
