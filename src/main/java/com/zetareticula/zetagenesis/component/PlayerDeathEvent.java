package com.zetareticula.zetagenesis.component;

import com.zetareticula.zetagenesis.ZetaGenesis;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PlayerDeathEvent {
    public static void onPlayerDeath(ServerPlayerEntity player, ServerWorld world) {
        // Handle the player death event
        System.out.println(player.getName().getString() + " has died!");

        // Example: Send a message to all players
        player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20.0);
    }
    public static void registerPlayerDeathEvent() {
        ZetaGenesis.LOGGER.info("Registering PlayerDeathEvent for " + ZetaGenesis.MOD_ID);
}}
