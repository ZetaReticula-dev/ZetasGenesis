package com.zetareticula.zetasgenesis.block.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zetareticula.zetasgenesis.block.GenesisBlockEntity;
import com.zetareticula.zetasgenesis.block.entity.StoveBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StoveBlock extends BlockWithEntity {
    public static final BooleanProperty LIT = Properties.LIT;
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<StoveBlock> CODEC = createCodec(StoveBlock::new);
    public StoveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<StoveBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, FACING);
    }
    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item heldItem = stack.getItem();
        if (world.getBlockEntity(pos) instanceof StoveBlockEntity stoveBlockEntity) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (world.getRecipeManager().getPropertySet(RecipePropertySet.CAMPFIRE_INPUT).canUse(itemStack)) {
                if (world instanceof ServerWorld serverWorld && stoveBlockEntity.addItem(player, stack, 600)) {
                    player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return ActionResult.SUCCESS_SERVER;
                }

                return ActionResult.CONSUME;
            }

            if (state.get(LIT)) {
                if (heldItem instanceof ShovelItem) {
                    world.setBlockState(pos, state.with(LIT, false));
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    player.getStackInHand(hand).damage(1,player, EquipmentSlot.MAINHAND);
                    return ActionResult.SUCCESS;
                } else if (heldItem == Items.WATER_BUCKET){
                    world.setBlockState(pos, state.with(LIT, false));
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                    return ActionResult.SUCCESS;
                }

            } else {
                if (heldItem == Items.FLINT_AND_STEEL) {
                    world.setBlockState(pos, state.with(LIT, true));
                    world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    player.getStackInHand(hand).damage(1,player, EquipmentSlot.MAINHAND);
                    return ActionResult.SUCCESS;
                } else if (heldItem == Items.FIRE_CHARGE) {
                    world.setBlockState(pos, state.with(LIT, true));
                    world.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    player.getStackInHand(hand).decrement(1);
                    return ActionResult.SUCCESS;
                }}
        }



        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StoveBlockEntity) {
                ItemScatterer.spawn(world, pos, ((StoveBlockEntity)blockEntity).getItemsBeingCooked());
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            double d = (double)pos.getX() + 0.5;
            double e = (double)pos.getY();
            double f = (double)pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                world.playSound(d, e, f, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
            double j = random.nextDouble() * 6.0 / 16.0;
            double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;
            world.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
            world.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        }

    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (state.get(LIT) && entity instanceof LivingEntity) {
            entity.serverDamage(world.getDamageSources().campfire(), 1.0F);
        }

        super.onEntityCollision(state, world, pos, entity);
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return GenesisBlockEntity.STOVE_BLOCK_ENTITY.instantiate(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world instanceof ServerWorld serverWorld) {
            if ((Boolean)state.get(LIT)) {
                ServerRecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> matchGetter = ServerRecipeManager.createCachedMatchGetter(
                        RecipeType.CAMPFIRE_COOKING
                );
                return validateTicker(
                        type,
                        GenesisBlockEntity.STOVE_BLOCK_ENTITY,
                        (worldx, pos, statex, blockEntity) -> StoveBlockEntity.litServerTick(serverWorld, pos, statex, blockEntity, matchGetter)
                );
            } else {
                return validateTicker(type, GenesisBlockEntity.STOVE_BLOCK_ENTITY, StoveBlockEntity::unlitServerTick);
            }
        } else {
            return state.get(LIT) ? validateTicker(type, GenesisBlockEntity.STOVE_BLOCK_ENTITY, StoveBlockEntity::clientTick) : null;
        }
    }
}
