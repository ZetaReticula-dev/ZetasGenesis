package com.zetareticula.zetagenesis.block;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.entity.BasketBlockEntity;
import com.zetareticula.zetagenesis.block.entity.StoveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class GenesisBlockEntity {
   public static final BlockEntityType<StoveBlockEntity> STOVE_BLOCK_ENTITY = register("stove_block_entity",
           BlockEntityType.Builder.create(StoveBlockEntity:: new, GenesisBlocks.STOVE).build());

    public static final BlockEntityType<BasketBlockEntity> BASKET_BLOCK_ENTITY = register("basket_block_entity",
            BlockEntityType.Builder.create(BasketBlockEntity:: new, GenesisBlocks.BASKET).build());

public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
    return Registry.register(Registries.BLOCK_ENTITY_TYPE, ZetaGenesis.id(name), type);
}
    public static void registerGenesisBlockEntity() {
        ZetaGenesis.LOGGER.info("Registering Genesis Block Entity for " + ZetaGenesis.MOD_ID);
    }
}
