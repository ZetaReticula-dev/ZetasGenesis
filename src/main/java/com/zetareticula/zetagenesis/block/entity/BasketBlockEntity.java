package com.zetareticula.zetagenesis.block.entity;

import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.network.BlockPosPayload;
import com.zetareticula.zetagenesis.screenhandler.BasketBlockScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BasketBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPosPayload> {

    public static final Text TITLE = Text.translatable("container.zetasgenesis.basket_block");

    public BasketBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(GenesisBlockEntity.BASKET_BLOCK_ENTITY, pos, state);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity player) {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return TITLE;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BasketBlockScreenHandler(syncId, playerInventory, this);
    }
}
