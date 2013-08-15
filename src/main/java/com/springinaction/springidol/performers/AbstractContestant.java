package com.springinaction.springidol.performers;

import com.google.common.base.Objects;
import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An abstract contestant that just has information about a name and displays it.
 */
public abstract class AbstractContestant implements Performer {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractContestant.class);
    private String performerName;
    private String email;

    protected AbstractContestant(String email) {
        this.email = email;
    }

    @Override
    public final void perform() throws PerformanceException {
        LOG.info("-----");
        LOG.info("Performance by '{}'", performerName);
        LOG.info("Email: {}", email);
        doPerformance();
    }

    protected abstract void doPerformance() throws PerformanceException;

    @Override
    public void setBeanName(String s) {
        performerName = s;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(performerName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof AbstractContestant) {
            if (this == obj) return true;

            AbstractContestant that = (AbstractContestant) obj;

            return Objects.equal(performerName, that.performerName)
                    && Objects.equal(email, that.email);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("performerName", performerName)
                .add("email", email).toString();
    }
}
