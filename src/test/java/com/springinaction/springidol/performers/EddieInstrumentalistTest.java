package com.springinaction.springidol.performers;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.TestUtils;
import com.springinaction.springidol.instruments.Instrument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Test case for {@link EddieInstrumentalist}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EddieInstrumentalistTest {
    @Autowired
    private EddieInstrumentalist eddie;
    @Autowired
    private Instrumentalist kenny;
    @Autowired
    private Instrument guitar;

    @Test
    public void eddieTest() {
        assertNotNull(eddie);
        assertEquals("eddie", eddie.getPerformerName());
        assertEquals("eddie@gmail.com", eddie.getEmail());
        assertEquals(37, eddie.getAge());
        assertEquals(guitar, eddie.getInstrument());
        assertFalse(Strings.isNullOrEmpty(eddie.getSong()));
        assertTrue(CharMatcher.JAVA_LOWER_CASE.matchesAllOf(
                CharMatcher.WHITESPACE.removeFrom(eddie.getSong())));
    }

    @Test
    public void doPerformanceTest() throws PerformanceException {
        eddie.doPerformance();
    }

    @Test
    public void toStringTest() {
        assertEquals("EddieInstrumentalist{performerName=eddie, email=eddie@gmail.com, age=37, song=<SONG>, " +
                "instrument=Guitar{instrumentName=guitar, instrumentSound=GUITAR}}",
                TestUtils.replaceSong(eddie.toString()));
    }

    @Test
    public void hashCodeTest() {
        assertFalse(eddie.hashCode() == kenny.hashCode());
    }

    @Test
    public void equalsTest() {
        assertFalse(eddie.equals(null));
        assertFalse(eddie.equals(new Object()));
        assertTrue(eddie.equals(eddie));
        assertFalse(eddie.equals(kenny));

        Instrumentalist eddieClone = new EddieInstrumentalist(eddie.getEmail());
        assertFalse(eddie.equals(eddieClone));
        eddieClone.setInstrument(eddie.getInstrument());
        assertFalse(eddie.equals(eddieClone));
        eddieClone.setSong(eddie.getSong());
        assertFalse(eddie.equals(eddieClone));
        eddieClone.setBeanName(eddie.getPerformerName());
        assertFalse(eddie.equals(eddieClone));
        eddieClone.setAge(eddie.getAge());
        assertTrue(eddie.equals(eddieClone));
        assertTrue(eddieClone.equals(eddie));
    }
}
