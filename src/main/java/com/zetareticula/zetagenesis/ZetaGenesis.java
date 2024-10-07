package com.zetareticula.zetagenesis;

import com.zetareticula.zetagenesis.block.GenesisBlockEntity;
import com.zetareticula.zetagenesis.block.entity.BasketBlockEntity;
import com.zetareticula.zetagenesis.groups.FarmerDelightGroup;
import com.zetareticula.zetagenesis.groups.GenesisBlockGroup;
import com.zetareticula.zetagenesis.block.GenesisBlocks;
import com.zetareticula.zetagenesis.component.GenesisComponents;
import com.zetareticula.zetagenesis.enchantment.GenesisEnchantments;
import com.zetareticula.zetagenesis.equipment.GenesisToolMaterials;
import com.zetareticula.zetagenesis.groups.GenesisFoodGroup;
import com.zetareticula.zetagenesis.screenhandler.GenesisScreenHandlerType;
import com.zetareticula.zetagenesis.sounds.GenesisSounds;
import com.zetareticula.zetagenesis.utils.PlayerDeathEvent;
import com.zetareticula.zetagenesis.groups.GenesisItemGroup;
import com.zetareticula.zetagenesis.item.GenesisItems;
import com.zetareticula.zetagenesis.equipment.GenesisArmor;
import com.zetareticula.zetagenesis.worldgen.GenesisBiomeModification;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
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
		FarmerDelightGroup.registerFarmerDelightGroup();
		GenesisToolMaterials.registerGenesisToolMaterials();
		GenesisBlockEntity.registerGenesisBlockEntity();
		GenesisScreenHandlerType.registerGenesisScreenType();
		GenesisSounds.registerGenesisSounds();
		GenesisFoodGroup.registerGenesisFoodGroup();
		PlayerDeathEvent.registerPlayerDeathEvent();
		GenesisEnchantments.load();

		GenesisBiomeModification.load();

		FuelRegistry.INSTANCE.add(GenesisItems.URANIUM_FUEL_ROD, 32767);

		ItemStorage.SIDED.registerForBlockEntity(BasketBlockEntity::getInventoryProvider, GenesisBlockEntity.BASKET_BLOCK_ENTITY);

	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

