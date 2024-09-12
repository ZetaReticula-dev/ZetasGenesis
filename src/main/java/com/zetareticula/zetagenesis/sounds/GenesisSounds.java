package com.zetareticula.zetagenesis.sounds;

import com.zetareticula.zetagenesis.ZetaGenesis;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class GenesisSounds {
    private GenesisSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    // ITEM_METAL_WHISTLE is the name of the custom sound event
    // and is called in the mod to use the custom sound
    public static final SoundEvent INSTANT_TRANSMISSION = registerSound("instant_transmission");
    public static final SoundEvent MAGNUM_FIRE = registerSound("magnum_fire");
    public static final SoundEvent MA5B_FIRE = registerSound("ma5b_fire");
    public static final SoundEvent ENDERITE_EQUIP = registerSound("enderite_equip");

    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(ZetaGenesis.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerGenesisSounds() {
        ZetaGenesis.LOGGER.info("Registering " + ZetaGenesis.MOD_ID + " Sounds");

    }
}
