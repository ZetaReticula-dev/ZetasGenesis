package com.zetareticula.zetagenesis.groups;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.item.GenesisItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FarmerDelightGroup {
    public static final ItemGroup FARMER_DELIGHT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ZetaGenesis.MOD_ID, "farmer_delight"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GenesisBlocks.STOVE))
                    .displayName(Text.translatable("itemgroup.zetasgenesis.farmer_delight"))
                    .entries((displayContext, entries) -> {
                        entries.add(GenesisBlocks.STOVE);
                        entries.add(GenesisItems.IRON_KNIFE);
                        entries.add(GenesisItems.DIAMOND_KNIFE);
                        entries.add(GenesisItems.NETHERITE_KNIFE);
                        entries.add(GenesisItems.GOLD_KNIFE);


                    })

                    .build());

    public static void registerFarmerDelightGroup() {
        ZetaGenesis.LOGGER.info("Registering Farmer's Delight Group for " + ZetaGenesis.MOD_ID);
    }
}
