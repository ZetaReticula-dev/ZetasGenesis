package com.zetareticula.zetagenesis.item;

import  com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.equipment.GenesisArmor;
import com.zetareticula.zetagenesis.equipment.GenesisToolMaterials;
import com.zetareticula.zetagenesis.food.GenesisFood;
import com.zetareticula.zetagenesis.food.custom.GodPotion;
import com.zetareticula.zetagenesis.food.custom.ReaperPepperItem;
import com.zetareticula.zetagenesis.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GenesisItems {

    public static final Item GOD_POTION = registerItem("god_potion",
            new GodPotion(new Item.Settings().food(GenesisFood.GOD_POTION).maxCount(1)));

    public static final Item CINNAMON_ROLL = registerItem("cinnamon_roll",
            new Item(new Item.Settings().food(GenesisFood.CINNAMON_ROLL).maxCount(64).rarity(Rarity.UNCOMMON)));

    public static final Item URANIUM_FUEL_ROD = registerItem("uranium_fuel_rod",
            new MaceItem(new Item.Settings()));

    public static final Item TUNING_FORK = registerItem("tuning_fork",
            new TuningForkItem(new Item.Settings().maxDamage(16).maxCount(1)));

    public static final Item LEGENDARY_HERO = registerItem("legendary_hero",
            new Item(new Item.Settings().food(GenesisFood.LEGENDARY_HERO)));

    public static final Item REAPER_PEPPER = registerItem("reaper_pepper",
            new ReaperPepperItem(new Item.Settings().food(GenesisFood.REAPER_PEPPER)));
        //ASPECT OF THE END STUFF
        public static final Item NULL_SPHERE = registerItem("null_sphere",
                new Item(new Item.Settings()));

    public static final Item NULL_OVOID = registerItem("null_ovoid",
            new Item(new Item.Settings()));

    public static final Item INSTANT_TRANSMISSION_CONDUIT = registerItem("instant_transmission_conduit",
            new Item(new Item.Settings()));

    public static final Item INSTANT_TRANSMISSION_MERGER = registerItem("instant_transmission_merger",
            new Item(new Item.Settings()));

    public static final Item TRANSMISSION_TUNER = registerItem("transmission_tuner",
            new Item(new Item.Settings()));

    public static final Item WARPED_STONE = registerItem("warped_stone",
            new Item(new Item.Settings()));

    public static final Item AOTE = registerItem("aspect_of_the_end",
            new AspectOfTheEndItem(new Item.Settings().maxDamage(64).maxCount(1)));

    public static final Item WARPED_AOTE = registerItem("warped_aspect_of_the_end",
            new WarpedAspectOfTheEndItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(128).maxCount(1)));

    public static final Item AOTV = registerItem("aspect_of_the_void",
            new AspectOfTheVoidItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(128).maxCount(1)));

    public static final Item WARPED_AOTV = registerItem("warped_aspect_of_the_void",
            new WarpedAspectOfTheVoidItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(256).maxCount(1)));
        //DIVAN STUFF
    public static final Item DIVAN_HELMET = registerItem("divan_helmet",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item DIVAN_CHESTPLATE = registerItem("divan_chestplate",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item DIVAN_LEGGINGS = registerItem("divan_leggings",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item DIVAN_BOOTS = registerItem("divan_boots",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(45))));
        //ENDERIUM STUFF
    public static final Item ENDERIUM_HELMET = registerItem("enderium_helmet",
            new ArmorItem(GenesisArmor.ENDERIUM, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item ENDERIUM_CHESTPLATE = registerItem("enderium_chestplate",
            new ArmorItem(GenesisArmor.ENDERIUM, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.CHESTPLATE.getMaxDamage(45))));

    public static final Item ENDERIUM_LEGGINGS = registerItem("enderium_leggings",
            new ArmorItem(GenesisArmor.ENDERIUM, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.LEGGINGS.getMaxDamage(45))));

    public static final Item ENDERIUM_BOOTS = registerItem("enderium_boots",
            new ArmorItem(GenesisArmor.ENDERIUM, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.BOOTS.getMaxDamage(45))));

    public static final Item ENDERIUM_SWORD = registerItem("enderium_sword",
            new SwordItem(GenesisToolMaterials.ENDERIUM, (new Item.Settings()).fireproof().attributeModifiers(SwordItem.createAttributeModifiers
                    (GenesisToolMaterials.ENDERIUM, 3, -2.4F))));

    public static final Item ENDERIUM_INGOT = registerItem("enderium_ingot",
            new Item(new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item ENDERIUM_UPGRADE = registerItem("enderium_upgrade_smithing_template",
            new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

        //ENERGY
        public static final Item ENERGY_HELMET = registerItem("energy_helmet",
                new ArmorItem(GenesisArmor.ENERGY, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                        (ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item ENERGY_CHESTPLATE = registerItem("energy_chestplate",
            new ArmorItem(GenesisArmor.ENERGY, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.CHESTPLATE.getMaxDamage(45))));

    public static final Item ENERGY_LEGGINGS = registerItem("energy_leggings",
            new ArmorItem(GenesisArmor.ENERGY, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.LEGGINGS.getMaxDamage(45))));

    public static final Item ENERGY_GREAVES = registerItem("energy_greaves",
            new ArmorItem(GenesisArmor.ENERGY, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.BOOTS.getMaxDamage(45))));

        //MISCELLANEOUS
    public static final Item ANGEL_RING = registerItem("angel_ring",
            new AngelRing(new Item.Settings().maxCount(1)));

    public static final Item ICE_CREAM_SUNRISE = registerItem("triple_gooberberry_sunrise",
            new Item(new Item.Settings().food(GenesisFood.TRIPLE_GOOBER_BERRY_SUNRISE)));

    public static final Item KRABBY_PATTY = registerItem("krabby_patty",
            new Item(new Item.Settings().food(GenesisFood.KRABBY_PATTY)));

    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(GenesisToolMaterials.IRON_HAMMER, new Item.Settings()));

    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(GenesisToolMaterials.DIAMOND_HAMMER, new Item.Settings()));

    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(GenesisToolMaterials.NETHERITE_HAMMER, new Item.Settings()));
    // GLITCH STUFF
    public static final Item GLITCH_HELMET = registerItem("glitch_infused_helmet",
            new ArmorItem(GenesisArmor.GLITCH, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(37))));

    public static final Item GLITCH_CHESTPLATE = registerItem("glitch_infused_chestplate",
            new ArmorItem(GenesisArmor.GLITCH, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));

    public static final Item GLITCH_LEGGINGS = registerItem("glitch_infused_leggings",
            new ArmorItem(GenesisArmor.GLITCH, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.LEGGINGS.getMaxDamage(37))));

    public static final Item GLITCH_BOOTS = registerItem("glitch_infused_greaves",
            new ArmorItem(GenesisArmor.GLITCH, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.BOOTS.getMaxDamage(37))));
    // WRENCH
    public static final Item WRENCH = registerItem("wrench",
            new WrenchItem(new Item.Settings().rarity(Rarity.EPIC).fireproof()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ZetaGenesis.MOD_ID, name), item);
    }

    public static void registerGenesisItems() {
        ZetaGenesis.LOGGER.info("Registering Genesis Items for " + ZetaGenesis.MOD_ID);
    }
}
