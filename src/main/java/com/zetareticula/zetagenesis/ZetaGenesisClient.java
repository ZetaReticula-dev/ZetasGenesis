package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.block.render.StoveBlockEntityRender;
import com.zetareticula.zetagenesis.screen.BasketBlockScreen;
import com.zetareticula.zetagenesis.screen.CabinetBlockScreen;
import com.zetareticula.zetagenesis.screen.VariantChestBlockScreen;
import com.zetareticula.zetagenesis.screenhandler.GenesisScreenHandlerType;
import com.zetareticula.zetagenesis.utils.HammerUsageEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ZetaGenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        //Bind Screen to  Handler
        HandledScreens.register(GenesisScreenHandlerType.BASKET_BLOCK_SCREEN, BasketBlockScreen::new);
        HandledScreens.register(GenesisScreenHandlerType.CABINET_BLOCK_SCREEN, CabinetBlockScreen::new);
        HandledScreens.register(GenesisScreenHandlerType.VARIANT_CHEST_BLOCK_SCREEN, VariantChestBlockScreen::new);

        //Block render
        BlockEntityRendererFactories.register(GenesisBlockEntity.STOVE_BLOCK_ENTITY, StoveBlockEntityRender::new);

        //Events
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

    }
}
