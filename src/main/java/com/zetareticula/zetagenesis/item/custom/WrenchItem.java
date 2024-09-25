package com.zetareticula.zetagenesis.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DebugStickStateComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DebugStickItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Formatting;

public class WrenchItem extends Item {

    private Property<?> selectedProperty = null;

    public WrenchItem(Settings settings) {
        super(settings);
    }

    // Handle right-click on block to change block states
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState blockState = world.getBlockState(pos);

        if (!world.isClient) {
            var properties = blockState.getProperties().stream().toList();

            if (properties.isEmpty()) {
                player.sendMessage(Text.literal("No properties to modify!").formatted(Formatting.RED), true);
                return ActionResult.FAIL;
            }

            if (selectedProperty == null) {
                // Select the first property (default behavior)
                selectedProperty = properties.get(0);
            }

            // If sneaking, reverse the property change
            boolean reverse = player.isSneaking();

            // Cycle the block state for the selected property
            world.setBlockState(pos, cycleBlockState(blockState, selectedProperty, reverse));

            // Notify the player about the change
            player.sendMessage(Text.literal("Changed property: " + selectedProperty.getName()).formatted(Formatting.GREEN), true);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    // Cycle through the possible values of the current property
    private <T extends Comparable<T>> BlockState cycleBlockState(BlockState state, Property<T> property, boolean reverse) {
        T currentValue = state.get(property);
        T newValue = reverse ? getPreviousValue(property.getValues(), currentValue) : getNextValue(property.getValues(), currentValue);
        return state.with(property, newValue);
    }

    // Get the next value in the property
    private <T extends Comparable<T>> T getNextValue(Iterable<T> values, T currentValue) {
        boolean foundCurrent = false;
        T firstValue = null;

        for (T value : values) {
            if (firstValue == null) {
                firstValue = value;
            }
            if (foundCurrent) {
                return value;
            }
            if (value.equals(currentValue)) {
                foundCurrent = true;
            }
        }

        return firstValue; // Wrap around to the first value
    }

    // Get the previous value in the property
    private <T extends Comparable<T>> T getPreviousValue(Iterable<T> values, T currentValue) {
        T previousValue = null;

        for (T value : values) {
            if (value.equals(currentValue)) {
                return previousValue != null ? previousValue : getLastValue(values);
            }
            previousValue = value;
        }

        return previousValue;
    }

    // Get the last value in the property
    private <T extends Comparable<T>> T getLastValue(Iterable<T> values) {
        T lastValue = null;
        for (T value : values) {
            lastValue = value;
        }
        return lastValue;
    }
}
