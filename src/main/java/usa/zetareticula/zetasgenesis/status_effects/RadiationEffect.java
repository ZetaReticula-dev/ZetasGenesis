package usa.zetareticula.zetasgenesis.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class RadiationEffect extends StatusEffect {

    public RadiationEffect() {
        super(StatusEffectCategory.HARMFUL, 0xABFF00);
    }

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 0.0F) {
            entity.damage(world, entity.getDamageSources().magic(), 2.0F);
        }

        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}