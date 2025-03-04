package usa.zetareticula.zetasgenesis.item;

import usa.zetareticula.zetasgenesis.equipment.GenesisArmor;
import usa.zetareticula.zetasgenesis.equipment.GenesisToolMaterials;
import usa.zetareticula.zetasgenesis.equipment.GenesisTools;
import usa.zetareticula.zetasgenesis.ZetasGenesis;
import usa.zetareticula.zetasgenesis.item.custom.AspectOfTheVoidItem;
import usa.zetareticula.zetasgenesis.item.custom.HalberdItem;
import usa.zetareticula.zetasgenesis.item.custom.PickAndAxe;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class GenesisItems {

    public static final Item NETHER_SHARD =register("nether_star_shard", Item::new, new Item.Settings().rarity(Rarity.RARE));

    public static final Item IRON_HALBERD = register("iron_halberd",
            settings -> new HalberdItem(GenesisTools.IRON, 4.5f, -3.2f, settings),
            new Item.Settings());

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

    public static final Item ENDERIUM_SWORD = register("enderium_sword",
            settings -> new SwordItem(GenesisToolMaterials.ENDERIUM_TOOL_MATERIAL, 3f, -2.4f, settings),
            new Item.Settings());

    public static final Item ENDERIUM_SHOVEL = register("enderium_shovel",
            settings -> new ShovelItem(GenesisToolMaterials.ENDERIUM_TOOL_MATERIAL, 1.5f, -3.0f, settings),
            new Item.Settings());

    public static final Item ENDERIUM_PICKAXE = register("enderium_pickaxe",
            settings -> new PickaxeItem(GenesisToolMaterials.ENDERIUM_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings());

    public static final Item ENDERIUM_AXE = register("enderium_axe",
            settings -> new AxeItem(GenesisToolMaterials.ENDERIUM_TOOL_MATERIAL, 5f, -3.0f, settings),
            new Item.Settings());

    public static final Item ENDERIUM_HOE = register("enderium_hoe",
            settings -> new HoeItem(GenesisToolMaterials.ENDERIUM_TOOL_MATERIAL, -4.0f, 0.0f, settings),
            new Item.Settings());

    //BRASS STUFF
    public static final Item BRASS_INGOT = register("brass_ingot", Item::new, new Item.Settings());

    //PICK AND AXES
    public static final Item WOOD_PICK_AXE = register("wood_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.WOOD, 6.0F, -3.2f, settings),
            new Item.Settings());

    public static final Item STONE_PICK_AXE = register("stone_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.STONE, 7.0F, -3.2f, settings),
            new Item.Settings());

    public static final Item IRON_PICK_AXE = register("iron_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.IRON, 6.0F, -3.1f, settings),
            new Item.Settings());

    public static final Item GOLD_PICK_AXE = register("gold_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.GOLD, 6.0F, -3.0f, settings),
            new Item.Settings());

    public static final Item DIAMOND_PICK_AXE = register("diamond_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.DIAMOND, 5.0F, -3.0f, settings),
            new Item.Settings());

    public static final Item NETHERITE_PICK_AXE = register("netherite_pick_and_axe",
            settings -> new PickAndAxe(ToolMaterial.NETHERITE, 5.0F, -3.0f, settings),
            new Item.Settings());

    public static final Item ENDERIUM_PICK_AXE = register("enderium_pick_and_axe",
            settings -> new PickAndAxe(GenesisToolMaterials.ENDERIUM_TOOL_MATERIAL, 5.0F, -3.0f, settings),
            new Item.Settings());


    public static final RegistryKey<ItemGroup> GENESIS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ZetasGenesis.MOD_ID, "genesis_items"));
    public static final ItemGroup GENESIS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(GenesisItems.BRASS_INGOT))
            .displayName(Text.translatable("itemGroup.genesis_items"))
            .build();


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
        Registry.register(Registries.ITEM_GROUP, GENESIS_ITEM_GROUP_KEY, GENESIS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(GENESIS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(GenesisItems.NETHER_SHARD);
            itemGroup.add(GenesisItems.IRON_HALBERD);
            itemGroup.add(GenesisItems.VOID_STAFF);
            itemGroup.add(GenesisItems.ENDERIUM_HELMET);
            itemGroup.add(GenesisItems.ENDERIUM_CHESTPLATE);
            itemGroup.add(GenesisItems.ENDERIUM_LEGGINGS);
            itemGroup.add(GenesisItems.ENDERIUM_BOOTS);
            itemGroup.add(GenesisItems.ENDERIUM_SWORD);
            itemGroup.add(GenesisItems.ENDERIUM_SHOVEL);
            itemGroup.add(GenesisItems.ENDERIUM_PICKAXE);
            itemGroup.add(GenesisItems.ENDERIUM_AXE);
            itemGroup.add(GenesisItems.ENDERIUM_HOE);
            itemGroup.add(GenesisItems.BRASS_INGOT);
            itemGroup.add(GenesisItems.WOOD_PICK_AXE);
            itemGroup.add(GenesisItems.STONE_PICK_AXE);
            itemGroup.add(GenesisItems.IRON_PICK_AXE);
            itemGroup.add(GenesisItems.GOLD_PICK_AXE);
            itemGroup.add(GenesisItems.DIAMOND_PICK_AXE);
            itemGroup.add(GenesisItems.NETHERITE_PICK_AXE);
            itemGroup.add(GenesisItems.ENDERIUM_PICK_AXE);
        });

    }
}
