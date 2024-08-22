package com.zetareticula.zetagenesis.item.custom;

import com.zetareticula.zetagenesis.utils.TuningFork;
import net.minecraft.block.VaultBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TuningForkItem extends Item {
    public TuningForkItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient)
            return ActionResult.PASS;
        PlayerEntity player = context.getPlayer();
        BlockEntity vault = context.getWorld().getBlockEntity(context.getBlockPos());
        if (vault == null || !vault.getType().equals(BlockEntityType.VAULT) || player == null
                || player.isSneaking())
            return ActionResult.PASS;
        if (!TuningFork.vaultContainsPlayer(vault, player))
            return ActionResult.PASS;
        if (!TuningFork.removePlayerFromVault(vault, player))
            return ActionResult.PASS;
        boolean isOminous = vault.getCachedState().get(VaultBlock.OMINOUS);
        context.getStack().damage(isOminous ? 3 : 1, player, LivingEntity.getSlotForHand(context.getHand()));
        player.playSoundToPlayer(SoundEvents.ITEM_MACE_SMASH_GROUND, SoundCategory.BLOCKS, 1.f, 1.f);
        TuningFork.summonParticlesRandSpeed(ParticleTypes.CLOUD, vault.getPos().toCenterPos(), -0.5d, 0.5d, 20);
        return ActionResult.SUCCESS;
}}
