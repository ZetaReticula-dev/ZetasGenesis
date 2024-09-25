package com.zetareticula.zetagenesis.block.custom;

import com.zetareticula.zetagenesis.sounds.GenesisSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class SpringBoard extends Block {
    // Define a boolean property to control the active/inactive state of the block
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    private static final long COOLDOWN_TICKS = 20; // Cooldown of 3 seconds (60 ticks)
    private static final Map<BlockPos, Long> soundCooldowns = new HashMap<>(); // Map to store cooldowns for each block position

    public SpringBoard(Settings settings) {
        super(settings);
        // Set the default state of the block to inactive
        this.setDefaultState(this.stateManager.getDefaultState().with(ACTIVE, false));
    }

    // This method is called when an entity steps on the block
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
// Get the current time in ticks
        long currentTime = world.getTime();
        long lastPlayed = soundCooldowns.getOrDefault(pos, 0L);

        // Check if enough time has passed since the last sound
        if (currentTime - lastPlayed >= COOLDOWN_TICKS) {
            // Play sound and update the cooldown timestamp
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), GenesisSounds.SPRING_BOARD, SoundCategory.BLOCKS, 10.0F, 1.0F);
            soundCooldowns.put(pos, currentTime); // Update the last played time
        }

        // Apply bounce logic
        double d = Math.abs(entity.getVelocity().y);
        if (d < 0.1 && !entity.bypassesSteppingEffects()) {
            double e = 0.4 + d * 0.2;
            entity.setVelocity(entity.getVelocity().multiply(e, 1.0, e));
        }

        super.onSteppedOn(world, pos, state, entity);

        if (!world.isClient && entity instanceof PlayerEntity && !state.get(ACTIVE)) {
            // Change the block's state to active
            world.setBlockState(pos, state.with(ACTIVE, true));

            // Schedule the block to revert to inactive state after 20 ticks (1 second)
            world.scheduleBlockTick(pos, this, 20);  // Correct method for scheduling tick
        }
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0F, world.getDamageSources().fall());
        }

    }

    public void onEntityLand(BlockView world, Entity entity) {

        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounce(entity);
        }

    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);  // Add the "active" property to the block's state
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(ACTIVE)) {
            world.setBlockState(pos, state.with(ACTIVE, false));
        }
    }
}
