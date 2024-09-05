package com.zetareticula.zetagenesis.item.custom;

import net.minecraft.item.*;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class HammerItem extends PickaxeItem {
    public HammerItem(ToolMaterial material, Item.Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof PlayerEntity player) {
            breakBlocksInPlane(world, pos, player);
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    private void breakBlocksInPlane(World world, BlockPos pos, PlayerEntity player) {
        // Determine the player's pitch and yaw to decide the plane
        float pitch = player.getPitch();
        float yaw = player.getYaw();

        // Check if the player is looking vertically (pitch close to ±90)
        if (Math.abs(pitch) > 45) {
            // Player is looking up or down, break a horizontal 3x3 plane
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos targetPos = pos.add(x, 0, z);
                    breakBlockIfPossible(world, targetPos, player);
                }
            }
        } else {
            // Player is looking horizontally, break a vertical 3x3 plane
            Direction direction = player.getHorizontalFacing();
            if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                // North or South facing, break vertically along Z
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        BlockPos targetPos = pos.add(x, y, 0);
                        breakBlockIfPossible(world, targetPos, player);
                    }
                }
            } else {
                // East or West facing, break vertically along X
                for (int z = -1; z <= 1; z++) {
                    for (int y = -1; y <= 1; y++) {
                        BlockPos targetPos = pos.add(0, y, z);
                        breakBlockIfPossible(world, targetPos, player);
                    }
                }
            }
        }
    }

    private void breakBlockIfPossible(World world, BlockPos pos, PlayerEntity player) {
        BlockState blockState = world.getBlockState(pos);
        // Check if the block can be broken
        if (canBreak(blockState, world, pos, player)) {
            world.breakBlock(pos, true, player);
        }
    }

    private boolean canBreak(BlockState state, World world, BlockPos pos, LivingEntity miner) {
        // Check if the block can be broken
        return state.getHardness(world, pos) >= 0;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // Allow enchantments
    }

}
