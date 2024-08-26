package com.zetareticula.zetagenesis.item.custom;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class AngelRing extends Item {
    public AngelRing(Settings settings) {
        super(settings);
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.getAbilities().flying) {
                    player.addExhaustion(0.05F);
                }
            }
        });
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {   return TypedActionResult.pass(user.getStackInHand(hand)); } {
            user.getStackInHand(hand).damage(1, user, EquipmentSlot.MAINHAND);
            if
            (user.getAbilities().allowFlying) {
                user.getAbilities().allowFlying = false;
                user.getAbilities().flying = false;
                user.sendMessage(Text.translatable("message.zetasgenesis.angelring.disable"), false);


            } else {
                user.getAbilities().flying = true;
                user.getAbilities().allowFlying = true;
                user.sendMessage(Text.translatable("message.zetasgenesis.angelring.enable"), false);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BREEZE_DEATH, SoundCategory.BLOCKS, 10.0F, 1.0F);

            }

            user.sendAbilitiesUpdate();
        }
        return TypedActionResult.success(user.getStackInHand(hand)); }
}