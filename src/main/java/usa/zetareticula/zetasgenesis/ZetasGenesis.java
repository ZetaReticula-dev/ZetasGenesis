package usa.zetareticula.zetasgenesis;

import usa.zetareticula.zetasgenesis.block.GenesisBlockEntity;
import usa.zetareticula.zetasgenesis.block.GenesisBlocks;
import usa.zetareticula.zetasgenesis.item.GenesisItems;
import usa.zetareticula.zetasgenesis.sounds.GenesisSounds;
import usa.zetareticula.zetasgenesis.status_effects.FlightEffect;
import usa.zetareticula.zetasgenesis.status_effects.RadiationEffect;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZetasGenesis implements ModInitializer {
	public static final String MOD_ID = "zetasgenesis";
	public static final RegistryEntry<StatusEffect> FLIGHT;
	static {
		FLIGHT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("zetasgenesis", "flight"), new FlightEffect());
	}
	public static final RegistryEntry<StatusEffect> RADIATION;
	static {
		RADIATION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("zetasgenesis", "radiation"), new RadiationEffect());
	}

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		GenesisItems.initializeItems();
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