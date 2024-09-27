package com.zetareticula.zetagenesis.screenhandler;

import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.block.entity.CabinetBlockEntity;
import com.zetareticula.zetagenesis.network.BlockPosPayload;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class CabinetBlockScreenHandler extends ScreenHandler {
    private final CabinetBlockEntity blockEntity;
    private final ScreenHandlerContext context;

    // Client Constructor
    public CabinetBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (CabinetBlockEntity) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
    }

    // Main Constructor - (Directly called from server)
    public CabinetBlockScreenHandler(int syncId, PlayerInventory playerInventory, CabinetBlockEntity blockEntity) {
        super(GenesisScreenHandlerType.CABINET_BLOCK_SCREEN, syncId);

        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());

        SimpleInventory inventory = this.blockEntity.getInventory();
        checkSize(inventory, 27);
        inventory.onOpen(playerInventory.player);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addBlockInventory(inventory);
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + (column + (row * 9)), 8 + (column * 18), 86 + (row * 18)));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, 8 + (column * 18), 144));
        }
    }

    private void addBlockInventory(SimpleInventory inventory) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(inventory, column + (row * 9), 8 + (column * 18), 18 + (row * 18)));
            }
        }
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.blockEntity.getInventory().onClose(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = getSlot(slotIndex);
        if(slot != null && slot.hasStack()) {
            ItemStack inSlot = slot.getStack();
            newStack = inSlot.copy();

            if(slotIndex < 36) {
                if(!insertItem(inSlot, 36, this.slots.size(), false))
                    return ItemStack.EMPTY;
            } else if (!insertItem(inSlot, 0, 36, true))
                return ItemStack.EMPTY;

            if(inSlot.isEmpty())
                slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, GenesisBlocks.OAK_CABINET) || canUse(this.context, player, GenesisBlocks.SPRUCE_CABINET)
                || canUse(this.context, player, GenesisBlocks.BIRCH_CABINET) || canUse(this.context, player, GenesisBlocks.JUNGLE_CABINET)
                || canUse(this.context, player, GenesisBlocks.ACACIA_CABINET) || canUse(this.context, player, GenesisBlocks.DARK_OAK_CABINET)
                || canUse(this.context, player, GenesisBlocks.MANGROVE_CABINET) || canUse(this.context, player, GenesisBlocks.CHERRY_CABINET)
                || canUse(this.context, player, GenesisBlocks.BAMBOO_CABINET) || canUse(this.context, player, GenesisBlocks.CRIMSON_CABINET)
                || canUse(this.context, player, GenesisBlocks.WARPED_CABINET);
    }
}
