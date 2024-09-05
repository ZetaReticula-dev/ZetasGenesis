package com.zetareticula.zetagenesis.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class KamehamehaItem extends Item {

    public KamehamehaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!world.isClient) {
            // Play the Warden's sonic boom sound (repurposed for Kamehameha)
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_WARDEN_SONIC_BOOM,
                    SoundCategory.PLAYERS, 1.0F, 1.0F);

            // Spawn particles, create explosion, and damage entities along the beam
            spawnKamehameha(world, player);

            // Optional: Decrease item durability or consume the item
            // itemStack.damage(1, player, (p) -> p.sendToolBreakStatus(hand));
        }

        // Return the result to indicate the action was successful
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    private void spawnKamehameha(World world, PlayerEntity player) {
        // The length of the Kamehameha attack
        int length = 20;

        // The direction the player is facing
        double pitch = Math.toRadians(player.getPitch());
        double yaw = Math.toRadians(player.getYaw());

        // Calculate the direction vector
        double dx = -Math.sin(yaw) * Math.cos(pitch);
        double dy = -Math.sin(pitch);
        double dz = Math.cos(yaw) * Math.cos(pitch);

        // Define the start and end points of the beam
        Vec3d startPos = player.getEyePos();
        Vec3d endPos = startPos.add(dx * length, dy * length, dz * length);

        // Spawn particles along the direction vector
        for (int i = 0; i < length; i++) {
            double x = startPos.x + dx * i;
            double y = startPos.y + dy * i;
            double z = startPos.z + dz * i;

        }

        // Damage entities along the beam
        Box beamBox = new Box(startPos, endPos).expand(1.0); // A box along the beam with some thickness
        List<Entity> entities = world.getOtherEntities(player, beamBox, entity -> entity instanceof LivingEntity);

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                Vec3d closestPoint = new Vec3d(
                        Math.max(startPos.x, Math.min(entity.getX(), endPos.x)),
                        Math.max(startPos.y, Math.min(entity.getY(), endPos.y)),
                        Math.max(startPos.z, Math.min(entity.getZ(), endPos.z))
                );

                // Calculate distance from entity to beam
                double distance = startPos.distanceTo(closestPoint);

                // Deal damage based on proximity to the beam (optional, fixed amount here
            }
        }

        // Simulate an explosion at the end of the Kamehameha
        world.createExplosion(null, endPos.x, endPos.y, endPos.z,
                4.0F, World.ExplosionSourceType.TNT);
    }
}