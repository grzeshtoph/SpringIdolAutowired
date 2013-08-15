package com.springinaction.springidol.instruments;

import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * General implementation of contest instrument.
 */
public class ContestInstrument implements Instrument {
    private static final Logger LOG = LoggerFactory.getLogger(ContestInstrument.class);
    private String instrumentName;
    private InstrumentSound instrumentSound;

    @Override
    public final void play() {
        LOG.info("Playing {}", instrumentName);
        LOG.info(instrumentSound.getSound());
    }

    @Override
    public void setBeanName(String s) {
        this.instrumentName = s;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentSound(InstrumentSound instrumentSound) {
        this.instrumentSound = instrumentSound;
    }

    public InstrumentSound getInstrumentSound() {
        return instrumentSound;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(instrumentName, instrumentSound);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ContestInstrument) {
            if (this == obj) return true;

            ContestInstrument that = (ContestInstrument) obj;

            return Objects.equal(instrumentName, that.instrumentName)
                    && Objects.equal(instrumentSound, that.instrumentSound);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("instrumentName", instrumentName)
                .add("instrumentSound", instrumentSound).toString();
    }
}
