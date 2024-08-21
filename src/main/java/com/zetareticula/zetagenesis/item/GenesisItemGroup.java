package com.zetareticula.zetagenesis.item;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GenesisItemGroup {
    public static final ItemGroup GENESIS_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ZetaGenesis.MOD_ID, "genesis_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GenesisItems.AOTV))
                    .displayName(Text.translatable("itemgroup.zetasgenesis.genesis_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(GenesisItems.AOTV);
                        entries.add(GenesisItems.AOTV1);
                        entries.add(GenesisItems.AOTV2);
                        entries.add(GenesisItems.ANGEL_RING);
                        entries.add(GenesisItems.LEGENDARY_HERO);
                        entries.add(GenesisItems.REAPER_PEPPER);
                        entries.add(GenesisItems.DIVAN_HELMET);
                        entries.add(GenesisItems.DIVAN_CHESTPLATE);
                        entries.add(GenesisItems.DIVAN_LEGGINGS);
                        entries.add(GenesisItems.DIVAN_BOOTS);
                        entries.add(GenesisItems.ENDERITE_HELMET);
                        entries.add(GenesisItems.ENDERITE_CHESTPLATE);
                        entries.add(GenesisItems.ENDERITE_LEGGINGS);
                        entries.add(GenesisItems.ENDERITE_BOOTS);

                    })

                    .build());

    public static void registerGenesisItemGroup() {
        ZetaGenesis.LOGGER.info("Registering Genesis Block Group for " + ZetaGenesis.MOD_ID);
    }
}
