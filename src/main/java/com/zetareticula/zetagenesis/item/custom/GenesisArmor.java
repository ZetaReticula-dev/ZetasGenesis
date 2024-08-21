package com.zetareticula.zetagenesis.item.custom;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.item.GenesisItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class GenesisArmor {
    public static final RegistryEntry<ArmorMaterial> DIVAN = registerMaterial("divan",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            25,
            // The sound played when the armor is equipped.
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.ofItems(GenesisItems.REAPER_PEPPER),
            3.0F,
            0.1F,
            // Guidite is NOT dyeable, so we will pass false.
            false);

    public static final RegistryEntry<ArmorMaterial> ENDERITE = registerMaterial("enderite",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 4,
                    ArmorItem.Type.CHESTPLATE, 9,
                    ArmorItem.Type.LEGGINGS, 7,
                    ArmorItem.Type.BOOTS, 4
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            25,
            // The sound played when the armor is equipped.
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.ofItems(GenesisItems.REAPER_PEPPER),
            4.0F,
            0.1F,
            // Guidite is NOT dyeable, so we will pass false.
            false);

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(

                new ArmorMaterial.Layer(Identifier.of(ZetaGenesis.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(ZetaGenesis.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);
    }
    public static void registerGenesisArmor() {
        ZetaGenesis.LOGGER.info("Registering Genesis Armor for " + ZetaGenesis.MOD_ID);
    }
}