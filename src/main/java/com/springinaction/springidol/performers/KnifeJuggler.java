package com.springinaction.springidol.performers;

import com.google.common.collect.Sets;
import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.artifacts.Knife;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.Set;

/**
 * Juggles with knives.
 */
public class KnifeJuggler extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(KnifeJuggler.class);
    private static final int MAX_KNIVES = 5;
    private Set<Knife> knives;

    public KnifeJuggler(String email) {
        super(email);
    }

    @Inject
    @Named("jugglingKnife")
    public void setKnives(Provider<Knife> knifeProvider) {
        knives = Sets.newHashSet();
        for (int i = 0; i < MAX_KNIVES; i++) {
            knives.add(knifeProvider.get());
        }
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        LOG.info("Juggling {} knives: {}", MAX_KNIVES, knives);
    }
}
