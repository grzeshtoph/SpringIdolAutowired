package com.springinaction.springidol.performers;

import com.google.common.base.Objects;
import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Juggler performer.
 */
public class Juggler extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(Juggler.class);
    private int beanBags = 3;

    public Juggler(String email, int beanBags) {
        super(email);
        this.beanBags = beanBags;
    }

    public Juggler(String email) {
        super(email);
    }

    public int getBeanBags() {
        return beanBags;
    }

    public void setBeanBags(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        LOG.info("JUGGLING {} BEANBAGS", beanBags);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), beanBags);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Juggler) {
            if (this == obj) return true;

            Juggler that = (Juggler) obj;

            return Objects.equal(getEmail(), that.getEmail())
                    && Objects.equal(getPerformerName(), that.getPerformerName())
                    && Objects.equal(beanBags, that.beanBags);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("performerName", getPerformerName())
                .add("email", getEmail())
                .add("beanBags", beanBags).toString();
    }
}
