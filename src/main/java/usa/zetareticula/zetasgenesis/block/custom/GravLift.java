package usa.zetareticula.zetasgenesis.block.custom;

import usa.zetareticula.zetasgenesis.block.GenesisBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GravLift extends Block {

    public GravLift(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, net.minecraft.entity.LivingEntity placer, net.minecraft.item.ItemStack itemStack) {
        if (!world.isClient) {
            for (int i = 1; i <= 20; i++) { // Create a 20-block column
                BlockPos abovePos = pos.up(i);
                world.setBlockState(abovePos, GenesisBlocks.GRAVITY_BLOCK.getDefaultState());
            }
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient) {
            for (int i = 1; i <= 20; i++) { // Remove the column when the base is broken
                BlockPos abovePos = pos.up(i);
                world.removeBlock(abovePos, false);
            }
        }
        super.onBreak(world, pos, state, player);
        return state;
    }
}
