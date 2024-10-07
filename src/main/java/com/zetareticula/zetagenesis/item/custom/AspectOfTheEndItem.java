package com.zetareticula.zetagenesis.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class AspectOfTheEndItem extends Item {
    private final int teleportationRange;
    private final int fallDamage;
    private final int useDamage;

    public AspectOfTheEndItem(Settings settings, int teleportationRange, int fallDamage, int useDamage) {
        super(settings);
        this.teleportationRange = teleportationRange;
        this.fallDamage = fallDamage;
        this.useDamage = useDamage;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        player.getStackInHand(hand).damage(this.useDamage, player, EquipmentSlot.MAINHAND);

        if (!world.isClient) {  // Only execute on the server side
            // Set a fixed raycast distance (no sneaking condition)
            double maxDistance = 10.0D;

            // Get player's look vector and start position
            Vec3d lookVec = player.getRotationVec(1.0F);
            Vec3d startPos = player.getEyePos();  // Start from the player's eye position
            Vec3d endPos = startPos.add(lookVec.multiply(maxDistance));  // Use the appropriate distance

            // Play sound when using the item
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 10.0F, 1.0F);

            // Perform raycasting
            BlockHitResult hitResult = world.raycast(new RaycastContext(
                    startPos,
                    endPos,
                    RaycastContext.ShapeType.OUTLINE,
                    RaycastContext.FluidHandling.NONE,
                    player
            ));

            // Check if the raycast hit a block
            if (hitResult.getType() == BlockHitResult.Type.BLOCK) {
                BlockPos hitPos = hitResult.getBlockPos().offset(hitResult.getSide());
                if (!world.getBlockState(hitPos).isSolidBlock(world, hitPos)) {
                    // Teleport player if the block is not solid
                    player.requestTeleport(hitPos.getX() + 0.5, hitPos.getY(), hitPos.getZ() + 0.5);
                } else {
                    // If standing on a solid block, teleport to the hit position
                    player.requestTeleport(hitPos.getX() + 0.5, hitPos.getY() + 1.0, hitPos.getZ() + 0.5);  // Teleport slightly above the block
                }
            } else {
                // If no block is hit, teleport forward
                player.requestTeleport(endPos.getX(), endPos.getY(), endPos.getZ());
            }
            player.fallDistance = this.fallDamage;
        }

        return TypedActionResult.success(itemStack);  // Return the item stack used
    }
}