package com.springinaction.springidol.performers;

import com.springinaction.springidol.annotations.StringedInstrument;
import com.springinaction.springidol.annotations.Strummed;
import com.springinaction.springidol.instruments.Instrument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Particular instrumentalist for autowiring.
 */
public class EddieInstrumentalist extends Instrumentalist {
    public EddieInstrumentalist(String email) {
        super(email);
    }

    @Value("#{songSelector.selectSong()?.toLowerCase()}")
    @Override
    public void setSong(String song) {
        super.setSong(song);
    }

    @Value("#{kenny.age}")
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Inject
    @StringedInstrument
    @Strummed
    @Override
    public void setInstrument(Instrument instrument) {
        super.setInstrument(instrument);
    }
}
