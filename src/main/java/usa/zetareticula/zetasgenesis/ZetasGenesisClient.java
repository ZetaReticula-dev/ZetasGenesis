package usa.zetareticula.zetasgenesis;

import usa.zetareticula.zetasgenesis.block.GenesisBlockEntity;
import usa.zetareticula.zetasgenesis.block.GenesisBlocks;
import usa.zetareticula.zetasgenesis.block.render.StoveBlockEntityRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ZetasGenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(GenesisBlocks.GRAVITY_BLOCK, RenderLayer.getTranslucent());


        //Bind Screen to  Handler


        //Block renderer
        BlockEntityRendererFactories.register(GenesisBlockEntity.STOVE_BLOCK_ENTITY, StoveBlockEntityRender::new);

        //Events

    }
}
