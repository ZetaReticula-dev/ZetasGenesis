package com.zetareticula.zetagenesis.screenhandler;

import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.block.entity.BasketBlockEntity;
import com.zetareticula.zetagenesis.network.BlockPosPayload;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class BasketBlockScreenHandler extends ScreenHandler {
    private final BasketBlockEntity blockEntity;
    private final ScreenHandlerContext context;

    //CLIENT CONSTRUCTOR
    public BasketBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (BasketBlockEntity) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
    }

    //MAIN CONSTRUCTOR - (Directly called from server)
    public BasketBlockScreenHandler(int syncId, PlayerInventory playerInventory, BasketBlockEntity blockEntity) {
        super(GenesisScreenHandlerType.BASKET_BLOCK_SCREEN, syncId);

        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for (int row = 0; row < 3; row ++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + (column + (row * 9)), 8 + (column * 18), 84 + (row * 18)));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, 8 + (column * 18), 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, GenesisBlocks.BASKET);
    }

    public BasketBlockEntity getBlockEntity() {
       return this.blockEntity;
    }
}
