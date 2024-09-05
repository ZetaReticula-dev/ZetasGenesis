package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.block.GenesisBlockGroup;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.component.GenesisComponents;
import com.zetareticula.zetagenesis.enchantment.GenesisEnchantments;
import com.zetareticula.zetagenesis.equipment.GenesisToolMaterials;
import com.zetareticula.zetagenesis.food.GenesisFoodGroup;
import com.zetareticula.zetagenesis.sounds.GenesisSounds;
import com.zetareticula.zetagenesis.utils.PlayerDeathEvent;
import com.zetareticula.zetagenesis.item.GenesisItemGroup;
import com.zetareticula.zetagenesis.item.GenesisItems;
import com.zetareticula.zetagenesis.equipment.GenesisArmor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZetaGenesis implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "zetasgenesis";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		GenesisItems.registerGenesisItems();
		GenesisBlocks.registerGenesisBlocks();
		GenesisArmor.registerGenesisArmor();
		GenesisComponents.registerGensisComponents();
		GenesisBlockGroup.registerGenesisBlockGroup();
		GenesisItemGroup.registerGenesisItemGroup();
		GenesisToolMaterials.registerGenesisToolMaterials();
		GenesisSounds.registerGenesisSounds();
		GenesisFoodGroup.registerGenesisFoodGroup();
		PlayerDeathEvent.registerPlayerDeathEvent();
		GenesisEnchantments.load();
		FuelRegistry.INSTANCE.add(GenesisItems.URANIUM_FUEL_ROD, 240000);

	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

