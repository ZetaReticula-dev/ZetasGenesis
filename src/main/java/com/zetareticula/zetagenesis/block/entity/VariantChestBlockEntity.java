package com.zetareticula.zetagenesis.block.entity;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.network.BlockPosPayload;
import com.zetareticula.zetagenesis.screenhandler.VariantChestBlockScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class VariantChestBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPosPayload> {
    public static final Text TITLE = Text.translatable("container." + ZetaGenesis.MOD_ID + ".example_inventory");

    private final SimpleInventory inventory = new SimpleInventory(36) {
        @Override
        public void markDirty() {
            super.markDirty();
            update();
        }

        @Override
        public void onOpen(PlayerEntity player) {
            super.onOpen(player);
            VariantChestBlockEntity.this.numPlayersOpen++;
            update();
        }

        @Override
        public void onClose(PlayerEntity player) {
            super.onClose(player);
            VariantChestBlockEntity.this.numPlayersOpen--;
            update();
        }
    };

    private final InventoryStorage inventoryStorage = InventoryStorage.of(inventory, null);

    private int numPlayersOpen;
    public float lidAngle;

    public VariantChestBlockEntity(BlockPos pos, BlockState state) {
        super(GenesisBlockEntity.VARIANT_CHEST_BLOCK_ENTITY, pos, state);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity player) {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return TITLE;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new VariantChestBlockScreenHandler(syncId, playerInventory, this);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory.getHeldStacks(), registryLookup);

        if(nbt.contains("NumPlayersOpen", NbtElement.INT_TYPE)) {
            this.numPlayersOpen = nbt.getInt("NumPlayersOpen");
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        var nbt = super.toInitialChunkDataNbt(registryLookup);
        writeNbt(nbt, registryLookup);
        nbt.putInt("NumPlayersOpen", this.numPlayersOpen);
        return nbt;
    }

    private void update() {
        markDirty();
        if(world != null)
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }

    public InventoryStorage getInventoryProvider(Direction direction) {
        return inventoryStorage;
    }

    public SimpleInventory getInventory() {
        return this.inventory;
    }

    public int getNumPlayersOpen() {
        return this.numPlayersOpen;
    }
}
