package com.zetareticula.zetasgenesis.item;

import com.zetareticula.zetasgenesis.equipment.GenesisArmor;
import com.zetareticula.zetasgenesis.equipment.GenesisTools;
import com.zetareticula.zetasgenesis.ZetasGenesis;
import com.zetareticula.zetasgenesis.item.custom.AspectOfTheVoidItem;
import com.zetareticula.zetasgenesis.item.custom.PickAndAxe;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class GenesisItems {

    public static final Item NETHER_SHARD =register("nether_star_shard", Item::new, new Item.Settings().rarity(Rarity.RARE));

    public static final Item VOID_STAFF = register("void_staff", settings -> new
            AspectOfTheVoidItem(settings,60,14,-1000,1,3, 160),
            (new Item.Settings().maxDamage(128).maxCount(1).rarity(Rarity.RARE)));

    //ENDERIUM STUFF
    public static final Item ENDERIUM_HELMET = register("enderium_helmet",
            settings -> new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(GenesisArmor.ENDERIUM.durability())));

    public static final Item ENDERIUM_CHESTPLATE = register("enderium_chestplate",
            settings -> new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(GenesisArmor.ENDERIUM.durability())));

    public static final Item ENDERIUM_LEGGINGS = register("enderium_leggings",
            settings -> new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(GenesisArmor.ENDERIUM.durability())));

    public static final Item ENDERIUM_BOOTS = register("enderium_boots", settings ->
                    new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(GenesisArmor.ENDERIUM.durability())));

    public static final Item ENDERIUM_PICKAXE = register("enderium_pickaxe",
            settings -> new PickaxeItem(GenesisTools.ENDERIUM_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings());

    //BRASS STUFF
    public static final Item BRASS_INGOT = register("brass_ingot", Item::new, new Item.Settings());

    //PICK AND AXES
    public static final Item DIAMOND_PICK_AXE = register("diamond_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.DIAMOND, 5.0F, -3.0f, settings),
            new Item.Settings());



    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    public static void initializeItems() {

    }
}
