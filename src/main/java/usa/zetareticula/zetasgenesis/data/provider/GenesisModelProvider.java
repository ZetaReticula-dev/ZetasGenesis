package usa.zetareticula.zetasgenesis.data.provider;

import usa.zetareticula.zetasgenesis.block.GenesisBlocks;
import usa.zetareticula.zetasgenesis.equipment.GenesisArmor;
import usa.zetareticula.zetasgenesis.item.GenesisItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class GenesisModelProvider extends FabricModelProvider {
    public GenesisModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CHISELED_CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.CRACKED_CALCITE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.BRASS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(GenesisBlocks.GRAV_LIFT);

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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GenesisItems.NETHER_SHARD, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.BRASS_INGOT, Models.GENERATED);
        itemModelGenerator.register(GenesisItems.ENDERIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.ENDERIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(GenesisItems.DIAMOND_PICK_AXE, Models.HANDHELD);

        itemModelGenerator.registerArmor(GenesisItems.ENDERIUM_HELMET, GenesisArmor.ENDERIUM_ARMOR_MATERIAL_KEY, "helmet", false);
        itemModelGenerator.registerArmor(GenesisItems.ENDERIUM_CHESTPLATE, GenesisArmor.ENDERIUM_ARMOR_MATERIAL_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(GenesisItems.ENDERIUM_LEGGINGS, GenesisArmor.ENDERIUM_ARMOR_MATERIAL_KEY, "leggings", false);
        itemModelGenerator.registerArmor(GenesisItems.ENDERIUM_BOOTS, GenesisArmor.ENDERIUM_ARMOR_MATERIAL_KEY, "boots", false);

    }

}
