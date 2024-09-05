package com.zetareticula.zetagenesis.food.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ReaperPepperItem extends Item {
    private static final double MAX_EXTRA_HEALTH = 10.0; // 5 hearts = 10 health points
    private static final double EXPLOSION_THRESHOLD = 20.0 + MAX_EXTRA_HEALTH; // The total health points (20 base + 10 extra)

    public ReaperPepperItem(Settings settings) {
        super(settings); // Define food properties
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient && user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;

            double currentMaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
            double newMaxHealth = currentMaxHealth + 2.0;

            if (currentMaxHealth < EXPLOSION_THRESHOLD - 2.0) { // Safe to add another heart
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(newMaxHealth);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.PLAYERS, 10.0F, 1.0F);
            } else if (currentMaxHealth == EXPLOSION_THRESHOLD - 2.0) { // Warning level
                player.sendMessage(Text.of("§4You've eaten a 5th Reaper Pepper, you feel death creeping up in your spine."), false);
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(newMaxHealth);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.PLAYERS, 10.0F, 1.0F);
            } else { // Exceeds limit, trigger explosion
                player.sendMessage(Text.of("§cYou overdid it!"), true);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 10.0F, 1.0F);
                world.createExplosion(player, player.getX(), player.getY(), player.getZ(), 4.0F, World.ExplosionSourceType.BLOCK);
                player.kill(); // Kills the player
            }
        }

        return super.finishUsing(stack, world, user);

    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT; // Makes the item have the eating animation
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand); // Standard use action for food
    }
}