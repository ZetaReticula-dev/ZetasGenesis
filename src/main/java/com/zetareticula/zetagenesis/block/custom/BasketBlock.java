package com.zetareticula.zetagenesis.block.custom;

import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.block.entity.BasketBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BasketBlock extends Block implements BlockEntityProvider {
    public BasketBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            if(world.getBlockEntity(pos) instanceof BasketBlockEntity basketBlockEntity) {
                player.openHandledScreen(basketBlockEntity);
            }
        }
        return ActionResult.success(world.isClient);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return GenesisBlockEntity.BASKET_BLOCK_ENTITY.instantiate(pos, state);
    }
}
