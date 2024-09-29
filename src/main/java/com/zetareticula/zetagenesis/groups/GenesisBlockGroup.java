package com.zetareticula.zetagenesis.groups;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GenesisBlockGroup {
    public static final ItemGroup GENESIS_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ZetaGenesis.MOD_ID, "genesis_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GenesisBlocks.CALCITE_BRICKS))
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
                        //AMETHYST
                        entries.add(GenesisBlocks.AMETHYST_STAIRS);
                        entries.add(GenesisBlocks.AMETHYST_SLAB);
                        entries.add(GenesisBlocks.AMETHYST_BRICKS);
                        entries.add(GenesisBlocks.AMETHYST_BRICK_STAIRS);
                        entries.add(GenesisBlocks.AMETHYST_BRICK_SLAB);
                        entries.add(GenesisBlocks.CRACKED_AMETHYST_BRICKS);
                        entries.add(GenesisBlocks.AMETHYST_TILES);
                        entries.add(GenesisBlocks.AMETHYST_TILE_STAIRS);
                        entries.add(GenesisBlocks.AMETHYST_TILE_SLAB);
                        entries.add(GenesisBlocks.CRACKED_AMETHYST_TILES);
                        entries.add(GenesisBlocks.POLISHED_AMETHYST);
                        entries.add(GenesisBlocks.POLISHED_AMETHYST_STAIRS);
                        entries.add(GenesisBlocks.POLISHED_AMETHYST_SLAB);
                        entries.add(GenesisBlocks.SMOOTH_AMETHYST_BRICKS);
                        entries.add(GenesisBlocks.SMOOTH_AMETHYST_BRICK_SLAB);
                        entries.add(GenesisBlocks.SMOOTH_AMETHYST_BRICK_STAIRS);
                        entries.add(GenesisBlocks.CRACKED_SMOOTH_AMETHYST_BRICKS);

                        //CRAFTING TABLES
                        entries.add(GenesisBlocks.ACACIA_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.BAMBOO_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.BIRCH_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.CHERRY_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.CRIMSON_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.DARK_OAK_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.JUNGLE_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.MANGROVE_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.SPRUCE_CRAFTING_TABLE);
                        entries.add(GenesisBlocks.WARPED_CRAFTING_TABLE);

                        entries.add(GenesisBlocks.RAINBOW_BLOCK);
                        entries.add(GenesisBlocks.GRIMSTONE);
                        entries.add(GenesisBlocks.COBBLED_GRIMSTONE);
                        entries.add(GenesisBlocks.ENDERIUM_ORE);

                    })

                    .build());

    public static void registerGenesisBlockGroup() {
        ZetaGenesis.LOGGER.info("Registering Genesis Item Group for " + ZetaGenesis.MOD_ID);
    }
}
