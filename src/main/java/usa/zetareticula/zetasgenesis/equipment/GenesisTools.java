package usa.zetareticula.zetasgenesis.equipment;

import java.util.List;

import usa.zetareticula.zetasgenesis.ZetasGenesis;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.component.type.ToolComponent.Rule;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public record GenesisTools(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {


    public static final GenesisTools WOOD;
    public static final GenesisTools STONE;
    public static final GenesisTools IRON;
    public static final GenesisTools DIAMOND;
    public static final GenesisTools GOLD;
    public static final GenesisTools NETHERITE;


    public static final GenesisTools ENDERIUM_TOOL_MATERIAL = new GenesisTools(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            12.0F,
            4.0F,
            15,
            ItemTags.REPAIRS_NETHERITE_ARMOR

    );

    public GenesisTools(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairItems = repairItems;
    }

    private Item.Settings applyBaseSettings(Item.Settings settings) {
        return settings.maxDamage(this.durability).repairable(this.repairItems).enchantable(this.enchantmentValue);
    }

    public Item.Settings applyToolSettings(Item.Settings settings, TagKey<Block> effectiveBlocks, float attackDamage, float attackSpeed) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        return this.applyBaseSettings(settings).component(DataComponentTypes.TOOL, new ToolComponent(List.of(Rule.ofNeverDropping(registryEntryLookup.getOrThrow
                (this.incorrectBlocksForDrops)), Rule.ofAlwaysDropping(registryEntryLookup.getOrThrow(effectiveBlocks), this.speed)), 1.0F, 1))
                .attributeModifiers(this.createToolAttributeModifiers(attackDamage, attackSpeed));
    }

    private AttributeModifiersComponent createToolAttributeModifiers(float attackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
                (double)(attackDamage + this.attackDamageBonus), Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.ATTACK_SPEED,
                new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public Item.Settings applyHalberdSettings(Item.Settings settings, float attackDamage, float attackSpeed) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        return this.applyBaseSettings(settings).component(DataComponentTypes.TOOL, new ToolComponent(List.of(Rule.ofAlwaysDropping(RegistryEntryList.of
                        (new RegistryEntry[]{Blocks.COBWEB.getRegistryEntry()}), 15.0F), Rule.of(registryEntryLookup.getOrThrow(BlockTags.SWORD_EFFICIENT),
                        1.5F)), 1.0F, 2))
                .attributeModifiers(this.createHalberdAttributeModifiers(attackDamage, attackSpeed));
    }

    private AttributeModifiersComponent createHalberdAttributeModifiers(float attackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
                (double)(attackDamage + this.attackDamageBonus), Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.ATTACK_SPEED,
                new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(Identifier.of(ZetasGenesis.MOD_ID, "halberd_reach"), 3.0,
                        EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public TagKey<Block> incorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int durability() {
        return this.durability;
    }

    public float speed() {
        return this.speed;
    }

    public float attackDamageBonus() {
        return this.attackDamageBonus;
    }

    public int enchantmentValue() {
        return this.enchantmentValue;
    }

    public TagKey<Item> repairItems() {
        return this.repairItems;
    }

    static {
        WOOD = new GenesisTools(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0F, 0.0F, 15, ItemTags.WOODEN_TOOL_MATERIALS);
        STONE = new GenesisTools(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, ItemTags.STONE_TOOL_MATERIALS);
        IRON = new GenesisTools(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, ItemTags.IRON_TOOL_MATERIALS);
        DIAMOND = new GenesisTools(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, ItemTags.DIAMOND_TOOL_MATERIALS);
        GOLD = new GenesisTools(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, 0.0F, 22, ItemTags.GOLD_TOOL_MATERIALS);
        NETHERITE = new GenesisTools(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);
    }

}
