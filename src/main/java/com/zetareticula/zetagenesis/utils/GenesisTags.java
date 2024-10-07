package com.zetareticula.zetagenesis.utils;

import com.zetareticula.zetagenesis.ZetaGenesis;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class GenesisTags {
    public static class Blocks {
        public static final TagKey<Block> TRAY_HEAT_SOURCES = createTag("tray_heat_sources");
        public static final TagKey<Block> HEAT_SOURCES = createTag("heat_sources");
        public static final TagKey<Block> HEAT_CONDUCTORS = createTag("heat_conductors");
        public static final TagKey<Block> END_STONE_REPLACEABLES = createTag("end_stone_replaceables");
        public static final TagKey<Block> MULTI_TOOL_MINEABLE = createTag("multi_tool_mineable");



        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ZetaGenesis.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> WAND = createTag("wand");
        public static final TagKey<Item> CRAFTING_TABLES = createTag("crafting_tables");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ZetaGenesis.MOD_ID, name));
        }
    }

    public static class Enchantments {

        public static final TagKey<Enchantment> UNBREAKING_MENDING = createTag("unbreaking_mending");

        private static TagKey<Enchantment> createTag(String name) {
            return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(ZetaGenesis.MOD_ID, name));
        }
}

    public static class Enchantable {

        public static final TagKey<Enchantment> UNBREAKING_MENDING = createTag("unbreaking_mending");

        private static TagKey<Enchantment> createTag(String name) {
            return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(ZetaGenesis.MOD_ID, name));
        }
    }

}
