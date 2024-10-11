package com.zetareticula.zetagenesis.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.RaycastContext;
import org.joml.Vector3f;

public class WandItem extends Item {

    private int colorIndex = 0;  // Keeps track of the current color

    public WandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient) {
            // Spawn particles on the client
            shootRay(player, world);
        } else {
            // Handle damage on the server
            handleDamage(player, world);
        }
        world.playSound(
                null, player.getBlockPos(), SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.PLAYERS, 1.0F, 1.0F
        );
        player.getItemCooldownManager().set(this, 5);
        player.getStackInHand(hand).damage(1,player, EquipmentSlot.MAINHAND);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    // Method to handle the particle effects
    private void shootRay(PlayerEntity player, World world) {
        Vec3d startPos = player.getCameraPosVec(1.0F); // Start position from the player's view
        Vec3d lookVector = player.getRotationVec(1.0F).normalize(); // Direction player is looking
        Vec3d endPos = startPos.add(lookVector.multiply(7)); // End position of the ray (7 blocks long)

        // Perform raycast for block hit detection
        BlockHitResult hitResult = world.raycast(new RaycastContext(
                startPos, endPos, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));

        // Get the color for this click based on colorIndex
        float[] color = getRainbowColors()[colorIndex];

        // Increase the number of particles by reducing the gap between them (e.g., 0.1 block gap)
        for (double i = 0; i < 7; i += 0.1) {
            Vec3d particlePos = startPos.add(lookVector.multiply(i));
            DustParticleEffect particle = new DustParticleEffect(new Vector3f(color[0], color[1], color[2]), 1.0F);
            world.addParticle(particle, particlePos.x, particlePos.y, particlePos.z, 0.0, 0.0, 0.0);
        }

        // Cycle to the next color for the next use
        colorIndex = (colorIndex + 1) % getRainbowColors().length;
    }

    // Method to handle damage to entities
    private void handleDamage(PlayerEntity player, World world) {
        Vec3d startPos = player.getCameraPosVec(1.0F); // Start position from the player's view
        Vec3d lookVector = player.getRotationVec(1.0F).normalize(); // Direction player is looking
        Vec3d endPos = startPos.add(lookVector.multiply(7)); // End position of the ray (7 blocks long)

        // Perform raycast to find entities
        EntityHitResult entityHitResult = ProjectileUtil.getEntityCollision(world, player, startPos, endPos,
                player.getBoundingBox().expand(7), entity -> !entity.isSpectator() && entity.isAttackable());

        if (entityHitResult != null) {
            Entity hitEntity = entityHitResult.getEntity();
            // Damage the entity by 4 points (2 hearts)
            hitEntity.damage(world.getDamageSources().playerAttack(player), 4);
        }
    }

    // Helper function to return the RGB colors for ROYGBIV
    private float[][] getRainbowColors() {
        return new float[][] {
                {1.0F, 0.0F, 0.0F},  // Red
                {1.0F, 0.5F, 0.0F},  // Orange
                {1.0F, 1.0F, 0.0F},  // Yellow
                {0.0F, 1.0F, 0.0F},  // Green
                {0.0F, 0.0F, 1.0F},  // Blue
                {0.29F, 0.0F, 0.51F},// Indigo
                {0.56F, 0.0F, 1.0F}  // Violet
        };
    }
}


