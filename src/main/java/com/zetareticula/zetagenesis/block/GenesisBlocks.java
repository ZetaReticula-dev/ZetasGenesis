package com.zetareticula.zetagenesis.block;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;


public class GenesisBlocks {

    public static final Block RAINBOW_BLOCK = registerBlock("rainbow_block",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.BRIGHT_RED)
                    .instrument(NoteBlockInstrument.HARP).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block WARP_PIPE = registerBlock("warp_pipe",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.GREEN).nonOpaque()
                    .instrument(NoteBlockInstrument.HARP).sounds(BlockSoundGroup.COPPER)));

    public static final Block STEEL_BEAM = registerBlock("steel_beam",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.GREEN).nonOpaque()
                    .instrument(NoteBlockInstrument.HARP).sounds(BlockSoundGroup.COPPER)));

    public static final Block SPRING_BOARD = registerBlock("spring_board",
            new SpringBoard(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.GREEN).nonOpaque()
                    .instrument(NoteBlockInstrument.HARP).sounds(BlockSoundGroup.COPPER)));

        // CALCITE
    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE)));

    public static final Block CALCITE_TILES = registerBlock("calcite_tiles",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE)));

    public static final Block CHISELED_CALCITE_BRICKS = registerBlock("chiseled_calcite_bricks",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE)));

    public static final Block CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE)));

    public static final Block CRACKED_CALCITE_TILES = registerBlock("cracked_calcite_tiles",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE)));

    public static final Block POLISHED_CALCITE = registerBlock("polished_calcite",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.CALCITE)));

    public static final Block CALCITE_STAIRS = registerBlock("calcite_stairs",
            new StairsBlock(GenesisBlocks.CALCITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(CALCITE_BRICKS)));

    public static final Block CALCITE_TILES_STAIRS = registerBlock("calcite_tiles_stairs",
            new StairsBlock(GenesisBlocks.CALCITE_TILES.getDefaultState(), AbstractBlock.Settings.copy(CALCITE_TILES)));

    public static final Block CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs",
            new StairsBlock(GenesisBlocks.CALCITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(CALCITE_BRICKS)));

    public static final Block POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs",
            new StairsBlock(GenesisBlocks.POLISHED_CALCITE.getDefaultState(), AbstractBlock.Settings.copy(POLISHED_CALCITE)));

    public static final Block CALCITE_SLAB = registerBlock("calcite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(CALCITE)));

    public static final Block CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(CALCITE_BRICKS)));

    public static final Block CALCITE_TILE_SLAB = registerBlock("calcite_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(CALCITE_TILES)));

    public static final Block POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(POLISHED_CALCITE)));

        // AMETHYST

    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block AMETHYST_TILES = registerBlock("amethyst_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block CRACKED_AMETHYST_BRICKS = registerBlock("cracked_amethyst_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block CRACKED_AMETHYST_TILES = registerBlock("cracked_amethyst_tiles",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block POLISHED_AMETHYST = registerBlock("polished_amethyst",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block SMOOTH_AMETHYST_BRICKS = registerBlock("smooth_amethyst_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block CRACKED_SMOOTH_AMETHYST_BRICKS = registerBlock("cracked_smooth_amethyst_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));


                //STAIRS

    public static final Block AMETHYST_STAIRS = registerBlock("amethyst_stairs",
            new StairsBlock(AMETHYST_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

    public static final Block AMETHYST_BRICK_STAIRS = registerBlock("amethyst_brick_stairs",
            new StairsBlock(GenesisBlocks.AMETHYST_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

    public static final Block AMETHYST_TILE_STAIRS = registerBlock("amethyst_tile_stairs",
            new StairsBlock(GenesisBlocks.AMETHYST_TILES.getDefaultState(), AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

    public static final Block POLISHED_AMETHYST_STAIRS = registerBlock("polished_amethyst_stairs",
            new StairsBlock(GenesisBlocks.POLISHED_AMETHYST.getDefaultState(), AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

    public static final Block SMOOTH_AMETHYST_BRICK_STAIRS = registerBlock("smooth_amethyst_brick_stairs",
            new StairsBlock(GenesisBlocks.SMOOTH_AMETHYST_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

                //SLABS

    public static final Block AMETHYST_SLAB = registerBlock("amethyst_slab",
            new SlabBlock(AbstractBlock.Settings.copy(AMETHYST_BLOCK)));

    public static final Block AMETHYST_BRICK_SLAB = registerBlock("amethyst_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(AMETHYST_BRICKS)));

    public static final Block AMETHYST_TILE_SLAB = registerBlock("amethyst_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(AMETHYST_TILES)));

    public static final Block POLISHED_AMETHYST_SLAB = registerBlock("polished_amethyst_slab",
            new SlabBlock(AbstractBlock.Settings.copy(POLISHED_AMETHYST)));

    public static final Block SMOOTH_AMETHYST_BRICK_SLAB = registerBlock("smooth_amethyst_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(SMOOTH_AMETHYST_BRICKS)));


    //ENDERIUM
    public static final Block ENDERIUM_ORE = registerBlock("enderium_ore",
            new Block(AbstractBlock.Settings.create().strength(50.0F, 1200.0F).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block GRIMSTONE = registerBlock("grimstone",
            new Block(AbstractBlock.Settings.copy(DEEPSLATE)));

    public static final Block COBBLED_GRIMSTONE = registerBlock("cobbled_grimstone",
            new Block(AbstractBlock.Settings.copy(COBBLED_DEEPSLATE)));

    public static final Block POLISHED_GRIMSTONE = registerBlock("polished_grimstone",
            new Block(AbstractBlock.Settings.copy(POLISHED_DEEPSLATE)));

    public static final Block SLEEPING_BAG = registerBlock("sleeping_bag", new BedBlock(DyeColor.LIME, AbstractBlock.Settings.create()));

    //GRASS
    public static final Block CHERRY_GRASS_BLOCK = registerBlock("cherry_grove_grass",
            new Block(AbstractBlock.Settings.copy(GRASS_BLOCK)));

    public static final Block STOVE = registerBlock("stove",
            new StoveBlock(AbstractBlock.Settings.copy(BRICKS)));

    public static final Block BASKET = registerBlock("basket",
            new BasketBlock(AbstractBlock.Settings.copy(BAMBOO_PLANKS).nonOpaque()));

    //CABINETS

    public static final Block OAK_CABINET = registerBlock("oak_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block SPRUCE_CABINET = registerBlock("spruce_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block BIRCH_CABINET = registerBlock("birch_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block JUNGLE_CABINET = registerBlock("jungle_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block ACACIA_CABINET = registerBlock("acacia_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block DARK_OAK_CABINET = registerBlock("dark_oak_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block MANGROVE_CABINET = registerBlock("mangrove_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL)));

    public static final Block CHERRY_CABINET = registerBlock("cherry_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL).sounds(BlockSoundGroup.CHERRY_WOOD)));

    public static final Block BAMBOO_CABINET = registerBlock("bamboo_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL).sounds(BlockSoundGroup.BAMBOO)));

    public static final Block CRIMSON_CABINET = registerBlock("crimson_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block WARPED_CABINET = registerBlock("warped_cabinet",
            new CabinetBlock(AbstractBlock.Settings.copy(BARREL).sounds(BlockSoundGroup.NETHER_WOOD)));

    //CRAFTING TABLES

    public static final Block ACACIA_CRAFTING_TABLE = registerBlock("acacia_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block BAMBOO_CRAFTING_TABLE = registerBlock("bamboo_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block BIRCH_CRAFTING_TABLE = registerBlock("birch_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block CHERRY_CRAFTING_TABLE = registerBlock("cherry_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block CRIMSON_CRAFTING_TABLE = registerBlock("crimson_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block DARK_OAK_CRAFTING_TABLE = registerBlock("dark_oak_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block JUNGLE_CRAFTING_TABLE = registerBlock("jungle_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block MANGROVE_CRAFTING_TABLE = registerBlock("mangrove_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block SPRUCE_CRAFTING_TABLE = registerBlock("spruce_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));

    public static final Block WARPED_CRAFTING_TABLE = registerBlock("warped_crafting_table",
            new VariantCraftingTable(AbstractBlock.Settings.copy(CRAFTING_TABLE)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ZetaGenesis.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ZetaGenesis.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerGenesisBlocks() {
        ZetaGenesis.LOGGER.info("Registering Genesis Blocks for " + ZetaGenesis.MOD_ID);
    }
}
