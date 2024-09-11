package com.zetareticula.zetagenesis.item.custom;

import com.zetareticula.zetagenesis.sounds.GenesisSounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MagnumItem extends Item {
    private static final int COOLDOWN_TICKS = 5;
    public MagnumItem(Settings settings) {super(settings);}

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        {
            if (world.isClient) {   return TypedActionResult.pass(user.getStackInHand(hand)); } {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), GenesisSounds.MAGNUM_FIRE, SoundCategory.BLOCKS, 10.0F, 1.0F);
            user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            user.getStackInHand(hand).damage(1,user, EquipmentSlot.MAINHAND);
        }

        return super.use(world, user, hand);
    }
}
}
