package com.zetareticula.zetagenesis.item;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GenesisItems {

    public static final Item LEGENDARY_HERO = registerItem("legendary_hero",
            new Item(new Item.Settings().food(GenesisFood.LEGENDARY_HERO)));

    public static final Item REAPER_PEPPER = registerItem("reaper_pepper",
            new HeartAddingItem(new Item.Settings().food(GenesisFood.REAPER_PEPPER)));

    public static final Item AOTV = registerItem("aspect_of_the_void",
            new Item(new Item.Settings().maxCount(1)));

    public static final Item AOTV1 = registerItem("shovel_aspect_of_the_void",
            new ShovelItem(ToolMaterials.NETHERITE, (new Item.Settings()).fireproof().attributeModifiers(ShovelItem.createAttributeModifiers
                    (ToolMaterials.NETHERITE, 1.5F, -3.0F))));

    public static final Item AOTV2 = registerItem("sword_aspect_of_the_void",
            new SwordItem(ToolMaterials.NETHERITE, (new Item.Settings()).fireproof().attributeModifiers(SwordItem.createAttributeModifiers
                    (ToolMaterials.NETHERITE, 3, -2.4F))));

    public static final Item WITHER_CHESTPLATE = registerItem("wither_chestplate",
            new ArmorItem(GenesisArmor.WITHER, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));

    public static final Item ANGEL_RING = registerItem("angel_ring",
            new AngelRing(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ZetaGenesis.MOD_ID, name), item);
    }

    public static void registerGenesisItems() {
        ZetaGenesis.LOGGER.info("Registering Genesis Items for " + ZetaGenesis.MOD_ID);
    }
}
