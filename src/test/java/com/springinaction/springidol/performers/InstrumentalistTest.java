package com.springinaction.springidol.performers;

import com.google.common.base.CharMatcher;
import com.google.common.base.Functions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.instruments.ContestInstrument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * In-container test case for {@link Instrumentalist}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InstrumentalistTest {
    private static final String SONG_PATTERN = "song=[a-zA-Z! ]+\\,";
    private static final String REPLACEMENT = "song=<SONG>,";
    private final Pattern pattern = Pattern.compile(SONG_PATTERN);
    @Autowired
    private Instrumentalist kenny;
    @Autowired
    private Instrumentalist kenny2;
    @Autowired
    private ContestInstrument saxophone;
    @Autowired
    private ContestInstrument piano;

    @Test
    public void kennyTest() {
        assertNotNull(kenny);
        assertEquals("kenny", kenny.getPerformerName());
        assertEquals("kenny@gmail.com", kenny.getEmail());
        assertEquals(37, kenny.getAge());
        assertEquals(saxophone, kenny.getInstrument());

        Set<String> songs = ImmutableSet.of("not gonna sing jingle bells!", "my song");
        assertTrue(songs.contains(kenny.getSong()));
    }

    @Test
    public void kenny2Test() {
        assertNotNull(kenny2);
        assertEquals("kenny2", kenny2.getPerformerName());
        assertEquals("kenny2@gmail.com", kenny2.getEmail());
        assertEquals(0, kenny2.getAge());
        assertTrue(CharMatcher.JAVA_UPPER_CASE.matchesAllOf(
                CharMatcher.WHITESPACE.removeFrom(kenny2.getSong())));
        assertEquals(piano, kenny2.getInstrument());
    }

    @Test
    public void doPerformanceTest() throws PerformanceException {
        kenny.doPerformance();
        kenny2.doPerformance();
    }

    @Test
    public void toStringTest() {
        assertEquals("Instrumentalist{performerName=kenny, email=kenny@gmail.com, age=37, " +
                "song=<SONG>, instrument=ContestInstrument{instrumentName=saxophone, " +
                "instrumentSound=SAXOPHONE}}", replaceSong(kenny.toString()));
        assertEquals("Instrumentalist{performerName=kenny2, email=kenny2@gmail.com, age=0, " +
                "song=<SONG>, instrument=ContestInstrument{instrumentName=piano, " +
                "instrumentSound=PIANO}}", replaceSong(kenny2.toString()));
    }

    @Test
    public void hashCodeTest() {
        assertFalse(kenny.hashCode() == kenny2.hashCode());
    }

    @Test
    public void equalsTest() {
        assertFalse(kenny.equals(null));
        assertFalse(kenny.equals(new Object()));
        assertFalse(kenny.equals(kenny2));
        assertTrue(kenny.equals(kenny));

        Instrumentalist kennyClone = new Instrumentalist("kenny@gmail.com");
        kennyClone.setBeanName("kenny");
        kennyClone.setAge(37);
        kennyClone.setInstrument(saxophone);
        kennyClone.setSong(kenny.getSong());

        assertTrue(kenny.equals(kennyClone));

        assertFalse(kenny2.equals(null));
        assertFalse(kenny2.equals(new Object()));
        assertFalse(kenny2.equals(kenny));
        assertTrue(kenny2.equals(kenny2));

        Instrumentalist kenny2Clone = new Instrumentalist("kenny2@gmail.com");
        assertFalse(kenny2.equals(kenny2Clone));
        kenny2Clone.setBeanName("kenny2");
        assertFalse(kenny2.equals(kenny2Clone));
        kenny2Clone.setInstrument(piano);
        assertFalse(kenny2.equals(kenny2Clone));
        kenny2Clone.setSong(kenny2.getSong());
        assertTrue(kenny2.equals(kenny2Clone));
        kenny2Clone.setPerformerName("kenny3");
        assertFalse(kenny2.equals(kenny2Clone));
        kenny2Clone.setEmail("kenny3@gmail.com");
        assertFalse(kenny2.equals(kenny2Clone));
    }

    private String replaceSong(String toStringValue) {
        return pattern.matcher(toStringValue).replaceAll(REPLACEMENT);
    }
}
