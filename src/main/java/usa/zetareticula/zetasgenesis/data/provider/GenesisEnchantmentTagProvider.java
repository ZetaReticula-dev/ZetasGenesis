package usa.zetareticula.zetasgenesis.data.provider;

import usa.zetareticula.zetasgenesis.ZetasGenesis;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class GenesisEnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {
    public GenesisEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Enchantment> TEST = TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(ZetasGenesis.MOD_ID, "enchant/test"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(TEST)
                .add(Enchantments.SHARPNESS)
                .add(Enchantments.EFFICIENCY);

    }
}
