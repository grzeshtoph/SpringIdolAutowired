package com.springinaction.springidol.performers;

import com.springinaction.springidol.annotations.StringedInstrument;
import com.springinaction.springidol.annotations.Strummed;
import com.springinaction.springidol.instruments.Instrument;

import javax.inject.Inject;

/**
 * Particular instrumentalist for autowiring.
 */
public class EddieInstrumentalist extends Instrumentalist {
    public EddieInstrumentalist(String email) {
        super(email);
    }

    @Inject
    @StringedInstrument
    @Strummed
    @Override
    public void setInstrument(Instrument instrument) {
        super.setInstrument(instrument);
    }
}
