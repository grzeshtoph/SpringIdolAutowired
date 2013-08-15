package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Properties;

/**
 * one man light band that's based on properties, not on the intruments references.
 */
public class OneManLighterBand extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(OneManLighterBand.class);
    private Properties instrumentSounds;

    public OneManLighterBand(String email) {
        super(email);
    }

    public void setInstrumentSounds(Properties instrumentSounds) {
        this.instrumentSounds = instrumentSounds;
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        Enumeration<String> propNames = (Enumeration<String>) instrumentSounds.propertyNames();

        while (propNames.hasMoreElements()) {
            String propName = propNames.nextElement();
            LOG.info("{}: {}", propName, instrumentSounds.getProperty(propName));
        }
    }
}
