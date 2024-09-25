package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.item.GenesisItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemConvertible;

public class ZetaGenesisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ColorProviderRegistry<ItemConvertible, ItemColorProvider> ITEM = ColorProviderRegistryImpl.ITEM;

    }
}
