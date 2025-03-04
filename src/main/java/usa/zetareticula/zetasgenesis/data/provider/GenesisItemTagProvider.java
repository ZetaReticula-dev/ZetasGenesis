package usa.zetareticula.zetasgenesis.data.provider;

import usa.zetareticula.zetasgenesis.ZetasGenesis;
import usa.zetareticula.zetasgenesis.item.GenesisItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class GenesisItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public GenesisItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> SWEEPING_COMPATIBLE = TagKey.of(RegistryKeys.ITEM, Identifier.of(ZetasGenesis.MOD_ID, "sweeping_compatible"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(GenesisItems.ENDERIUM_PICKAXE);

        getOrCreateTagBuilder(GenesisItemTagProvider.SWEEPING_COMPATIBLE)
                .add(GenesisItems.IRON_HALBERD);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(GenesisItems.ENDERIUM_HELMET)
                .add(GenesisItems.ENDERIUM_CHESTPLATE)
                .add(GenesisItems.ENDERIUM_LEGGINGS)
                .add(GenesisItems.ENDERIUM_BOOTS);

    }
}
