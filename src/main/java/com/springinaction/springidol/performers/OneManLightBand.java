package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * one man light band that's based on properties, not on the intruments references.
 */
public class OneManLightBand extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(OneManLightBand.class);
    private Map<String, String> instrumentSounds;

    public OneManLightBand(String email) {
        super(email);
    }

    public void setInstrumentSounds(Map<String, String> instrumentSounds) {
        this.instrumentSounds = instrumentSounds;
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        for (Map.Entry<String, String> entry : instrumentSounds.entrySet()) {
            LOG.info("{}: {}", entry.getKey(), entry.getValue());
        }
    }
}
