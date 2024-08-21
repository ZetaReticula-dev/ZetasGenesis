package com.zetareticula.zetagenesis.mixin;

import com.zetareticula.zetagenesis.component.PlayerDeathEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerDeathMixin {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(CallbackInfo info) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        ServerWorld world = player.getServerWorld(); // Retrieve the world from the player instance
        PlayerDeathEvent.onPlayerDeath(player, world); // Call the method in your event handler class
    }
}