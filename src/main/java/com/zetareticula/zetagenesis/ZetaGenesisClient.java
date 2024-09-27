package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.screen.BasketBlockScreen;
import com.zetareticula.zetagenesis.screen.CabinetBlockScreen;
import com.zetareticula.zetagenesis.screenhandler.GenesisScreenHandlerType;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ZetaGenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        //Bind Screen to  Handler
        HandledScreens.register(GenesisScreenHandlerType.BASKET_BLOCK_SCREEN, BasketBlockScreen::new);
        HandledScreens.register(GenesisScreenHandlerType.CABINET_BLOCK_SCREEN, CabinetBlockScreen::new);

    }
}
