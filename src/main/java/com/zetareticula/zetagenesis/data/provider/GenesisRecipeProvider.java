package com.zetareticula.zetagenesis.data.provider;

import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.item.GenesisItems;
import com.zetareticula.zetagenesis.utils.GenesisTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GenesisRecipeProvider extends FabricRecipeProvider {
    public GenesisRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_HELMET)
                .pattern("bbb")
                .pattern("b b")
                .input('b', GenesisItems.ENDERIUM_INGOT)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_CHESTPLATE)
                .pattern("b b")
                .pattern("bbb")
                .pattern("bbb")
                .input('b', GenesisItems.ENDERIUM_INGOT)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_LEGGINGS)
                .pattern("bbb")
                .pattern("b b")
                .pattern("b b")
                .input('b', GenesisItems.ENDERIUM_INGOT)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_BOOTS)
                .pattern("b b")
                .pattern("b b")
                .input('b', GenesisItems.ENDERIUM_INGOT)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_SWORD)
                .pattern("e")
                .pattern("e")
                .pattern("s")
                .input('e', GenesisItems.ENDERIUM_INGOT).input('s', Items.STICK)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_PICKAXE)
                .pattern("eee")
                .pattern(" s ")
                .pattern(" s ")
                .input('e', GenesisItems.ENDERIUM_INGOT).input('s', Items.STICK)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_AXE)
                .pattern("ee")
                .pattern("es")
                .pattern(" s")
                .input('e', GenesisItems.ENDERIUM_INGOT).input('s', Items.STICK)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_SHOVEL)
                .pattern("e")
                .pattern("s")
                .pattern("s")
                .input('e', GenesisItems.ENDERIUM_INGOT).input('s', Items.STICK)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GenesisItems.ENDERIUM_HOE)
                .pattern("ee")
                .pattern(" s")
                .pattern(" s")
                .input('e', GenesisItems.ENDERIUM_INGOT).input('s', Items.STICK)
                .criterion(hasItem(GenesisItems.ENDERIUM_INGOT), conditionsFromItem(GenesisItems.ENDERIUM_INGOT)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, GenesisItems.MULTI_TOOL)
                .pattern("#IM")
                .pattern("ccZ")
                .pattern("Ncc").input('#', Items.IRON_SWORD).input('I', Items.IRON_PICKAXE).input('M', Items.IRON_HOE).input('c', Items.COPPER_INGOT)
                .input('Z', Items.IRON_SHOVEL).input('N', Items.IRON_AXE)  .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD)).offerTo(exporter);


        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICKS, GenesisBlocks.POLISHED_CALCITE);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_TILES, GenesisBlocks.CALCITE_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CHISELED_CALCITE_BRICKS, GenesisBlocks.CALCITE_BRICK_SLAB);
        List<ItemConvertible> CALCITE_BRICKS = List.of(GenesisBlocks.CALCITE_BRICK_STAIRS);
        offerSmelting(exporter, CALCITE_BRICKS, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICK_SLAB, 0.1F, 200, "calcite");
        List<ItemConvertible> CALCITE_TILES = List.of(GenesisBlocks.CRACKED_CALCITE_TILES);
        offerSmelting(exporter, CALCITE_BRICKS, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CRACKED_CALCITE_TILES, 0.1F, 200, "calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.POLISHED_CALCITE, Blocks.CALCITE);
        offerStairRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_STAIRS, Blocks.CALCITE);
        offerStairRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICK_STAIRS, GenesisBlocks.CALCITE_BRICKS);
        offerStairRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_TILES_STAIRS, GenesisBlocks.CALCITE_TILES);
        offerStairRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.POLISHED_CALCITE_STAIRS, GenesisBlocks.POLISHED_CALCITE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_SLAB, Blocks.CALCITE);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICK_SLAB, GenesisBlocks.CALCITE_BRICKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_TILE_SLAB, GenesisBlocks.CALCITE_TILES);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.POLISHED_CALCITE_SLAB, GenesisBlocks.POLISHED_CALCITE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_SLAB, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_STAIRS, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICKS, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICK_SLAB, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_BRICK_STAIRS, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CHISELED_CALCITE_BRICKS, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_TILES, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_TILE_SLAB, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.CALCITE_TILES_STAIRS, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.POLISHED_CALCITE, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.POLISHED_CALCITE_SLAB, Blocks.CALCITE );
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GenesisBlocks.POLISHED_CALCITE_STAIRS, Blocks.CALCITE );

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.ACACIA_CRAFTING_TABLE, Blocks.ACACIA_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.BAMBOO_CRAFTING_TABLE, Blocks.BAMBOO_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.BIRCH_CRAFTING_TABLE, Blocks.BIRCH_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.CHERRY_CRAFTING_TABLE, Blocks.CHERRY_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.CRIMSON_CRAFTING_TABLE, Blocks.CRIMSON_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.DARK_OAK_CRAFTING_TABLE, Blocks.DARK_OAK_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.JUNGLE_CRAFTING_TABLE, Blocks.JUNGLE_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.MANGROVE_CRAFTING_TABLE, Blocks.MANGROVE_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.SPRUCE_CRAFTING_TABLE, Blocks.SPRUCE_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.WARPED_CRAFTING_TABLE, Blocks.WARPED_PLANKS);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, GenesisBlocks.OAK_CRAFTING_TABLE, Blocks.OAK_PLANKS);




    }

    public static void offerStairRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output, 4)
                .input('#', input)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}
