package com.zetareticula.zetagenesis.data.provider;

import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.item.GenesisItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;

public class GenesisModelProvider extends FabricModelProvider {
    public GenesisModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.RAINBOW_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CHISELED_CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_CALCITE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.ENDERIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.GRIMSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.COBBLED_GRIMSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.POLISHED_GRIMSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_AMETHYST_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_AMETHYST_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_SMOOTH_AMETHYST_BRICKS);

        //CALCITE

        BlockStateModelGenerator.BlockTexturePool calcitePool =  blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CALCITE);
        calcitePool.stairs(GenesisBlocks.CALCITE_STAIRS);
        calcitePool.slab(GenesisBlocks.CALCITE_SLAB);

        BlockStateModelGenerator.BlockTexturePool CalciteTilePool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.CALCITE_TILES);
        CalciteTilePool.stairs(GenesisBlocks.CALCITE_TILES_STAIRS);
        CalciteTilePool.slab(GenesisBlocks.CALCITE_TILE_SLAB);

        BlockStateModelGenerator.BlockTexturePool CalciteBrickPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.CALCITE_BRICKS);
        CalciteBrickPool.stairs(GenesisBlocks.CALCITE_BRICK_STAIRS);
        CalciteBrickPool.slab(GenesisBlocks.CALCITE_BRICK_SLAB);

        BlockStateModelGenerator.BlockTexturePool PolishedCalcitePool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.POLISHED_CALCITE);
        PolishedCalcitePool.stairs(GenesisBlocks.POLISHED_CALCITE_STAIRS);
        PolishedCalcitePool.slab(GenesisBlocks.POLISHED_CALCITE_SLAB);

        //AMETHYST

        BlockStateModelGenerator.BlockTexturePool AmethystPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.AMETHYST_BLOCK);
        AmethystPool.stairs(GenesisBlocks.AMETHYST_STAIRS);
        AmethystPool.slab(GenesisBlocks.AMETHYST_SLAB);

        BlockStateModelGenerator.BlockTexturePool AmethystBrickPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.AMETHYST_BRICKS);
        AmethystBrickPool.stairs(GenesisBlocks.AMETHYST_BRICK_STAIRS);
        AmethystBrickPool.slab(GenesisBlocks.AMETHYST_BRICK_SLAB);

        BlockStateModelGenerator.BlockTexturePool AmethystTilePool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.AMETHYST_TILES);
        AmethystTilePool.stairs(GenesisBlocks.AMETHYST_TILE_STAIRS);
        AmethystTilePool.slab(GenesisBlocks.AMETHYST_TILE_SLAB);

        BlockStateModelGenerator.BlockTexturePool PolishedAmethystPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.POLISHED_AMETHYST);
        PolishedAmethystPool.stairs(GenesisBlocks.POLISHED_AMETHYST_STAIRS);
        PolishedAmethystPool.slab(GenesisBlocks.POLISHED_AMETHYST_SLAB);

        BlockStateModelGenerator.BlockTexturePool SmoothAmethystBrickPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(GenesisBlocks.SMOOTH_AMETHYST_BRICKS);
        SmoothAmethystBrickPool.stairs(GenesisBlocks.SMOOTH_AMETHYST_BRICK_STAIRS);
        SmoothAmethystBrickPool.slab(GenesisBlocks.SMOOTH_AMETHYST_BRICK_SLAB);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GenesisItems.GOD_POTION, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.DITTO_ITEM, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.CINNAMON_ROLL, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.URANIUM_FUEL_ROD, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.M6D_MAGNUM, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.MA5B_ASSAULT_RIFLE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.TUNING_FORK, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.LEGENDARY_HERO, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.REAPER_PEPPER, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.NULL_SPHERE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.NULL_OVOID, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.INSTANT_TRANSMISSION_CONDUIT, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.INSTANT_TRANSMISSION_MERGER, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.TRANSMISSION_TUNER, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.WARPED_STONE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.AOTE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.WARPED_AOTE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.AOTV, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.WARPED_AOTV, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.DIVAN_HELMET, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.DIVAN_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.DIVAN_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.DIVAN_BOOTS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_HELMET, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_BOOTS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENERGY_HELMET, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENERGY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENERGY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENERGY_GREAVES, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ANGEL_RING, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.TELEPORTATION_RING, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ICE_CREAM_SUNRISE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.KRABBY_PATTY, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.GLITCH_HELMET, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.GLITCH_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.GLITCH_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.GLITCH_BOOTS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.WRENCH, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.IRON_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.DIAMOND_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.NETHERITE_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.GOLDEN_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.MULTI_TOOL, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.WAND, Models.HANDHELD);


        itemModelGenerator.register(GenesisItems.SOUP_CAN, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.CABBAGE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ONION, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.FRIED_EGG, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.TOMATO_SAUCE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.WHEAT_DOUGH, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.RAW_PASTA, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.PUMPKIN_SLICE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.CABBAGE_LEAF, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.MINCED_BEEF, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.BEEF_PATTY, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.CHICKEN_CUTS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.COOKED_CHICKEN_CUTS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.BACON, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.COOKED_BACON, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.COD_SLICE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.COOKED_COD_SLICE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.SALMON_SLICE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.COOKED_SALMON_SLICE, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.MUTTON_CHOPS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.COOKED_MUTTON_CHOPS, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.HAM, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.SMOKED_HAM, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.PIE_CRUST, Models.GENERATED);

        //Soup
        itemModelGenerator.register(GenesisItems.SATURATION_SOUP_CAN, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.OPEN_SATURATION_SOUP, Models.GENERATED);

    }
}
