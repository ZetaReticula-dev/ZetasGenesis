package com.zetareticula.zetagenesis.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class GenesisFood {
    public static final FoodComponent LEGENDARY_HERO = new FoodComponent.Builder()
            .nutrition(10).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10, 9 ),
                    1.0F).alwaysEdible().build();

    public static final FoodComponent REAPER_PEPPER = new FoodComponent.Builder()
            .nutrition(4).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0F).alwaysEdible().build();
}
