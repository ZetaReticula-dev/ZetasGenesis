package com.zetareticula.zetagenesis.block;

import com.zetareticula.zetagenesis.ZetaGenesis;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GenesisBlockGroup {
    public static final ItemGroup GENESIS_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ZetaGenesis.MOD_ID, "genesis_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GenesisBlocks.CALCITE_TILES))
                    .displayName(Text.translatable("itemgroup.zetasgenesis.genesis_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(GenesisBlocks.CALCITE_BRICKS);
                        entries.add(GenesisBlocks.CALCITE_BRICK_STAIRS);
                        entries.add(GenesisBlocks.CALCITE_BRICK_SLAB);
                        entries.add(GenesisBlocks.CRACKED_CALCITE_BRICKS);
                        entries.add(GenesisBlocks.CHISELED_CALCITE_BRICKS);
                        entries.add(GenesisBlocks.CALCITE_TILES);
                        entries.add(GenesisBlocks.CALCITE_TILES_STAIRS);
                        entries.add(GenesisBlocks.CALCITE_TILE_SLAB);
                        entries.add(GenesisBlocks.CRACKED_CALCITE_TILES);
                        entries.add(GenesisBlocks.POLISHED_CALCITE);
                        entries.add(GenesisBlocks.POLISHED_CALCITE_STAIRS);
                        entries.add(GenesisBlocks.POLISHED_CALCITE_SLAB);
                        entries.add(GenesisBlocks.CALCITE_STAIRS);
                        entries.add(GenesisBlocks.CALCITE_SLAB);
                        entries.add(GenesisBlocks.RAINBOW_BLOCK);

                    })

                    .build());

    public static void registerGenesisBlockGroup() {
        ZetaGenesis.LOGGER.info("Registering Genesis Item Group for " + ZetaGenesis.MOD_ID);
    }
}
