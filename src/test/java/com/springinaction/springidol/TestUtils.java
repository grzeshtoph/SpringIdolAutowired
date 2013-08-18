package com.springinaction.springidol;

import java.util.regex.Pattern;

/**
 * Static utilities for unit tests.
 */
public final class TestUtils {
    private static final String SONG_PATTERN = "song=[a-zA-Z! ]+\\,";
    private static final String REPLACEMENT = "song=<SONG>,";
    private static final Pattern PATTERN = Pattern.compile(SONG_PATTERN);

    private TestUtils() {
    }

    /**
     * Replaces a random song with fixed value.
     *
     * @param toStringValue random toString output with song name to be replaced
     * @return toString output with fixed song name
     */
    public static final String replaceSong(String toStringValue) {
        return PATTERN.matcher(toStringValue).replaceAll(REPLACEMENT);
    }
}
