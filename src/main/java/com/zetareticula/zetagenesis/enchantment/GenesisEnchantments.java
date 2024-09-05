package com.zetareticula.zetagenesis.enchantment;

import com.mojang.serialization.MapCodec;
import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.enchantment.effects.FlightEnchantmentEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class GenesisEnchantments {




    public static final RegistryKey<Enchantment> FLIGHT_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, ZetaGenesis.id("flight"));

    public static final MapCodec<FlightEnchantmentEffect> FLIGHT_EFFECT = register("flight", FlightEnchantmentEffect.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
    return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, ZetaGenesis.id(name), codec);
    }

    public static void load() {}
}
