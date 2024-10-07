package com.zetareticula.zetagenesis.block;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.entity.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class GenesisBlockEntity {
   public static final BlockEntityType<StoveBlockEntity> STOVE_BLOCK_ENTITY = register("stove_block_entity",
           BlockEntityType.Builder.create(StoveBlockEntity:: new, GenesisBlocks.STOVE).build());

    public static final BlockEntityType<SkilletBlockEntity> SKILLET_BLOCK_ENTITY = register("skillet_block_entity",
            BlockEntityType.Builder.create(SkilletBlockEntity:: new, GenesisBlocks.SKILLET).build());

    public static final BlockEntityType<BasketBlockEntity> BASKET_BLOCK_ENTITY = register("basket_block_entity",
            BlockEntityType.Builder.create(BasketBlockEntity:: new, GenesisBlocks.BASKET).build());

    public static final BlockEntityType<CabinetBlockEntity> CABINET_BLOCK_ENTITY = register("cabinet_block_entity",
            BlockEntityType.Builder.create(CabinetBlockEntity:: new, GenesisBlocks.OAK_CABINET, GenesisBlocks.SPRUCE_CABINET, GenesisBlocks.ACACIA_CABINET,
                    GenesisBlocks.BAMBOO_CABINET, GenesisBlocks.BIRCH_CABINET, GenesisBlocks.DARK_OAK_CABINET, GenesisBlocks.CHERRY_CABINET,
                    GenesisBlocks.JUNGLE_CABINET, GenesisBlocks.WARPED_CABINET, GenesisBlocks.CRIMSON_CABINET, GenesisBlocks.MANGROVE_CABINET ).build());

    public static final BlockEntityType<VariantChestBlockEntity> VARIANT_CHEST_BLOCK_ENTITY = register("variant_chest_block_entity",
            BlockEntityType.Builder.create(VariantChestBlockEntity:: new, GenesisBlocks.OAK_CHEST).build());

public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
    return Registry.register(Registries.BLOCK_ENTITY_TYPE, ZetaGenesis.id(name), type);
}
    public static void registerGenesisBlockEntity() {
        ZetaGenesis.LOGGER.info("Registering Genesis Block Entity for " + ZetaGenesis.MOD_ID);
    }
}
