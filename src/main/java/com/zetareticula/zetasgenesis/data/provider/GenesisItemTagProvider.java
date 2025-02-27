package com.zetareticula.zetasgenesis.data.provider;

import com.zetareticula.zetasgenesis.item.GenesisItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GenesisItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public GenesisItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(GenesisItems.ENDERIUM_PICKAXE);

    }
}
