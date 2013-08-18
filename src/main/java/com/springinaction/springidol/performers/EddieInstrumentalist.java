package com.springinaction.springidol.performers;

import com.springinaction.springidol.StringedInstrument;
import com.springinaction.springidol.instruments.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Particular instrumentalist for autowiring.
 */
public class EddieInstrumentalist extends Instrumentalist {
    public EddieInstrumentalist(String email) {
        super(email);
    }

    @Autowired
    @StringedInstrument
    @Override
    public void setInstrument(Instrument instrument) {
        super.setInstrument(instrument);
    }
}
