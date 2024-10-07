package com.zetareticula.zetagenesis.block.entity;

import com.zetareticula.zetagenesis.utils.GenesisTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface HeatableBlockEntity {
    default boolean isHeated(World world, BlockPos pos) {
        BlockPos belowPos = pos.down(); // Get block position directly below
        BlockState blockBelowState = world.getBlockState(belowPos); // Retrieve BlockState instead of Block directly

        // Check if the block below is part of TRAY_HEAT_SOURCES tag
        if (blockBelowState.isIn(GenesisTags.Blocks.TRAY_HEAT_SOURCES)) {
            // Check if block has LIT property and if it's true
            if (blockBelowState.contains(Properties.LIT)) {
                return blockBelowState.get(Properties.LIT);
            }
            return true;
        }

        // Check for heat conductors if direct heat is not required
        if (!this.requiresDirectHeat() && blockBelowState.isIn(GenesisTags.Blocks.HEAT_CONDUCTORS)) {
            BlockState stateFurtherBelow = world.getBlockState(pos.down());
            if (stateFurtherBelow.isIn(GenesisTags.Blocks.HEAT_SOURCES)) {
                if (stateFurtherBelow.contains(Properties.LIT)) {
                    return stateFurtherBelow.get(Properties.LIT);
                }
                return true;
            }
        }

        return false;
    }

    default boolean requiresDirectHeat() {
        return false; // By default, heat conductors are allowed
    }
}

