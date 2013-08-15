package com.springinaction.springidol.instruments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.*;

/**
 * In-container test case for {@link com.springinaction.springidol.instruments.ContestInstrument}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ContestInstrumentTest {
    @Autowired
    private ContestInstrument saxophone;
    @Autowired
    private ContestInstrument piano;
    @Autowired
    private ContestInstrument cymbal;
    @Autowired
    private ContestInstrument guitar;
    @Autowired
    private ContestInstrument harmonica;

    @Test
    public void saxophoneTest() {
        assertNotNull(saxophone);
        assertEquals("ContestInstrument{instrumentName=saxophone, instrumentSound=SAXOPHONE}",
                saxophone.toString());
        assertEquals("saxophone", saxophone.getInstrumentName());
        assertEquals(InstrumentSound.SAXOPHONE, saxophone.getInstrumentSound());

        ContestInstrument saxophone1 = new ContestInstrument();
        saxophone1.setBeanName("saxophone");
        saxophone1.setInstrumentSound(InstrumentSound.SAXOPHONE);

        assertTrue(saxophone.equals(saxophone1));
        assertTrue(saxophone.equals(saxophone));
        assertFalse(saxophone.equals(null));
        assertFalse(saxophone.equals(piano));
        assertFalse(saxophone.equals(cymbal));
        assertFalse(saxophone.equals(guitar));
        assertFalse(saxophone.equals(harmonica));

        assertFalse(saxophone.hashCode() == piano.hashCode());
        assertFalse(saxophone.hashCode() == cymbal.hashCode());
        assertFalse(saxophone.hashCode() == guitar.hashCode());
        assertFalse(saxophone.hashCode() == harmonica.hashCode());

        saxophone.play();
    }

    @Test
    public void pianoTest() {
        assertNotNull(piano);
        assertEquals("ContestInstrument{instrumentName=piano, instrumentSound=PIANO}",
                piano.toString());
        assertEquals("piano", piano.getInstrumentName());
        assertEquals(InstrumentSound.PIANO, piano.getInstrumentSound());

        piano.play();
    }

    @Test
    public void cymbalTest() {
        assertNotNull(cymbal);
        assertEquals("ContestInstrument{instrumentName=cymbal, instrumentSound=CYMBAL}",
                cymbal.toString());
        assertEquals("cymbal", cymbal.getInstrumentName());
        assertEquals(InstrumentSound.CYMBAL, cymbal.getInstrumentSound());

        cymbal.play();
    }

    @Test
    public void guitarTest() {
        assertNotNull(guitar);
        assertEquals("ContestInstrument{instrumentName=guitar, instrumentSound=GUITAR}",
                guitar.toString());
        assertEquals("guitar", guitar.getInstrumentName());
        assertEquals(InstrumentSound.GUITAR, guitar.getInstrumentSound());

        guitar.play();
    }

    @Test
    public void harmonicaTest() {
        assertNotNull(harmonica);
        assertEquals("ContestInstrument{instrumentName=harmonica, instrumentSound=HARMONICA}",
                harmonica.toString());
        assertEquals("harmonica", harmonica.getInstrumentName());
        assertEquals(InstrumentSound.HARMONICA, harmonica.getInstrumentSound());

        harmonica.play();
    }
}
