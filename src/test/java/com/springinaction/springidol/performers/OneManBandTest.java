package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.instruments.Instrument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * In-container test case for {@link OneManBand}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OneManBandTest {
    @Autowired
    private OneManBand hank;
    @Autowired
    private Instrument guitar;
    @Autowired
    private Instrument cymbal;
    @Autowired
    private Instrument harmonica;

    @Test
    public void hankTest() {
        assertNotNull(hank);
        assertEquals("hank@gmail.com", hank.getEmail());
        assertEquals("hank", hank.getPerformerName());
    }

    @Test
    public void doPerformanceTest() throws PerformanceException {
        hank.doPerformance();
    }

    @Test
    public void toStringTest() {
        assertEquals("OneManBand{performerName=hank, " +
                "email=hank@gmail.com, " +
                "instruments={GUITAR=Guitar{instrumentName=guitar, instrumentSound=GUITAR}, " +
                "CYMBAL=ContestInstrument{instrumentName=cymbal, instrumentSound=CYMBAL}, " +
                "HARMONICA=ContestInstrument{instrumentName=harmonica, instrumentSound=HARMONICA}}}",
                hank.toString());
    }

    @Test
    public void hashCodeTest() {
        assertFalse(hank.hashCode() == new OneManBand("hank@gmail.com").hashCode());
    }

    @Test
    public void equalsTest() {
        assertFalse(hank.equals(null));
        assertFalse(hank.equals(new Object()));
        assertTrue(hank.equals(hank));

        OneManBand that = new OneManBand("hank@gmail.com");
        assertFalse(hank.equals(that));
        assertFalse(that.equals(hank));

        Map<String, Instrument> instruments = new HashMap<String, Instrument>();
        instruments.put("GUITAR", guitar);
        instruments.put("CYMBAL", cymbal);
        instruments.put("HARMONICA", harmonica);

        that.setBeanName("hank");
        that.setInstruments(instruments);
        assertTrue(hank.equals(that));
        assertTrue(that.equals(hank));
    }
}
