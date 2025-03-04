package usa.zetareticula.zetasgenesis.mixin;

import usa.zetareticula.zetasgenesis.ZetasGenesis;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo info) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        // Check if player is in Creative or Spectator mode (they should always be able to fly)
        if (player.interactionManager.getGameMode() == GameMode.CREATIVE ||
                player.interactionManager.getGameMode() == GameMode.SPECTATOR) {
            return;
        }

        // Check if the player has the ZetasGenesis.FLIGHT effect
        boolean hasFlightEffect = player.hasStatusEffect(ZetasGenesis.FLIGHT);

        if (hasFlightEffect) {
            // Player has the effect, do nothing (let them keep flying)
            return;
        } else {
            // Player does NOT have the effect, disable flying
            if (player.getAbilities().allowFlying) {
                player.getAbilities().allowFlying = false;
                player.getAbilities().flying = false; // Stop them from floating mid-air
                player.sendAbilitiesUpdate();
            }
        }
    }
}
