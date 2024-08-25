package com.zetareticula.zetagenesis.item.custom;

import com.zetareticula.zetagenesis.sounds.GenesisSounds;
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

public class TeleportItem extends Item {
    private static final int COOLDOWN_TICKS = 200;  // 10 seconds cooldown (20 ticks = 1 second)

    public TeleportItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        // Check if item is on cooldown
        if (player.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(itemStack);  // Prevent item usage if on cooldown
        }

        if (!world.isClient) {  // Only execute on the server side
            // Determine raycast distance
            double maxDistance = player.isSneaking() ? 50.0D : 14.0D;

            // Get player's look vector and start position
            Vec3d lookVec = player.getRotationVec(1.0F);
            Vec3d startPos = player.getEyePos();  // Start from the player's eye position
            Vec3d endPos = startPos.add(lookVec.multiply(maxDistance));  // Use the appropriate distance

            // Play different sounds based on whether the player is sneaking
            if (player.isSneaking()) {
                world.playSound(null, player.getX(), player.getY(), player.getZ(), GenesisSounds.INSTANT_TRANSMISSION, SoundCategory.BLOCKS, 10.0F, 1.0F);
                // Apply cooldown when sneaking
                player.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            } else {
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 10.0F, 1.0F);
            }

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
                } else if (player.isSneaking()) {
                    // If sneaking and standing on a solid block, teleport to the hit position
                    player.requestTeleport(hitPos.getX() + 0.5, hitPos.getY() + 1.0, hitPos.getZ() + 0.5);  // Teleport slightly above the block
                }
            } else {
                // If no block is hit, teleport forward
                player.requestTeleport(endPos.getX(), endPos.getY(), endPos.getZ());
            }
        }

        return TypedActionResult.success(itemStack);  // Return the item stack used
    }
}