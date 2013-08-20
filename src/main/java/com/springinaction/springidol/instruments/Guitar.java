package com.springinaction.springidol.instruments;

import com.springinaction.springidol.annotations.StringedInstrument;
import com.springinaction.springidol.annotations.Strummed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Specifically annotated guitar as stringed instrument.
 */
@StringedInstrument
@Strummed
@Component
public class Guitar extends ContestInstrument {
    @Value("#{instrumentSounds['GUITAR']}")
    @Override
    public void setInstrumentSound(InstrumentSound instrumentSound) {
        super.setInstrumentSound(instrumentSound);
    }
}
