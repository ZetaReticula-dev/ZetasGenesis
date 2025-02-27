package com.zetareticula.zetasgenesis;

import com.zetareticula.zetasgenesis.block.GenesisBlockEntity;
import com.zetareticula.zetasgenesis.block.GenesisBlocks;
import com.zetareticula.zetasgenesis.item.GenesisItems;
import com.zetareticula.zetasgenesis.sounds.GenesisSounds;
import com.zetareticula.zetasgenesis.status_effects.FlightEffect;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZetasGenesis implements ModInitializer {
	public static final String MOD_ID = "zetasgenesis";
	public static final RegistryEntry<StatusEffect> FLIGHT;
	static {
		FLIGHT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("zetasgenesis", "flight"), new FlightEffect());
	}

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		GenesisItems.registerGenesisItems();
		GenesisBlocks.initializeBlocks();
		GenesisBlockEntity.initialize();
		GenesisSounds.registerGenesisSounds();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					Potions.AWKWARD,
					GenesisItems.NETHER_SHARD,
					Registries.POTION.getEntry(FLIGHT_POTION)
			);
			builder.registerPotionRecipe(
					Registries.POTION.getEntry(FLIGHT_POTION),
					Items.REDSTONE,
					Registries.POTION.getEntry(LONG_FLIGHT_POTION)
			);
		});

		LOGGER.info("Hello Fabric world!");
	}

	public static final Potion FLIGHT_POTION =
			Registry.register(
					Registries.POTION,
					Identifier.of(ZetasGenesis.MOD_ID, "flight_potion"),
					new Potion("flight_potion",
							new StatusEffectInstance(
									ZetasGenesis.FLIGHT, 3600, 0)));

	public static final Potion LONG_FLIGHT_POTION =
			Registry.register(
					Registries.POTION,
					Identifier.of(ZetasGenesis.MOD_ID, "long_flight_potion"),
					new Potion("long_flight_potion",
							new StatusEffectInstance(
									ZetasGenesis.FLIGHT, 9600, 0)));
}