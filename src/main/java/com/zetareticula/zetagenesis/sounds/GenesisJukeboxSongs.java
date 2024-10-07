package com.zetareticula.zetagenesis.sounds;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public interface GenesisJukeboxSongs {
    RegistryKey<JukeboxSong> DOOM = of("doom");


    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.ofVanilla(id));
    }

    private static void register(
            Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, SoundEvent soundEvents, int lengthInSeconds, int comparatorOutput
    ) {
        registry.register(
                key, new JukeboxSong((RegistryEntry<SoundEvent>) soundEvents, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), (float)lengthInSeconds, comparatorOutput)
        );
    }

    static void bootstrap(Registerable<JukeboxSong> registry) {
        register(registry, DOOM, GenesisSounds.SPRING_BOARD, 178, 1);

}}

