package com.zetareticula.zetasgenesis.item;

import com.zetareticula.zetasgenesis.equipment.GenesisArmor;
import com.zetareticula.zetasgenesis.equipment.GenesisTools;
import com.zetareticula.zetasgenesis.item.custom.AspectOfTheVoidItem;
import com.zetareticula.zetasgenesis.ZetasGenesis;
import com.zetareticula.zetasgenesis.sounds.GenesisSounds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DamageResistantComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class GenesisItems {

    public static final Item VOID_STAFF = register("void_staff", AspectOfTheVoidItem::new, new Item.Settings());

    //ENDERIUM EQUIPMENT AND TOOLS

    public static final RegistryKey<Item> ENDERIUM_HELMET_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "enderium_helmet"));
    public static final Item ENDERIUM_HELMET = register(new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.HELMET, new Item.Settings()
            .registryKey(ENDERIUM_HELMET_KEY).fireproof()
            .maxDamage(EquipmentType.HELMET.getMaxDamage(GenesisArmor.ENDERIUM.durability()))), ENDERIUM_HELMET_KEY);

    public static final RegistryKey<Item> ENDERIUM_CHESTPLATE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "enderium_chestplate"));
    public static final Item ENDERIUM_CHESTPLATE = register(new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.CHESTPLATE, new Item.Settings()
            .registryKey(ENDERIUM_CHESTPLATE_KEY).fireproof()
            .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(GenesisArmor.ENDERIUM.durability()))), ENDERIUM_CHESTPLATE_KEY);

    public static final RegistryKey<Item> ENDERIUM_LEGGINGS_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "enderium_leggings"));
    public static final Item ENDERIUM_LEGGINGS = register(new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.LEGGINGS, new Item.Settings()
            .registryKey(ENDERIUM_LEGGINGS_KEY).fireproof()
            .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(GenesisArmor.ENDERIUM.durability()))), ENDERIUM_LEGGINGS_KEY);

    public static final RegistryKey<Item> ENDERIUM_BOOTS_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "enderium_boots"));
    public static final Item ENDERIUM_BOOTS = register(new ArmorItem(GenesisArmor.ENDERIUM, EquipmentType.BOOTS, new Item.Settings()
            .registryKey(ENDERIUM_BOOTS_KEY).component(DataComponentTypes.DAMAGE_RESISTANT,new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION))
            .maxDamage(EquipmentType.BOOTS.getMaxDamage(GenesisArmor.ENDERIUM.durability()))), ENDERIUM_BOOTS_KEY);



    public static final RegistryKey<Item> ROCKET_69_DISC_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "music_disc_rocket_69"));
    public static final Item ROCKET_69_DISC = register(
            new Item(new Item.Settings().jukeboxPlayable(GenesisSounds.ROCKET_69_KEY).rarity(Rarity.UNCOMMON).maxCount(1).registryKey(ROCKET_69_DISC_KEY)),
            ROCKET_69_DISC_KEY);

    //MISC
    public static final RegistryKey<Item> NETHER_SHARD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "nether_star_shard"));
    public static final Item NETHER_SHARD = register(
            new Item(new Item.Settings().rarity(Rarity.RARE).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION)).registryKey(NETHER_SHARD_KEY)),
            NETHER_SHARD_KEY);


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;



    public static final RegistryKey<ItemGroup> GENESIS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ZetasGenesis.MOD_ID, "item_group"));
    public static final ItemGroup GENESIS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Blocks.BRICKS))
            .displayName(Text.translatable("itemGroup.fabric_docs_reference"))
            .build();

    public static void registerGenesisItems() {
        ZetasGenesis.LOGGER.info("Registering Genesis Items for " + ZetasGenesis.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, GENESIS_ITEM_GROUP_KEY, GENESIS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GENESIS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(GenesisItems.ENDERIUM_HELMET);
            itemGroup.add(GenesisItems.ENDERIUM_CHESTPLATE);
            itemGroup.add(GenesisItems.ENDERIUM_LEGGINGS);
            itemGroup.add(GenesisItems.ENDERIUM_BOOTS);

            // ...
        });
        }

}
