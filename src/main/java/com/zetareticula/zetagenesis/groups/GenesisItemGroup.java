package com.zetareticula.zetagenesis.groups;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.item.GenesisItems;
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
                        entries.add(GenesisItems.AOTE);
                        entries.add(GenesisItems.WARPED_AOTE);
                        entries.add(GenesisItems.AOTV);
                        entries.add(GenesisItems.WARPED_AOTV);
                        entries.add(GenesisItems.NULL_SPHERE);
                        entries.add(GenesisItems.NULL_OVOID);
                        entries.add(GenesisItems.WARPED_STONE);
                        entries.add(GenesisItems.TRANSMISSION_TUNER);
                        entries.add(GenesisItems.INSTANT_TRANSMISSION_CONDUIT);
                        entries.add(GenesisItems.INSTANT_TRANSMISSION_MERGER);
                        entries.add(GenesisItems.TUNING_FORK);
                        entries.add(GenesisItems.ANGEL_RING);
                        entries.add(GenesisItems.DIVAN_HELMET);
                        entries.add(GenesisItems.DIVAN_CHESTPLATE);
                        entries.add(GenesisItems.DIVAN_LEGGINGS);
                        entries.add(GenesisItems.DIVAN_BOOTS);
                        entries.add(GenesisItems.GLITCH_HELMET);
                        entries.add(GenesisItems.GLITCH_CHESTPLATE);
                        entries.add(GenesisItems.GLITCH_LEGGINGS);
                        entries.add(GenesisItems.GLITCH_BOOTS);
                        entries.add(GenesisItems.ENERGY_HELMET);
                        entries.add(GenesisItems.ENERGY_CHESTPLATE);
                        entries.add(GenesisItems.ENERGY_LEGGINGS);
                        entries.add(GenesisItems.ENERGY_GREAVES);
                        entries.add(GenesisItems.ENDERIUM_HELMET);
                        entries.add(GenesisItems.ENDERIUM_CHESTPLATE);
                        entries.add(GenesisItems.ENDERIUM_LEGGINGS);
                        entries.add(GenesisItems.ENDERIUM_BOOTS);
                        entries.add(GenesisItems.ENDERIUM_SWORD);
                        entries.add(GenesisItems.ENDERIUM_INGOT);
                        entries.add(GenesisItems.ENDERIUM_UPGRADE);
                        entries.add(GenesisItems.URANIUM_FUEL_ROD);
                        entries.add(GenesisItems.IRON_HAMMER);
                        entries.add(GenesisItems.DIAMOND_HAMMER);
                        entries.add(GenesisItems.NETHERITE_HAMMER);
                        entries.add(GenesisItems.WRENCH);

                    })

                    .build());

    public static void registerGenesisItemGroup() {
        ZetaGenesis.LOGGER.info("Registering Genesis Item Group for " + ZetaGenesis.MOD_ID);
    }
}
