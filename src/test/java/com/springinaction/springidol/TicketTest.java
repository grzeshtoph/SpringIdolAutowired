package com.springinaction.springidol;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Provider;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test case for the {@link Ticket}.
 */
@ContextConfiguration("/spring-idol.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketTest {
    @Autowired
    Ticket ticketExtra;
    @Autowired
    Ticket ticketNormal;
    @Autowired
    TicketCounter ticketCounter;

    @Test
    public void ticketTest() {
        assertNotNull(ticketExtra);
        assertNotNull(ticketNormal);
        assertFalse(ticketExtra == ticketNormal);
        assertTrue(ticketExtra.getTicketNo() > 0);
        assertTrue(ticketNormal.getTicketNo() > 0);
        Ticket ticket3 = new Ticket(false);
        ticket3.setTicketNo(ticketNormal.getTicketNo());
        assertTrue(ticket3.getTicketNo() > 0);
    }
}
