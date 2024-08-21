package com.zetareticula.zetagenesis.block;

import com.zetareticula.zetagenesis.ZetaGenesis;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.CALCITE;


public class GenesisBlocks {

    public static final Block RAINBOW_BLOCK = registerBlock("rainbow_block",
            new Block(AbstractBlock.Settings.create().strength(0.75F).requiresTool().mapColor(MapColor.BRIGHT_RED)
                    .instrument(NoteBlockInstrument.HARP).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

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
