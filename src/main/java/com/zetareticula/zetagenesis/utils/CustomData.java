package com.zetareticula.zetagenesis.utils;

import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;  // Import for UUID

public class CustomData {

    // Store player coordinates by their UUID
    public static final Map<UUID, Vec3d> playerCoordinates = new HashMap<>();

    // Method to set player coordinates
    public static void setPlayerCoordinates(UUID playerUUID, Vec3d coords) {
        playerCoordinates.put(playerUUID, coords);
    }

    // Method to get player coordinates
    public static Vec3d getPlayerCoordinates(UUID playerUUID) {
        return playerCoordinates.get(playerUUID);
    }
}
