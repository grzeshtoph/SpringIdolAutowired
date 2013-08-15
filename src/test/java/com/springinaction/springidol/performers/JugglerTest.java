package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.*;

/**
 * In-container test case for {@link Juggler}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JugglerTest {
    @Autowired
    private Juggler duke;

    @Test
    public void dukeTest() {
        assertNotNull(duke);
        assertEquals(15, duke.getBeanBags());
        assertEquals("duke@gmail.com", duke.getEmail());
    }

    @Test
    public void doPerformanceTest() throws PerformanceException {
        duke.doPerformance();
    }

    @Test
    public void hashCodeTest() {
        Juggler duke1 = new Juggler("duke@gmail.com", 15);
        assertFalse(duke.hashCode() == duke1.hashCode());
    }

    @Test
    public void toStringTest() {
        assertEquals("Juggler{performerName=duke, email=duke@gmail.com, beanBags=15}", duke.toString());
    }

    @Test
    public void equalsTest() {
        assertTrue(duke.equals(duke));
        assertFalse(duke.equals(null));
        assertFalse(duke.equals(new Object()));

        Juggler duke1 = new Juggler("duke@gmail.com");
        assertFalse(duke.equals(duke1));
        duke1.setBeanBags(20);
        assertFalse(duke.equals(duke1));
        duke1.setBeanBags(15);
        assertFalse(duke.equals(duke1));
        duke1.setBeanName("duke");
        assertTrue(duke.equals(duke1));
    }
}
