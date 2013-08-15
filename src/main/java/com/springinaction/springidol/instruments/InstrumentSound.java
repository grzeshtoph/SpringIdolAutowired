package com.springinaction.springidol.instruments;

/**
 * Enums representing sounds that instruments can play.
 */
public enum InstrumentSound {
    CYMBAL("CRASH CRASH CRASH"),
    GUITAR("STRUM STRUM STRUM"),
    HARMONICA("HUM HUM HUM"),
    PIANO("PLINK PLINK PLINK"),
    SAXOPHONE("TOOT TOOT TOOT");
    private final String sound;

    private InstrumentSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
