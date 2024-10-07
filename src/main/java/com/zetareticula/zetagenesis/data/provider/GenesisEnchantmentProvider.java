package com.zetareticula.zetagenesis.data.provider;

import com.zetareticula.zetagenesis.utils.GenesisTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.value.MultiplyEnchantmentEffect;
import net.minecraft.enchantment.effect.value.RemoveBinomialEnchantmentEffect;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class GenesisEnchantmentProvider extends FabricDynamicRegistryProvider {
    public GenesisEnchantmentProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryWrapper<Item> itemLookup = registries.getWrapperOrThrow(RegistryKeys.ITEM);

        register(entries, Enchantments.UNBREAKING, Enchantment.builder(
                Enchantment.definition(
                        itemLookup.getOrThrow(GenesisTags.Items.WAND),
                        5, // Enchantment table probability
                        3, // Max enchantment level
                        Enchantment.leveledCost(5, 8),
                        Enchantment.leveledCost(55, 8),
                        2,
                        AttributeModifierSlot.ANY


                )
        ).addEffect(
                                EnchantmentEffectComponentTypes.ITEM_DAMAGE,
                                new RemoveBinomialEnchantmentEffect(
                                        new EnchantmentLevelBasedValue.Fraction(EnchantmentLevelBasedValue.linear(2.0F), EnchantmentLevelBasedValue.linear(10.0F, 5.0F))
                                ),
                                MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ARMOR_ENCHANTABLE))
                        )
                        .addEffect(
                                EnchantmentEffectComponentTypes.ITEM_DAMAGE,
                                new RemoveBinomialEnchantmentEffect(
                                        new EnchantmentLevelBasedValue.Fraction(EnchantmentLevelBasedValue.linear(1.0F), EnchantmentLevelBasedValue.linear(2.0F, 1.0F))
                                ),
                                InvertedLootCondition.builder(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ARMOR_ENCHANTABLE)))
                        )
        );

        register(entries, Enchantments.MENDING, Enchantment.builder(
                                Enchantment.definition(
                                        itemLookup.getOrThrow(ItemTags.DURABILITY_ENCHANTABLE),
                                        2,
                                        1,
                                        Enchantment.leveledCost(25, 25),
                                        Enchantment.leveledCost(75, 25),
                                        4,
                                        AttributeModifierSlot.ANY
                                )
                        )
                        .addEffect(EnchantmentEffectComponentTypes.REPAIR_WITH_XP, new MultiplyEnchantmentEffect(EnchantmentLevelBasedValue.constant(2.0F)))
        );
    }

    private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "Enchantment Provider";
    }
}
