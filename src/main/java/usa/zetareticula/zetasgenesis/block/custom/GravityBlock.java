package usa.zetareticula.zetasgenesis.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.UUID;

public class GravityBlock extends TranslucentBlock {

    private static final HashMap<UUID, Long> playerSoundCooldowns = new HashMap<>();
    private static final long SOUND_COOLDOWN = 1000; // 1 second cooldown

    public GravityBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int ringParticleCount = 12; // Controls the density of the ring
        int upwardParticleCount = 5; // Controls the density of vertical energy streaks

        // Generate the circular energy field (PORTAL particles)
        for (int i = 0; i < ringParticleCount; i++) {
            double angle = (2 * Math.PI * i) / ringParticleCount; // Evenly space particles in a circle
            double radius = 0.4 + (random.nextDouble() * 0.1); // Keep radius between 0.4 and 0.5 (no center particles)

            double x = pos.getX() + 0.5 + (Math.cos(angle) * radius);
            double y = pos.getY() + random.nextDouble(); // Keeps particles inside the block's height
            double z = pos.getZ() + 0.5 + (Math.sin(angle) * radius);

            world.addParticle(ParticleTypes.PORTAL, x, y, z, 0, 0.02, 0); // Slight movement for shimmer effect
        }

        // Generate the rising energy streams (END_ROD particles)
        for (int i = 0; i < upwardParticleCount; i++) {
            double x = pos.getX() + 0.2 + (random.nextDouble() * 0.6); // Slight randomization within block space
            double y = pos.getY() + random.nextDouble(); // Keeps particles inside the block's height
            double z = pos.getZ() + 0.2 + (random.nextDouble() * 0.6);

            world.addParticle(ParticleTypes.END_ROD, x, y, z, 0, 0.1, 0); // Moves particles slowly upward
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE; // Fully invisible
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity player) {
            // Play beacon sound when player enters the gravity block
            if (!world.isClient && shouldPlaySound(player)) {
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_POWER_SELECT, SoundCategory.BLOCKS, 10f, 1.0f);
                playerSoundCooldowns.put(player.getUuid(), System.currentTimeMillis()); // Apply cooldown
            }

            // Apply upward velocity
            Vec3d velocity = player.getVelocity();
            player.setVelocity(velocity.x, 0.5, velocity.z);

            if (!world.isClient) {
                player.velocityDirty = true;
            } else {
                player.velocityModified = true;
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    private static final VoxelShape DEFAULT_SHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0.125, 0, 0.0625, 0.875, 1, 0.125),
            VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.125, 1, 0.9375),
            VoxelShapes.cuboid(0.875, 0, 0.0625, 0.9375, 1, 0.9375),
            VoxelShapes.cuboid(0.125, 0, 0.875, 0.875, 1, 0.9375)
    );

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    private boolean shouldPlaySound(PlayerEntity player) {
        long currentTime = System.currentTimeMillis();
        return !playerSoundCooldowns.containsKey(player.getUuid()) ||
                (currentTime - playerSoundCooldowns.get(player.getUuid()) > SOUND_COOLDOWN);
    }
}

