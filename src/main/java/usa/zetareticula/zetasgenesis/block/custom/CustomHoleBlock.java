package usa.zetareticula.zetasgenesis.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class CustomHoleBlock extends Block {
    public CustomHoleBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        // Check if player is using Flint and Steel
        if (itemStack.isOf(net.minecraft.item.Items.FLINT_AND_STEEL)) {
            if (!world.isClient) {
                createHole(world, pos);
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private void createHole(World world, BlockPos center) {
        int radius = 100; // Full sphere radius (200-block diameter)

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) { // Now goes both above and below
                for (int z = -radius; z <= radius; z++) {

                    // Sphere equation: x² + y² + z² ≤ r²
                    double distance = Math.sqrt(x * x + y * y + z * z);

                    if (distance <= radius) { // Only remove blocks inside the sphere
                        BlockPos targetPos = center.add(x, y, z);

                        // Prevent removing bedrock
                        if (!world.getBlockState(targetPos).isOf(net.minecraft.block.Blocks.BEDROCK)) {
                            world.setBlockState(targetPos, net.minecraft.block.Blocks.AIR.getDefaultState());
                        }

                        // Place fire randomly
                        if (world.getBlockState(targetPos.down()).isSolidBlock(world, targetPos.down()) && world.random.nextFloat() < 0.05) {
                            world.setBlockState(targetPos, net.minecraft.block.Blocks.FIRE.getDefaultState());
                        }
                    }
                }
            }
        }

        // Damage entities inside the sphere
        world.getEntitiesByClass(net.minecraft.entity.LivingEntity.class, new Box(
                center.getX() - radius, center.getY() - radius, center.getZ() - radius,
                center.getX() + radius, center.getY() + radius, center.getZ() + radius
        ), entity -> true).forEach(entity -> {
            entity.damage((ServerWorld) world, entity.getDamageSources().magic(), 100.0F);
        });

        // Damage entities within 100 blocks of the explosion
        world.getEntitiesByClass(net.minecraft.entity.LivingEntity.class, new Box(
                center.getX() - radius * 2, center.getY() - radius * 2, center.getZ() - radius * 2,
                center.getX() + radius * 2, center.getY() + radius * 2, center.getZ() + radius * 2
        ), entity -> true).forEach(entity -> {
            if (entity.squaredDistanceTo(center.getX(), center.getY(), center.getZ()) > radius * radius) {
                entity.damage((ServerWorld) world, entity.getDamageSources().magic(), 20.0F);
            }
        });

        // Add explosion effect
        world.addParticle(net.minecraft.particle.ParticleTypes.EXPLOSION,
                center.getX(), center.getY(), center.getZ(), 0.0, 0.0, 0.0);

    }

}