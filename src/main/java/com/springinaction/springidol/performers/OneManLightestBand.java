package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * The lightests one man band. Knows only sounds he's playing.
 */
public class OneManLightestBand extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(OneManLightestBand.class);
    @Value("#{instrumentSounds.![value.sound]}")
    private String[] sounds;

    public OneManLightestBand(String email) {
        super(email);
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        for (String sound : sounds) {
            LOG.info(sound);
        }
    }
}
