package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.screen.BasketBlockScreen;
import com.zetareticula.zetagenesis.screenhandler.GenesisScreenHandlerType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.ItemConvertible;

public class ZetaGenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        //Bind Screen to  Handler
        HandledScreens.register(GenesisScreenHandlerType.BASKET_BLOCK_SCREEN, BasketBlockScreen::new);

    }
}
