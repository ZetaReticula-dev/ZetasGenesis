package com.zetareticula.zetagenesis.food;

import com.zetareticula.zetagenesis.item.GenesisItems;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

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
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 28800, 1), 1.0F).alwaysEdible().usingConvertsTo(Items.GLASS_BOTTLE).build();

    public static final FoodComponent TRIPLE_GOOBER_BERRY_SUNRISE = new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3600, 0),
                    1.0F).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40, 0),
                    1.0F).build();

    public static final FoodComponent KRABBY_PATTY = new FoodComponent.Builder()
            .nutrition(7).saturationModifier(0.3F).build();

    public static final FoodComponent CINNAMON_ROLL = new FoodComponent.Builder()
            .nutrition(40).saturationModifier(20.0F).alwaysEdible().snack().build();

    //Soup
    public static final FoodComponent SATURATION_SOUP = new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 7, 0), 1.0F).build();

    //RAW CROPS
    public static final FoodComponent CABBAGE = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.4f).build();
    public static final FoodComponent TOMATO = (new FoodComponent.Builder())
            .nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent ONION = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.4f).build();

    //BASIC FOODS
    public static final FoodComponent FRIED_EGG = (new FoodComponent.Builder())
            .nutrition(4).saturationModifier(0.4f).build();
    public static final FoodComponent TOMATO_SAUCE = (new FoodComponent.Builder())
            .nutrition(4).saturationModifier(0.4f).build();
    public static final FoodComponent WHEAT_DOUGH = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build();
    public static final FoodComponent RAW_PASTA = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build();
    public static final FoodComponent PIE_CRUST = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.2f).build();
    public static final FoodComponent PUMPKIN_SLICE = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent CABBAGE_LEAF = (new FoodComponent.Builder())
            .nutrition(1).saturationModifier(0.4f).snack().build();
    public static final FoodComponent MINCED_BEEF = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.3f).snack().build();
    public static final FoodComponent BEEF_PATTY = (new FoodComponent.Builder())
            .nutrition(4).saturationModifier(0.8f).snack().build();
    public static final FoodComponent CHICKEN_CUTS = (new FoodComponent.Builder())
            .nutrition(1).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).snack().build();
    public static final FoodComponent COOKED_CHICKEN_CUTS = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.6f).snack().build();
    public static final FoodComponent BACON = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.3f).snack().build();
    public static final FoodComponent COOKED_BACON = (new FoodComponent.Builder())
            .nutrition(4).saturationModifier(0.8f).snack().build();
    public static final FoodComponent COD_SLICE = (new FoodComponent.Builder())
            .nutrition(1).saturationModifier(0.1f).snack().build();
    public static final FoodComponent COOKED_COD_SLICE = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.5f).snack().build();
    public static final FoodComponent SALMON_SLICE = (new FoodComponent.Builder())
            .nutrition(1).saturationModifier(0.1f).snack().build();
    public static final FoodComponent COOKED_SALMON_SLICE = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.8f).snack().build();
    public static final FoodComponent MUTTON_CHOPS = (new FoodComponent.Builder())
            .nutrition(1).saturationModifier(0.3f).snack().build();
    public static final FoodComponent COOKED_MUTTON_CHOPS = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.8f).snack().build();
    public static final FoodComponent HAM = (new FoodComponent.Builder())
            .nutrition(5).saturationModifier(0.3f).build();
    public static final FoodComponent SMOKED_HAM = (new FoodComponent.Builder())
            .nutrition(10).saturationModifier(0.8f).build();

    //Sweets

    public static final FoodComponent POPSICLE = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.2f).snack().alwaysEdible().build();
    public static final FoodComponent COOKIES = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.1f).snack().build();
    public static final FoodComponent CAKE_SLICE = (new FoodComponent.Builder())
            .nutrition(2).saturationModifier(0.1f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0, false, false), 1.0F).build();
    public static final FoodComponent PIE_SLICE = (new FoodComponent.Builder())
            .nutrition(3).saturationModifier(0.3f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 0, false, false), 1.0F).build();
    public static final FoodComponent FRUIT_SALAD = (new FoodComponent.Builder())
            .nutrition(6).saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F).build();
    public static final FoodComponent GLOW_BERRY_CUSTARD = (new FoodComponent.Builder())
            .nutrition(7).saturationModifier(0.6f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), 1.0F).build();
}
