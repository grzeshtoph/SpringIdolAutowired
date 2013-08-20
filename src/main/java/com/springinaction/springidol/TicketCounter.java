package com.springinaction.springidol;

import org.springframework.stereotype.Component;

/**
 * Spring based bean for counting tickets.
 */
@Component
public class TicketCounter {
    public int counter;

    /**
     * Gets next value of ticket counter
     *
     * @return ticket count value
     */
    public int getNextNumber() {
        return ++counter;
    }
}
