package com.springinaction.springidol.configuration;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.springinaction.springidol.SongSelector;
import com.springinaction.springidol.Stage;
import com.springinaction.springidol.instruments.ContestInstrument;
import com.springinaction.springidol.instruments.Guitar;
import com.springinaction.springidol.instruments.Instrument;
import com.springinaction.springidol.instruments.InstrumentSound;
import com.springinaction.springidol.performers.EddieInstrumentalist;
import com.springinaction.springidol.performers.Instrumentalist;
import com.springinaction.springidol.performers.Juggler;
import com.springinaction.springidol.performers.KnifeJuggler;
import com.springinaction.springidol.performers.OneManBand;
import com.springinaction.springidol.performers.OneManLightBand;
import com.springinaction.springidol.performers.OneManLighterBand;
import com.springinaction.springidol.performers.OneManLightestBand;
import com.springinaction.springidol.performers.Performer;
import com.springinaction.springidol.performers.PoeticJuggler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumSet;
import java.util.Map;
import java.util.Properties;

/**
 * Source code based Spring configuration.
 */
@Configuration
public class SpringConfig {
    @Bean
    public Performer duke() {
        return new Juggler("duke@gmail.com", 15);
    }

    @Bean
    public Performer toby() {
        return new KnifeJuggler("toby@gmail.com");
    }

    @Bean
    public Performer poeticDuke() {
        return new PoeticJuggler("poeticDuke@gmail.com", 4 * 5);
    }

    @Bean
    public Instrumentalist kenny() {
        Instrumentalist kenny = new Instrumentalist("kenny@gmail.com");
        kenny.setAge(37);
        kenny.setSong(Objects.equal("JINGLE BELLS", songSelector().selectSong().toUpperCase()) ?
                "not gonna sing jingle bells!" : "my song");
        kenny.setInstrument(saxophone());
        return kenny;
    }

    @Bean
    public Instrumentalist kenny2() {
        Instrumentalist kenny2 = new Instrumentalist("kenny2@gmail.com");
        kenny2.setSong(songSelector().selectSong().toUpperCase());
        kenny2.setInstrument(piano());
        return kenny2;
    }

    @Bean
    public Instrumentalist eddie() {
        return new EddieInstrumentalist("eddie@gmail.com");
    }

    @Bean
    public Instrumentalist carl() {
        Instrumentalist carl = new Instrumentalist("carl@gmail.com");
        carl.setSong(songSelector().selectSong().toUpperCase());
        carl.setAge(kenny().getAge());
        carl.setInstrument(kenny().getInstrument());
        return carl;
    }

    @Bean
    public OneManBand hank() {
        OneManBand hank = new OneManBand("hank@gmail.com");
        hank.setInstruments(ImmutableMap.of(
                InstrumentSound.GUITAR.toString(), guitar(),
                InstrumentSound.CYMBAL.toString(), cymbal(),
                InstrumentSound.HARMONICA.toString(), harmonica()));
        return hank;
    }

    @Bean
    public OneManLightBand hank2() {
        OneManLightBand hank2 = new OneManLightBand("hank2@gmail.com");
        hank2.setInstrumentSounds(ImmutableMap.of(
                InstrumentSound.GUITAR.toString(), InstrumentSound.GUITAR.getSound(),
                InstrumentSound.CYMBAL.toString(), InstrumentSound.CYMBAL.getSound(),
                InstrumentSound.HARMONICA.toString(), InstrumentSound.HARMONICA.getSound()));
        return hank2;
    }

    @Bean
    public OneManLighterBand hank3() {
        Properties sounds = new Properties();
        for (InstrumentSound instrumentSound : EnumSet.allOf(InstrumentSound.class)) {
            sounds.setProperty(instrumentSound.toString(), instrumentSound.getSound());
        }
        OneManLighterBand hank3 = new OneManLighterBand("hank3@gmail.com");
        hank3.setInstrumentSounds(sounds);
        return hank3;
    }

    @Bean
    public OneManLightestBand hank4() {
        return new OneManLightestBand("hank4@gmail.com");
    }

    @Bean(initMethod = "init")
    public SongSelector songSelector() {
        return SongSelector.getInstance();
    }

    @Bean
    public Instrument saxophone() {
        ContestInstrument saxophone = new ContestInstrument();
        saxophone.setInstrumentSound(instrumentSounds().get(InstrumentSound.SAXOPHONE.toString()));
        return saxophone;
    }

    @Bean
    public Instrument piano() {
        ContestInstrument piano = new ContestInstrument();
        piano.setInstrumentSound(instrumentSounds().get(InstrumentSound.PIANO.toString()));
        return piano;
    }

    @Bean
    public Instrument cymbal() {
        ContestInstrument cymbal = new ContestInstrument();
        cymbal.setInstrumentSound(instrumentSounds().get(InstrumentSound.CYMBAL.toString()));
        return cymbal;
    }

    @Bean
    public Instrument harmonica() {
        ContestInstrument harmonica = new ContestInstrument();
        harmonica.setInstrumentSound(instrumentSounds().get(InstrumentSound.HARMONICA.toString()));
        return harmonica;
    }

    @Bean
    public Instrument guitar() {
        return new Guitar();
    }

    @Bean(initMethod = "init")
    public Stage theStage() {
        Stage stage = Stage.getInstance();
        stage.setStageName("Carnegie Hall USA Special");
        return stage;
    }

    @Bean
    public Map<String, InstrumentSound> instrumentSounds() {
        ImmutableMap.Builder<String, InstrumentSound> mapBuilder = ImmutableMap.builder();
        for (InstrumentSound instrumentSound : EnumSet.allOf(InstrumentSound.class)) {
            mapBuilder.put(instrumentSound.toString(), instrumentSound);
        }
        return mapBuilder.build();
    }
}
