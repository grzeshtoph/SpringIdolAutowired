package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.poems.Poem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Poetic juggler. Juggles and recites a poem.
 */
public class PoeticJuggler extends Juggler {
    private static final Logger LOG = LoggerFactory.getLogger(PoeticJuggler.class);
    @Inject
    private Poem poem;

    public PoeticJuggler(String email, Poem poem) {
        super(email);
        this.poem = poem;
    }

    public PoeticJuggler(String email, int beanBags) {
        super(email, beanBags);
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        super.doPerformance();
        LOG.info("While reciting...");
        poem.recite();
    }
}
