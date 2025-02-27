package com.zetareticula.zetasgenesis.block;

import com.zetareticula.zetasgenesis.ZetasGenesis;
import com.zetareticula.zetasgenesis.block.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GenesisBlockEntity {
    public static final BlockEntityType<StoveBlockEntity> STOVE_BLOCK_ENTITY =
            register("stove_block_entity", StoveBlockEntity::new, GenesisBlocks.STOVE);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name,
                                                                       FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
                                                                       Block... blocks) {
        Identifier id = Identifier.of(ZetasGenesis.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
    public static void initialize() {}
}
