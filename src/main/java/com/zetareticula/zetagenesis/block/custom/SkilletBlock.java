package com.zetareticula.zetagenesis.block.custom;

import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.block.entity.SkilletBlockEntity;
import com.zetareticula.zetagenesis.block.entity.StoveBlockEntity;
import com.zetareticula.zetagenesis.utils.GenesisTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.stat.Stats;
import net.minecraft.state.State;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SkilletBlock extends Block implements BlockEntityProvider {
    private static final Map<Direction, VoxelShape> SHAPES = new HashMap<>();
    protected static final VoxelShape DEFAULT_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty SUPPORT = BooleanProperty.of("support");

    public SkilletBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
        setDefaultState(getDefaultState().with(SUPPORT, false));
        for (Direction direction : Direction.values()) {
            SHAPES.put(direction, calculateShapes(direction, DEFAULT_SHAPE));

        }
    }




    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis() == Direction.Axis.Y) {
            return state.with(SUPPORT, getTrayState(world, pos));
        }
        return state;
    }


    private static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = {shape, VoxelShapes.empty()};

        final int times = (to.getHorizontal() - Direction.NORTH.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) ->
                    buffer[1] = VoxelShapes.union(buffer[1],
                            VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

    private boolean getTrayState(WorldAccess world, BlockPos pos) {
        BlockPos belowPos = pos.down(); // Get the position below
        Block blockBelow = world.getBlockState(belowPos).getBlock(); // Get the block at that position
        return blockBelow.getDefaultState().isIn(GenesisTags.Blocks.TRAY_HEAT_SOURCES); // Check if the block is in the tag
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES.get(state.get(FACING));
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.getBlockEntity(pos) instanceof SkilletBlockEntity skilletBlockEntity) {
            ItemStack itemStack = player.getStackInHand(hand);
            Optional<RecipeEntry<CampfireCookingRecipe>> optional = skilletBlockEntity.getRecipeFor(itemStack);
            if (optional.isPresent()) {
                if (!world.isClient && skilletBlockEntity.addItem(player, itemStack, ((CampfireCookingRecipe)((RecipeEntry)optional.get()).value()).getCookingTime())) {
                    player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return ItemActionResult.SUCCESS;
                }

                return ItemActionResult.CONSUME;
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SUPPORT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(SUPPORT, getTrayState(ctx.getWorld(), ctx.getBlockPos()));
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return GenesisBlockEntity.SKILLET_BLOCK_ENTITY.instantiate(pos, state);
    }


}
