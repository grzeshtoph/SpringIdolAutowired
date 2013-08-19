package com.springinaction.springidol.performers;

import com.springinaction.springidol.artifacts.Sonnet29;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Test case for {@link PoeticJuggler}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PoeticJugglerTest {
    @Autowired
    private PoeticJuggler poeticDuke;
    @Autowired
    private Sonnet29 sonnet29;

    @Test
    public void poeticDukeTest() {
        assertNotNull(poeticDuke);
        assertEquals("poeticDuke@gmail.com", poeticDuke.getEmail());
        assertEquals("poeticDuke", poeticDuke.getPerformerName());
        assertEquals(20, poeticDuke.getBeanBags());
    }

    @Test
    public void equalsTest() {
        assertFalse(poeticDuke.equals(null));
        assertFalse(poeticDuke.equals(new Object()));
        assertTrue(poeticDuke.equals(poeticDuke));

        PoeticJuggler poeticDuke2 = new PoeticJuggler(null, sonnet29);
        assertFalse(poeticDuke.equals(poeticDuke2));
        poeticDuke2.setEmail(poeticDuke.getEmail());
        assertFalse(poeticDuke.equals(poeticDuke2));
        poeticDuke2.setBeanBags(poeticDuke.getBeanBags());
        assertFalse(poeticDuke.equals(poeticDuke2));
        poeticDuke2.setBeanName(poeticDuke.getPerformerName());
        assertTrue(poeticDuke.equals(poeticDuke2));
    }
}
