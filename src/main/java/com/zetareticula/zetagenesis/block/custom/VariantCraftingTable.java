package com.zetareticula.zetagenesis.block.custom;

import com.mojang.serialization.MapCodec;
import com.zetareticula.zetagenesis.screenhandler.VariantCraftingScreenHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VariantCraftingTable extends Block {
    public static final MapCodec<VariantCraftingTable> CODEC = createCodec(VariantCraftingTable::new);
    private static final Text TITLE = Text.translatable("container.crafting");

    @Override
    public MapCodec<? extends VariantCraftingTable> getCodec() {
        return CODEC;
    }

    public VariantCraftingTable(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
            return ActionResult.CONSUME;
        }
    }

    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new VariantCraftingScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE
        );
    }
}
