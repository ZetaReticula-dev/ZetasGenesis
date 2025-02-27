package com.zetareticula.zetasgenesis.equipment;

import com.zetareticula.zetasgenesis.ZetasGenesis;
import com.zetareticula.zetasgenesis.sounds.GenesisSounds;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class GenesisArmor {
    public static final RegistryKey<EquipmentAsset> ENDERIUM_ARMOR_MATERIAL_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(ZetasGenesis.MOD_ID, "enderium"));

    public static final ArmorMaterial ENDERIUM = new ArmorMaterial(
            45,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            25,
            GenesisSounds.ENDERIUM_EQUIP,
            4.0F,
            0.1F,
            ItemTags.REPAIRS_NETHERITE_ARMOR,
            ENDERIUM_ARMOR_MATERIAL_KEY
    );
}
