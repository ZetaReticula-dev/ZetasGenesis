package com.zetareticula.zetagenesis.item;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GenesisItems {

    public static final Item LEGENDARY_HERO = registerItem("legendary_hero",
            new Item(new Item.Settings().food(GenesisFood.LEGENDARY_HERO)));

    public static final Item REAPER_PEPPER = registerItem("reaper_pepper",
            new ReaperPepperItem(new Item.Settings().food(GenesisFood.REAPER_PEPPER)));

    public static final Item AOTV = registerItem("aspect_of_the_void",
            new Item(new Item.Settings().maxCount(1)));

    public static final Item AOTV1 = registerItem("shovel_aspect_of_the_void",
            new ShovelItem(ToolMaterials.NETHERITE, (new Item.Settings()).fireproof().attributeModifiers(ShovelItem.createAttributeModifiers
                    (ToolMaterials.NETHERITE, 1.5F, -3.0F))));

    public static final Item AOTV2 = registerItem("sword_aspect_of_the_void",
            new SwordItem(ToolMaterials.NETHERITE, (new Item.Settings()).fireproof().attributeModifiers(SwordItem.createAttributeModifiers
                    (ToolMaterials.NETHERITE, 3, -2.4F))));

    public static final Item DIVAN_HELMET = registerItem("divan_helmet",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));

    public static final Item DIVAN_CHESTPLATE = registerItem("divan_chestplate",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));

    public static final Item DIVAN_LEGGINGS = registerItem("divan_leggings",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));

    public static final Item DIVAN_BOOTS = registerItem("divan_boots",
            new ArmorItem(GenesisArmor.DIVAN, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet",
            new ArmorItem(GenesisArmor.ENDERITE, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",
            new ArmorItem(GenesisArmor.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings",
            new ArmorItem(GenesisArmor.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots",
            new ArmorItem(GenesisArmor.ENDERITE, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item ANGEL_RING = registerItem("angel_ring",
            new AngelRing(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ZetaGenesis.MOD_ID, name), item);
    }

    public static void registerGenesisItems() {
        ZetaGenesis.LOGGER.info("Registering Genesis Items for " + ZetaGenesis.MOD_ID);
    }
}
