package com.springinaction.springidol;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public final class SongSelector {
    private static final Logger LOG = LoggerFactory.getLogger(SongSelector.class);
    private final ImmutableList<String> songs = ImmutableList.of(
            "Jingle Bells",
            "LaLaLa",
            "Wherever I May Roam",
            "Abcdefg"
    );
    private final Random randomizer = new Random();

    private SongSelector() {
    }

    public static SongSelector getInstance() {
        return SongSelectorInstanceHolder.INSTANCE;
    }

    public String selectSong() {
        int songIx = randomizer.nextInt(songs.size());
        String selectedSong = songs.get(songIx);

        LOG.debug("Song number {} selected: {}", songIx, selectedSong);

        return selectedSong;
    }

    public void init() {
        LOG.debug("SongSelector created");
    }

    private static final class SongSelectorInstanceHolder {
        private static final SongSelector INSTANCE = new SongSelector();
    }
}
