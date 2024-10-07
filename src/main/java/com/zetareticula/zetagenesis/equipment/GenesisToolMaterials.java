package com.zetareticula.zetagenesis.equipment;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.item.GenesisItems;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum GenesisToolMaterials implements ToolMaterial{
    ENDERIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3000,12.0F,5.0F,25,
            () -> Ingredient.ofItems(GenesisItems.ENDERIUM_INGOT)),


    IRON_HAMMER(BlockTags.INCORRECT_FOR_IRON_TOOL, 400,4.0F,4.0F,14,
            () -> Ingredient.ofItems(Items.IRON_BLOCK)),
    DIAMOND_HAMMER(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 800,6.0F,5.0F,10,
            () -> Ingredient.ofItems(Items.DIAMOND_BLOCK)),
    NETHERITE_HAMMER(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1100,7.0F,6.0F,15,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    KNIFE_IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, 250,6.0F,1.5F,14,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    KNIFE_DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 2.5F, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    KNIFE_GOLD(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, -0.5F, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    KNIFE_NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 3.5F, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));



    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    GenesisToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    public static void registerGenesisToolMaterials() {
        ZetaGenesis.LOGGER.info("Registering Genesis Tool Materals for " + ZetaGenesis.MOD_ID);
    }
}
