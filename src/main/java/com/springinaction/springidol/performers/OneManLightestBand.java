package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The lightests one man band. Knows only sounds he's playing.
 */
public class OneManLightestBand extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(OneManLightestBand.class);
    private String[] sounds;

    protected OneManLightestBand(String email) {
        super(email);
    }

    public void setSounds(String[] sounds) {
        this.sounds = sounds;
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        for (String sound : sounds) {
            LOG.info(sound);
        }
    }
}
