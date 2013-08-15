package com.springinaction.springidol.performers;

import com.google.common.base.Objects;
import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.instruments.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * One man band that can play on multiple instruments.
 */
public class OneManBand extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(OneManBand.class);
    private Map<String, Instrument> instruments;

    public OneManBand(String email) {
        super(email);
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        for (Map.Entry<String, Instrument> entry : instruments.entrySet()) {
            LOG.info("{}:", entry.getKey());
            entry.getValue().play();
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("performerName", getPerformerName())
                .add("email", getEmail())
                .add("instruments", instruments).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof OneManBand) {
            if (this == obj) return true;

            OneManBand that = (OneManBand) obj;

            return Objects.equal(getPerformerName(), that.getPerformerName())
                    && Objects.equal(getEmail(), that.getEmail())
                    && Objects.equal(instruments, that.instruments);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPerformerName(), getEmail(), instruments);
    }
}
