package com.zetareticula.zetagenesis.item;

import  com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.equipment.GenesisArmor;
import com.zetareticula.zetagenesis.equipment.GenesisToolMaterials;
import com.zetareticula.zetagenesis.equipment.KnifeItem;
import com.zetareticula.zetagenesis.food.GenesisFood;
import com.zetareticula.zetagenesis.food.custom.CanItem;
import com.zetareticula.zetagenesis.food.custom.DrinkableItem;
import com.zetareticula.zetagenesis.food.custom.ReaperPepperItem;
import com.zetareticula.zetagenesis.item.custom.*;
import com.zetareticula.zetagenesis.sounds.GenesisJukeboxSongs;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GenesisItems {

    public static final Item GOD_POTION = registerItem("god_potion",
            new DrinkableItem(new Item.Settings().food(GenesisFood.GOD_POTION).maxCount(1)));

    public static final Item DITTO_ITEM = registerItem("ditto_item",
            new ShieldItem(new Item.Settings().maxCount(1)));

    public static final Item CINNAMON_ROLL = registerItem("cinnamon_roll",
            new Item(new Item.Settings().food(GenesisFood.CINNAMON_ROLL).maxCount(64).rarity(Rarity.UNCOMMON)));

    public static final Item URANIUM_FUEL_ROD = registerItem("uranium_fuel_rod",
            new MaceItem(new Item.Settings()));
        //HALO STUFF
    public static final Item M6D_MAGNUM = registerItem("m6d_magnum",
            new MagnumItem(new Item.Settings().maxCount(1).maxDamage(12)));

    public static final Item MA5B_ASSAULT_RIFLE = registerItem("ma5b_assault_rifle",
            new AssaultRifleItem(new Item.Settings().maxCount(1).maxDamage(60)));

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
            new AspectOfTheEndItem(new Item.Settings().maxDamage(32).maxCount(1), 8, 0, 1));

    public static final Item WARPED_AOTE = registerItem("warped_aspect_of_the_end",
            new AspectOfTheEndItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(64).maxCount(1),10, -20, 1));

    public static final Item AOTV = registerItem("aspect_of_the_void",
            new AspectOfTheVoidItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(64).maxCount(1),40, 12, 0, 1, 7, 240 ));

    public static final Item WARPED_AOTV = registerItem("warped_aspect_of_the_void",
            new AspectOfTheVoidItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(128).maxCount(1), 60, 14, -1000, 1, 3, 160 ));
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

    public static final Item ENDERIUM_SHOVEL = registerItem("enderium_shovel",
            new ShovelItem(GenesisToolMaterials.ENDERIUM, (new Item.Settings()).fireproof().attributeModifiers(ShovelItem.createAttributeModifiers
                    (GenesisToolMaterials.ENDERIUM, 1.5F, -3.0F))));

    public static final Item ENDERIUM_PICKAXE = registerItem("enderium_pickaxe",
            new PickaxeItem(GenesisToolMaterials.ENDERIUM, (new Item.Settings()).fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers
                    (GenesisToolMaterials.ENDERIUM, 1.0F, -2.8F))));

    public static final Item ENDERIUM_AXE = registerItem("enderium_axe",
            new AxeItem(GenesisToolMaterials.ENDERIUM, (new Item.Settings()).fireproof().attributeModifiers(AxeItem.createAttributeModifiers
                    (GenesisToolMaterials.ENDERIUM, 5, -3.0F))));

    public static final Item ENDERIUM_HOE = registerItem("enderium_hoe",
            new HoeItem(GenesisToolMaterials.ENDERIUM, (new Item.Settings()).fireproof().attributeModifiers(HoeItem.createAttributeModifiers
                    (GenesisToolMaterials.ENDERIUM, -4.0F, -0.0F))));

    public static final Item MULTI_TOOL = registerItem("multi_tool",
            new MulitoolItem(ToolMaterials.IRON, (new Item.Settings()).fireproof().attributeModifiers(MulitoolItem.createAttributeModifiers
                    (ToolMaterials.IRON, 1.0F, 0.0F))));



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

    public static final Item DOOM_DISC = registerItem("doom_disc",
            new Item(new Item.Settings().maxCount(1).jukeboxPlayable(GenesisJukeboxSongs.DOOM)) );

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

    // HARDENED LEATHER

    public static final Item HARDENED_LEATHER_HELMET = registerItem("hardened_leather_helmet",
            new ArmorItem(GenesisArmor.HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.HELMET.getMaxDamage(45))));

    public static final Item HARDENED_LEATHER_CHESTPLATE = registerItem("hardened_leather_chestplate",
            new ArmorItem(GenesisArmor.HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.CHESTPLATE.getMaxDamage(45))));

    public static final Item HARDENED_LEATHER_LEGGINGS = registerItem("hardened_leather_leggings",
            new ArmorItem(GenesisArmor.HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.LEGGINGS.getMaxDamage(45))));

    public static final Item HARDENED_LEATHER_BOOTS = registerItem("hardened_leather_greaves",
            new ArmorItem(GenesisArmor.HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof().maxDamage
                    (ArmorItem.Type.BOOTS.getMaxDamage(45))));

    //KNIVES

    public static final Item IRON_KNIFE = registerItem("iron_knife",
            new KnifeItem(GenesisToolMaterials.KNIFE_IRON, (new Item.Settings()).attributeModifiers(KnifeItem.createAttributeModifiers
                    (GenesisToolMaterials.KNIFE_IRON, 1, -2.0F))));

    public static final Item DIAMOND_KNIFE = registerItem("diamond_knife",
            new KnifeItem(GenesisToolMaterials.KNIFE_DIAMOND, (new Item.Settings()).attributeModifiers(KnifeItem.createAttributeModifiers
                    (GenesisToolMaterials.KNIFE_DIAMOND, 1, -2.0F))));

    public static final Item NETHERITE_KNIFE = registerItem("netherite_knife",
            new KnifeItem(GenesisToolMaterials.KNIFE_NETHERITE, (new Item.Settings()).attributeModifiers(KnifeItem.createAttributeModifiers
                    (GenesisToolMaterials.KNIFE_NETHERITE, 1, -2.0F))));

    public static final Item GOLDEN_KNIFE = registerItem("golden_knife",
            new KnifeItem(GenesisToolMaterials.KNIFE_GOLD, (new Item.Settings()).attributeModifiers(KnifeItem.createAttributeModifiers
                    (GenesisToolMaterials.KNIFE_GOLD, 1, -2.0F))));

    //Raw food crops
    public static final Item CABBAGE = registerItem("cabbage",
            new Item(new Item.Settings().food(GenesisFood.CABBAGE)));

    public static final Item TOMATO = registerItem("tomato",
            new Item(new Item.Settings().food(GenesisFood.TOMATO)));

    public static final Item ONION = registerItem("onion",
            new Item(new Item.Settings().food(GenesisFood.ONION)));

    //Basic foods

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new Item.Settings().food(GenesisFood.FRIED_EGG)));

    public static final Item TOMATO_SAUCE = registerItem("tomato_sauce",
            new Item(new Item.Settings().food(GenesisFood.TOMATO_SAUCE)));

    public static final Item WHEAT_DOUGH = registerItem("wheat_dough",
            new Item(new Item.Settings().food(GenesisFood.WHEAT_DOUGH)));

    public static final Item RAW_PASTA = registerItem("raw_pasta",
            new Item(new Item.Settings().food(GenesisFood.RAW_PASTA)));

    public static final Item PUMPKIN_SLICE = registerItem("pumpkin_slice",
            new Item(new Item.Settings().food(GenesisFood.PUMPKIN_SLICE)));

    public static final Item CABBAGE_LEAF = registerItem("cabbage_leaf",
            new Item(new Item.Settings().food(GenesisFood.CABBAGE_LEAF)));

    public static final Item MINCED_BEEF = registerItem("minced_beef",
            new Item(new Item.Settings().food(GenesisFood.MINCED_BEEF)));

    public static final Item BEEF_PATTY = registerItem("beff_patty",
            new Item(new Item.Settings().food(GenesisFood.BEEF_PATTY)));

    public static final Item CHICKEN_CUTS = registerItem("chicken_cuts",
            new Item(new Item.Settings().food(GenesisFood.CHICKEN_CUTS)));

    public static final Item COOKED_CHICKEN_CUTS = registerItem("ccoked_chicken_cuts",
            new Item(new Item.Settings().food(GenesisFood.COOKED_CHICKEN_CUTS)));

    public static final Item BACON = registerItem("bacon",
            new Item(new Item.Settings().food(GenesisFood.BACON)));

    public static final Item COOKED_BACON = registerItem("cooked_bacon",
            new Item(new Item.Settings().food(GenesisFood.COOKED_BACON)));

    public static final Item COD_SLICE = registerItem("cod_slice",
            new Item(new Item.Settings().food(GenesisFood.COD_SLICE)));

    public static final Item COOKED_COD_SLICE = registerItem("cooked_cod_slice",
            new Item(new Item.Settings().food(GenesisFood.COOKED_COD_SLICE)));

    public static final Item SALMON_SLICE = registerItem("salmon_slice",
            new Item(new Item.Settings().food(GenesisFood.SALMON_SLICE)));

    public static final Item COOKED_SALMON_SLICE = registerItem("cooked_salmon_slice",
            new Item(new Item.Settings().food(GenesisFood.COOKED_SALMON_SLICE)));

    public static final Item MUTTON_CHOPS = registerItem("mutton_chops",
            new Item(new Item.Settings().food(GenesisFood.MUTTON_CHOPS)));

    public static final Item COOKED_MUTTON_CHOPS = registerItem("cooked_mutton_chops",
            new Item(new Item.Settings().food(GenesisFood.COOKED_MUTTON_CHOPS)));

    public static final Item HAM = registerItem("ham",
            new Item(new Item.Settings().food(GenesisFood.HAM)));

    public static final Item SMOKED_HAM = registerItem("smoked_ham",
            new Item(new Item.Settings().food(GenesisFood.SMOKED_HAM)));



    //Sweets

    public static final Item PIE_CRUST = registerItem("pie_crust",
            new Item(new Item.Settings().food(GenesisFood.PIE_CRUST)));

    //Soup
    public static final Item OPEN_SATURATION_SOUP = registerItem("open_saturation_soup_can",
            new DrinkableItem(new Item.Settings().maxCount(4).food(GenesisFood.SATURATION_SOUP)));

    public static final Item SOUP_CAN = registerItem("soup_can",
            new Item(new Item.Settings().maxCount(16)));

    public static final Item SATURATION_SOUP_CAN = registerItem("saturation_soup_can",
            new CanItem(new Item.Settings().maxCount(16), OPEN_SATURATION_SOUP));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ZetaGenesis.MOD_ID, name), item);
    }

    public static void registerGenesisItems() {
        ZetaGenesis.LOGGER.info("Registering Genesis Items for " + ZetaGenesis.MOD_ID);
    }
}
