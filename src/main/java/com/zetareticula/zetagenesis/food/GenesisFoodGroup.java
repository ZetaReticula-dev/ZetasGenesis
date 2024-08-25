package com.zetareticula.zetagenesis.food;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.item.GenesisItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GenesisFoodGroup {
    public static final ItemGroup GENESIS_FOOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ZetaGenesis.MOD_ID, "genesis_food"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GenesisItems.KRABBY_PATTY))
                    .displayName(Text.translatable("itemgroup.zetasgenesis.genesisfood"))
                    .entries((displayContext, entries) -> {
                        entries.add(GenesisItems.LEGENDARY_HERO);
                        entries.add(GenesisItems.REAPER_PEPPER);
                        entries.add(GenesisItems.KRABBY_PATTY);
                        entries.add(GenesisItems.ICE_CREAM_SUNRISE);
                        entries.add(GenesisItems.GOD_POTION);

                    })

                    .build());

    public static void registerGenesisFoodGroup() {
        ZetaGenesis.LOGGER.info("Registering Genesis Food Group for " + ZetaGenesis.MOD_ID);
    }
}
