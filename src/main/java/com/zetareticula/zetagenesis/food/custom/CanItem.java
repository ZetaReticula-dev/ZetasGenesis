package com.zetareticula.zetagenesis.food.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CanItem extends Item {

    private Item openedCanItem; // The item returned after use

    public CanItem(Settings settings, Item openedCanItem) {
        super(settings);
        this.openedCanItem = openedCanItem;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack canStack = player.getStackInHand(hand);

        if (!world.isClient) {
            ItemStack openedCan = new ItemStack(openedCanItem);

            if (canStack.getCount() == 1) {
                // If player is holding only 1 can, replace it with openedCan in the same slot
                player.setStackInHand(hand, openedCan);
            } else {
                // If holding more than 1 can, give openedCan to inventory
                player.giveItemStack(openedCan);

                // Decrease the can stack by one unless in creative mode
                if (!player.getAbilities().creativeMode) {
                    canStack.decrement(1);
                }
            }

            return TypedActionResult.success(canStack, world.isClient());
        }

        return TypedActionResult.pass(canStack);
    }

    // Optionally, a setter to modify openedCanItem
    public void setOpenedCanItem(Item openedCanItem) {
        this.openedCanItem = openedCanItem;
    }
}
