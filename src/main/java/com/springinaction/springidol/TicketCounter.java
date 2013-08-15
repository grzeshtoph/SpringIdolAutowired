package com.springinaction.springidol;

/**
 * Spring based bean for counting tickets.
 */
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
