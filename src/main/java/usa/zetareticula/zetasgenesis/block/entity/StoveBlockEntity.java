package usa.zetareticula.zetasgenesis.block.entity;

import usa.zetareticula.zetasgenesis.block.GenesisBlockEntity;
import usa.zetareticula.zetasgenesis.block.custom.StoveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Clearable;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class StoveBlockEntity extends BlockEntity implements Clearable {
    private final DefaultedList<ItemStack> itemsBeingCooked = DefaultedList.ofSize(6, ItemStack.EMPTY);
    private final int[] cookingTime = new int[6];
    private final int[] cookingTotalTime = new int[6];

    public StoveBlockEntity(BlockPos pos, BlockState state) {
        super(GenesisBlockEntity.STOVE_BLOCK_ENTITY, pos, state);
    }

    public static void litServerTick(
            ServerWorld world,
            BlockPos pos,
            BlockState state,
            StoveBlockEntity stove,
            ServerRecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> recipeMatchGetter
    ) {
        boolean bl = false;

        for (int i = 0; i < stove.itemsBeingCooked.size(); i++) {
            ItemStack itemStack = stove.itemsBeingCooked.get(i);
            if (!itemStack.isEmpty()) {
                bl = true;
                stove.cookingTime[i]++;
                if (stove.cookingTime[i] >= stove.cookingTotalTime[i]) {
                    SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(itemStack);
                    ItemStack itemStack2 = (ItemStack)recipeMatchGetter.getFirstMatch(singleStackRecipeInput, world)
                            .map(recipe -> ((CampfireCookingRecipe)recipe.value()).craft(singleStackRecipeInput, world.getRegistryManager()))
                            .orElse(itemStack);
                    if (itemStack2.isItemEnabled(world.getEnabledFeatures())) {
                        ItemScatterer.spawn(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), itemStack2);
                        stove.itemsBeingCooked.set(i, ItemStack.EMPTY);
                        world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
                    }
                }
            }
        }

        if (bl) {
            markDirty(world, pos, state);
        }
    }

    public static void unlitServerTick(World world, BlockPos pos, BlockState state, StoveBlockEntity stove) {
        boolean bl = false;

        for (int i = 0; i < stove.getItemsBeingCooked().size(); i++) {
            if (stove.cookingTime[i] > 0) {
                bl = true;
                stove.cookingTime[i] = MathHelper.clamp(stove.cookingTime[i] - 2, 0, stove.cookingTotalTime[i]);
            }
        }

        if (bl) {
            markDirty(world, pos, state);
        }
    }

    public DefaultedList<ItemStack> getItemsBeingCooked() {
        return this.itemsBeingCooked;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.itemsBeingCooked.clear();
        Inventories.readNbt(nbt, this.itemsBeingCooked, registryLookup);
        if (nbt.contains("CookingTimes", NbtElement.INT_ARRAY_TYPE)) {
            int[] is = nbt.getIntArray("CookingTimes");
            System.arraycopy(is, 0, this.cookingTime, 0, Math.min(this.cookingTotalTime.length, is.length));
        }

        if (nbt.contains("CookingTotalTimes", NbtElement.INT_ARRAY_TYPE)) {
            int[] is = nbt.getIntArray("CookingTotalTimes");
            System.arraycopy(is, 0, this.cookingTotalTime, 0, Math.min(this.cookingTotalTime.length, is.length));
        }
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.itemsBeingCooked, true, registryLookup);
        nbt.putIntArray("CookingTimes", this.cookingTime);
        nbt.putIntArray("CookingTotalTimes", this.cookingTotalTime);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, this.itemsBeingCooked, true, registryLookup);
        return nbtCompound;
    }

    public boolean addItem(LivingEntity user, ItemStack stack, int cookTime) {
        if (hasBlockAbove()) {
            // Do not allow placing items if there is no block above
            return false;
        }

        for (int i = 0; i < this.itemsBeingCooked.size(); i++) {
            ItemStack itemStack = this.itemsBeingCooked.get(i);
            if (itemStack.isEmpty()) {
                this.cookingTotalTime[i] = cookTime;
                this.cookingTime[i] = 0;
                this.itemsBeingCooked.set(i, stack.splitUnlessCreative(1, user));
                this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(user, this.getCachedState()));
                this.updateListeners();
                return true;
            }
        }

        return false;
    }

    public boolean hasBlockAbove() {
        BlockPos blockAbove = this.pos.up();  // Get the position of the block directly above
        BlockState blockStateAbove = this.world.getBlockState(blockAbove);  // Get the state of the block at that position
        return !blockStateAbove.isAir();  // Return true if there is a block (not air) above
    }

    public static void clientTick(World world, BlockPos pos, BlockState state, StoveBlockEntity stoveBlockEntity) {
        Random random = world.random;

        int i = ((Direction)state.get(StoveBlock.FACING)).getHorizontalQuarterTurns();

        for (int j = 0; j < stoveBlockEntity.itemsBeingCooked.size(); j++) {
            if (!stoveBlockEntity.itemsBeingCooked.get(j).isEmpty() && random.nextFloat() < 0.2F) {
                Direction direction = Direction.fromHorizontalQuarterTurns(Math.floorMod(j + i, 4));
                float f = 0.3125F;
                double d = (double)pos.getX()
                        + 0.5
                        - (double)((float)direction.getOffsetX() * 0.3125F)
                        + (double)((float)direction.rotateYClockwise().getOffsetX() * 0.3125F);
                double e = (double)pos.getY() + 0.5;
                double g = (double)pos.getZ()
                        + 0.5
                        - (double)((float)direction.getOffsetZ() * 0.3125F)
                        + (double)((float)direction.rotateYClockwise().getOffsetZ() * 0.3125F);

                for (int k = 0; k < 4; k++) {
                    world.addParticle(ParticleTypes.SMOKE, d, e, g, 0.0, 5.0E-4, 0.0);
                }
            }
        }
    }

    private void updateListeners() {
        this.markDirty();
        this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
    }

    @Override
    public void clear() {
        this.itemsBeingCooked.clear();
    }

    public void spawnItemsBeingCooked() {
        if (this.world != null) {
            this.updateListeners();
        }
    }

    @Override
    protected void readComponents(BlockEntity.ComponentsAccess components) {
        super.readComponents(components);
        components.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).copyTo(this.getItemsBeingCooked());
    }

    @Override
    protected void addComponents(ComponentMap.Builder componentMapBuilder) {
        super.addComponents(componentMapBuilder);
        componentMapBuilder.add(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(this.getItemsBeingCooked()));
    }

    @Override
    public void removeFromCopiedStackNbt(NbtCompound nbt) {
        nbt.remove("Items");
    }
}
