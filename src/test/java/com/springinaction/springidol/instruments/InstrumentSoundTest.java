package com.springinaction.springidol.instruments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * In-container test case for {@link InstrumentSound} embedded into spring context as a list.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InstrumentSoundTest {
    @Resource
    private Map<String, InstrumentSound> instrumentSounds;

    @Test
    public void instrumentSoundsTest() {
        assertNotNull(instrumentSounds);
        assertEquals(5, instrumentSounds.size());
        assertEquals(InstrumentSound.GUITAR, instrumentSounds.get("GUITAR"));
        assertEquals(InstrumentSound.CYMBAL, instrumentSounds.get("CYMBAL"));
        assertEquals(InstrumentSound.HARMONICA, instrumentSounds.get("HARMONICA"));
        assertEquals(InstrumentSound.SAXOPHONE, instrumentSounds.get("SAXOPHONE"));
        assertEquals(InstrumentSound.PIANO, instrumentSounds.get("PIANO"));
    }
}
