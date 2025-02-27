package com.zetareticula.zetasgenesis.sounds;

import com.zetareticula.zetasgenesis.ZetasGenesis;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
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
    public static final SoundEvent SPRING_BOARD = registerSound("spring_board");
    public static final SoundEvent ENDERITE_EQUIP = registerSound("enderite_equip");

    public static final SoundEvent ROCKET_69 = registerSound("rocket_69");
    public static final RegistryKey<JukeboxSong> ROCKET_69_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(ZetasGenesis.MOD_ID, "rocket_69"));

   public static final RegistryEntry<SoundEvent> ENDERIUM_EQUIP = registerReference("enderium_equip");


    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(ZetasGenesis.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return registerReference(Identifier.of(ZetasGenesis.MOD_ID, id));
    }

    public static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id) {
        return registerReference(id, id);
    }

    public static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }

    public static RegistryKey<JukeboxSong> registerJukeboxSong(String name) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(ZetasGenesis.MOD_ID, name));
    }

    public static void registerGenesisSounds() {
        ZetasGenesis.LOGGER.info("Registering " + ZetasGenesis.MOD_ID + " Sounds");

    }
}
