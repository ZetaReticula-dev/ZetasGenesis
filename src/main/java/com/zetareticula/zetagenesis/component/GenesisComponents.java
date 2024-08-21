package com.zetareticula.zetagenesis.component;

import com.mojang.serialization.Codec;
import com.zetareticula.zetagenesis.ZetaGenesis;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GenesisComponents {

    public static final ComponentType<Integer> FLIGHT_TRACKER = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(ZetaGenesis.MOD_ID, "flight_tracker"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );






    public static void registerGensisComponents() {
        ZetaGenesis.LOGGER.info("Registering Genesis Components for " + ZetaGenesis.MOD_ID);
    }
}
