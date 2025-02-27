package com.zetareticula.zetasgenesis.block;

import com.zetareticula.zetasgenesis.ZetasGenesis;

import com.zetareticula.zetasgenesis.block.custom.StoveBlock;
import com.zetareticula.zetasgenesis.item.GenesisItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class GenesisBlocks {

    public static final RegistryKey<Block> STOVE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ZetasGenesis.MOD_ID, "stove"));
    public static final Block STOVE = register(new StoveBlock(AbstractBlock.Settings.copy(Blocks.BRICKS)
                    .registryKey(STOVE_KEY).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()), STOVE_KEY,
            true);

    //CALCITE
    public static final RegistryKey<Block> CALCITE_BRICKS_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ZetasGenesis.MOD_ID, "calcite_bricks"));
    public static final Block CALCITE_BRICKS = register(new Block(AbstractBlock.Settings.copy(Blocks.CALCITE)
            .registryKey(CALCITE_BRICKS_KEY)), CALCITE_BRICKS_KEY, true);

    public static final RegistryKey<Block> CALCITE_TILES_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ZetasGenesis.MOD_ID, "calcite_tiles"));
    public static final Block CALCITE_TILES = register(new Block(AbstractBlock.Settings.copy(Blocks.CALCITE)
            .registryKey(CALCITE_TILES_KEY)), CALCITE_TILES_KEY, true);

    public static final RegistryKey<Block> CHISELED_CALCITE_BRICKS_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ZetasGenesis.MOD_ID, "chiseled_calcite_bricks"));
    public static final Block CHISELED_CALCITE_BRICKS = register(new Block(AbstractBlock.Settings.copy(Blocks.CALCITE)
            .registryKey(CHISELED_CALCITE_BRICKS_KEY)), CHISELED_CALCITE_BRICKS_KEY, true);






    public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void initializeBlocks() {
    }
}
