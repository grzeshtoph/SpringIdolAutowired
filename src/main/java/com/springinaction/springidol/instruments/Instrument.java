package com.springinaction.springidol.instruments;

import org.springframework.beans.factory.BeanNameAware;

/**
 * The interface for instrument.
 */
public interface Instrument extends BeanNameAware {
    void play();
}
