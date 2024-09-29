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
                        entries.add(GenesisBlocks.BASKET);
                        entries.add(GenesisBlocks.OAK_CABINET);
                        entries.add(GenesisBlocks.SPRUCE_CABINET);
                        entries.add(GenesisBlocks.BIRCH_CABINET);
                        entries.add(GenesisBlocks.JUNGLE_CABINET);
                        entries.add(GenesisBlocks.ACACIA_CABINET);
                        entries.add(GenesisBlocks.DARK_OAK_CABINET);
                        entries.add(GenesisBlocks.MANGROVE_CABINET);
                        entries.add(GenesisBlocks.CHERRY_CABINET);
                        entries.add(GenesisBlocks.BAMBOO_CABINET);
                        entries.add(GenesisBlocks.CRIMSON_CABINET);
                        entries.add(GenesisBlocks.WARPED_CABINET);
                        entries.add(GenesisItems.IRON_KNIFE);
                        entries.add(GenesisItems.DIAMOND_KNIFE);
                        entries.add(GenesisItems.NETHERITE_KNIFE);
                        entries.add(GenesisItems.GOLDEN_KNIFE);
                    })

                    .build());

    public static void registerFarmerDelightGroup() {
        ZetaGenesis.LOGGER.info("Registering Farmer's Delight Group for " + ZetaGenesis.MOD_ID);
    }
}
