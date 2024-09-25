package com.zetareticula.zetagenesis.block.entity;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class StoveBlockEntity extends BlockEntity {

    public StoveBlockEntity(BlockPos pos, BlockState state) {
        super(GenesisBlockEntity.STOVE_BLOCK_ENTITY, pos, state);
    }
}
