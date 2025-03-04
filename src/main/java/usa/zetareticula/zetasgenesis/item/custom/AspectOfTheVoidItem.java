package usa.zetareticula.zetasgenesis.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class AspectOfTheVoidItem extends Item {
    private final int cooldownTick;  // 10 seconds cooldown (20 ticks = 1 second)
    private final int instantRange;
    private final int teleportationRange;
    private final int fallDamage;
    private final int useDamage;
    private final int instantDamage;


    public AspectOfTheVoidItem(Settings settings, int instantRange, int teleportationRange, int fallDamage, int useDamage, int instantDamage, int cooldownTick) {
        super(settings);
        this.instantRange = instantRange;
        this.teleportationRange = teleportationRange;
        this.fallDamage = fallDamage;
        this.useDamage = useDamage;
        this.instantDamage = instantDamage;
        this.cooldownTick = cooldownTick;


    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        player.getStackInHand(hand).damage(this.useDamage,player, EquipmentSlot.MAINHAND);
        // Check if item is on cooldown
        if (player.getItemCooldownManager().isCoolingDown(itemStack)) {
            return ActionResult.FAIL;  // Prevent item usage if on cooldown
        }

        if (!world.isClient) {  // Only execute on the server side
            // Determine raycast distance
            double maxDistance = player.isSneaking() ? this.instantRange : this.teleportationRange;

            // Get player's look vector and start position
            Vec3d lookVec = player.getRotationVec(1.0F);
            Vec3d startPos = player.getEyePos();  // Start from the player's eye position
            Vec3d endPos = startPos.add(lookVec.multiply(maxDistance));  // Use the appropriate distance

            // Play different sounds based on whether the player is sneaking
            if (player.isSneaking()) {
                player.getStackInHand(hand).damage(this.instantDamage,player, EquipmentSlot.MAINHAND);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDER_DRAGON_HURT, SoundCategory.BLOCKS, 10.0F, 1.0F);
                // Apply cooldown when sneaking
                player.getItemCooldownManager().set(itemStack, this.cooldownTick);
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
            player.fallDistance = this.fallDamage;
        }

        return ActionResult.SUCCESS;  // Return the item stack used
    }
}
