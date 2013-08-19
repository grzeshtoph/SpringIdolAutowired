package com.springinaction.springidol.artifacts;

import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * The artifact for the knife juggler.
 */
public class Knife {
    private static final Logger LOG = LoggerFactory.getLogger(Knife.class);
    private static final int MAX_ID = 10000;
    private int id = (int) (Math.random() * MAX_ID);

    public void printId() {
        LOG.info("knife of id = {}", id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).toString();
    }
}
