package com.springinaction.springidol.performers;

import com.google.common.base.Objects;
import com.springinaction.springidol.instruments.Instrument;
import com.springinaction.springidol.PerformanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Musical performer
 */
public class Instrumentalist extends AbstractContestant {
    private static final Logger LOG = LoggerFactory.getLogger(Instrumentalist.class);
    private String song;
    private int age;
    private Instrument instrument;

    public Instrumentalist(String email) {
        super(email);
    }

    @Override
    protected void doPerformance() throws PerformanceException {
        if (age > 0)
            LOG.info("at age {}", 37);

        LOG.info("Playing a song '{}'...", song);
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("performerName", getPerformerName())
                .add("email", getEmail())
                .add("age", age)
                .add("song", song)
                .add("instrument", instrument).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Instrumentalist) {
            if (this == obj) return true;

            Instrumentalist that = (Instrumentalist) obj;

            return Objects.equal(getPerformerName(), that.getPerformerName())
                    && Objects.equal(getEmail(), that.getEmail())
                    && Objects.equal(age, that.age)
                    && Objects.equal(song, that.song)
                    && Objects.equal(instrument, that.instrument);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), song, age, instrument);
    }
}
