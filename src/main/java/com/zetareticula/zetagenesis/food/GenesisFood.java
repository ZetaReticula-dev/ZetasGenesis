package com.zetareticula.zetagenesis.food;

import com.zetareticula.zetagenesis.item.GenesisItems;
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

    public static final FoodComponent GOD_POTION = new FoodComponent.Builder()
            .nutrition(0).saturationModifier(0.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 28800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 28800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 28800, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 28800, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 28800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 28800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 28800, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 28800, 6), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 28800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 28800, 1), 1.0F).build();

    public static final FoodComponent TRIPLE_GOOBER_BERRY_SUNRISE = new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3600, 0),
                    1.0F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40, 0),
                    1.0F).build();

    public static final FoodComponent KRABBY_PATTY = new FoodComponent.Builder()
            .nutrition(7).saturationModifier(0.3F).build();

    public static final FoodComponent CINNAMON_ROLL = new FoodComponent.Builder()
            .nutrition(40).saturationModifier(20.0F).alwaysEdible().snack().build();

}
