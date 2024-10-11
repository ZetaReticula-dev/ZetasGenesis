package com.zetareticula.zetagenesis.item.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.zetareticula.zetagenesis.utils.CustomData;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.UUID; // Import for UUID

public class PortalGunItem extends Item {

    public PortalGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient) {
            // Prompt player to use the teleport command
            player.sendMessage(Text.literal("Right-click again to teleport, or use /setcoords to input coordinates."), false);
        } else {
            // Get the player's UUID
            UUID playerUUID = player.getUuid();  // Correct usage of UUID
            // Retrieve stored coordinates
            Vec3d coords = CustomData.getPlayerCoordinates(playerUUID);  // Pass UUID to get coordinates

            if (coords != null) {
                // Teleport to the stored coordinates
                ServerWorld serverWorld = (ServerWorld) world;
                ((ServerPlayerEntity) player).teleport(serverWorld, coords.x, coords.y, coords.z, player.getYaw(), player.getPitch());
                player.sendMessage(Text.literal("Teleported to: " + coords), false);
            } else {
                player.sendMessage(Text.literal("No coordinates set! Use /setcoords first."), false);
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }

    // Register a custom command to set coordinates
    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("setcoords")
                .then(CommandManager.argument("x", DoubleArgumentType.doubleArg())
                        .then(CommandManager.argument("y", DoubleArgumentType.doubleArg())
                                .then(CommandManager.argument("z", DoubleArgumentType.doubleArg())
                                        .executes(context -> {
                                            ServerPlayerEntity player = context.getSource().getPlayer();
                                            double x = DoubleArgumentType.getDouble(context, "x");
                                            double y = DoubleArgumentType.getDouble(context, "y");
                                            double z = DoubleArgumentType.getDouble(context, "z");

                                            // Store the coordinates for the player using CustomData
                                            CustomData.setPlayerCoordinates(player.getUuid(), new Vec3d(x, y, z));
                                            player.sendMessage(Text.literal("Coordinates set to: " + x + ", " + y + ", " + z), false);
                                            return 1;
                                        })))));
    }
}
