package usa.zetareticula.zetasgenesis.block;

import usa.zetareticula.zetasgenesis.ZetasGenesis;

import usa.zetareticula.zetasgenesis.block.custom.CustomHoleBlock;
import usa.zetareticula.zetasgenesis.block.custom.GravLift;
import usa.zetareticula.zetasgenesis.block.custom.GravityBlock;
import usa.zetareticula.zetasgenesis.block.custom.StoveBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static net.minecraft.block.Blocks.CALCITE;

public class GenesisBlocks {

    public static final Block STOVE =
            register("stove", StoveBlock::new, AbstractBlock.Settings.copy(Blocks.BRICKS), true);

    //CALCITE

    public static final Block CALCITE_BRICKS =
            register("calcite_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CALCITE_TILES =
            register("calcite_tiles", Block::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CHISELED_CALCITE_BRICKS =
            register("chiseled_calcite_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CRACKED_CALCITE_BRICKS =
            register("cracked_calcite_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CRACKED_CALCITE_TILES =
            register("cracked_calcite_tiles", Block::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block POLISHED_CALCITE =
            register("polished_calcite", Block::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CALCITE_STAIRS =
            register("calcite_stairs", settings -> new StairsBlock(CALCITE.getDefaultState(), settings),
                    AbstractBlock.Settings.copy(CALCITE), true);

    public static final Block CALCITE_TILES_STAIRS =
            register("calcite_tiles_stairs", settings -> new StairsBlock(CALCITE_TILES.getDefaultState(), settings),
                    AbstractBlock.Settings.copy(CALCITE), true);

    public static final Block CALCITE_BRICK_STAIRS =
            register("calcite_brick_stairs", settings -> new StairsBlock(CALCITE_BRICKS.getDefaultState(), settings),
                    AbstractBlock.Settings.copy(CALCITE), true);

    public static final Block POLISHED_CALCITE_STAIRS =
            register("polished_calcite_stairs", settings -> new StairsBlock(POLISHED_CALCITE.getDefaultState(), settings),
                    AbstractBlock.Settings.copy(CALCITE), true);

    public static final Block CALCITE_SLAB =
            register("calcite_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CALCITE_BRICK_SLAB =
            register("calcite_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block CALCITE_TILE_SLAB =
            register("calcite_tile_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    public static final Block POLISHED_CALCITE_SLAB =
            register("polished_calcite_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.CALCITE), true);

    //BRASS
    public static final Block BRASS_BLOCK =
            register("brass_block", Block::new, AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK), true);

    public static final Block TEST_EXPLOSION =
            register("test_explosion", CustomHoleBlock::new, AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK), true);
    public static final Block GRAV_LIFT =
            register("grav_lift", GravLift::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK), true);

    public static final Block GRAVITY_BLOCK =
            register("gravity_block", GravityBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).noCollision().nonOpaque(), true);






    public static final RegistryKey<ItemGroup> GENESIS_BLOCK_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ZetasGenesis.MOD_ID, "genesis_blocks"));
    public static final ItemGroup GENESIS_BLOCK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(GenesisBlocks.BRASS_BLOCK))
            .displayName(Text.translatable("itemGroup.genesis_blocks"))
            .build();

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }


    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ZetasGenesis.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, name));
    }

    public static void initializeBlocks() {
        Registry.register(Registries.ITEM_GROUP, GENESIS_BLOCK_GROUP_KEY, GENESIS_BLOCK_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GENESIS_BLOCK_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(GenesisBlocks.STOVE);
            itemGroup.add(GenesisBlocks.CALCITE_BRICKS);
            itemGroup.add(GenesisBlocks.CALCITE_TILES);
            itemGroup.add(GenesisBlocks.CHISELED_CALCITE_BRICKS);
            itemGroup.add(GenesisBlocks.CRACKED_CALCITE_BRICKS);
            itemGroup.add(GenesisBlocks.CRACKED_CALCITE_TILES);
            itemGroup.add(GenesisBlocks.POLISHED_CALCITE);
            itemGroup.add(GenesisBlocks.CALCITE_STAIRS);
            itemGroup.add(GenesisBlocks.CALCITE_TILES_STAIRS);
            itemGroup.add(GenesisBlocks.CALCITE_BRICK_STAIRS);
            itemGroup.add(GenesisBlocks.POLISHED_CALCITE_STAIRS);
            itemGroup.add(GenesisBlocks.CALCITE_SLAB);
            itemGroup.add(GenesisBlocks.CALCITE_BRICK_SLAB);
            itemGroup.add(GenesisBlocks.CALCITE_TILE_SLAB);
            itemGroup.add(GenesisBlocks.POLISHED_CALCITE_SLAB);
            itemGroup.add(GenesisBlocks.BRASS_BLOCK);
        });
    }
}
