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
            FabricItemGroup.builder().icon(() -> new ItemStack(GenesisItems.TUNING_FORK))
                    .displayName(Text.translatable("itemgroup.zetasgenesis.genesis_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(GenesisItems.AOTV);
                        entries.add(GenesisItems.AOTV1);
                        entries.add(GenesisItems.AOTV2);
                        entries.add(GenesisItems.TUNING_FORK);
                        entries.add(GenesisItems.ANGEL_RING);
                        entries.add(GenesisItems.LEGENDARY_HERO);
                        entries.add(GenesisItems.REAPER_PEPPER);
                        entries.add(GenesisItems.DIVAN_HELMET);
                        entries.add(GenesisItems.DIVAN_CHESTPLATE);
                        entries.add(GenesisItems.DIVAN_LEGGINGS);
                        entries.add(GenesisItems.DIVAN_BOOTS);
                        entries.add(GenesisItems.ENDIUM_HELMET);
                        entries.add(GenesisItems.ENDIUM_CHESTPLATE);
                        entries.add(GenesisItems.ENDIUM_LEGGINGS);
                        entries.add(GenesisItems.ENDIUM_BOOTS);
                        entries.add(GenesisItems.ENDIUM_INGOT);
                        entries.add(GenesisItems.ENDIUM_UPGRADE);
                        entries.add(GenesisItems.URANIUM_FUEL_ROD);

                    })

                    .build());

    public static void registerGenesisItemGroup() {
        ZetaGenesis.LOGGER.info("Registering Genesis Item Group for " + ZetaGenesis.MOD_ID);
    }
}
