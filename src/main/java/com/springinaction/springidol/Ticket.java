package com.springinaction.springidol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.inject.Provider;

public class Ticket {
    private static final Logger LOG = LoggerFactory.getLogger(Ticket.class);
    @Value("#{ticketCounter.getNextNumber()}")
    private int ticketNo;
    @Value("#{theStage.stageName matches '.*USA.*'}")
    private boolean extraPrice;

    public Ticket(boolean extraPrice, int ticketNo) {
        this.extraPrice = extraPrice;
        this.ticketNo = ticketNo;
    }

    public Ticket() {
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void init() {
        LOG.debug("Ticket number {} created", ticketNo);
        if (extraPrice)
            LOG.debug("Ticker has extra price, as the venue is special");
    }
}
