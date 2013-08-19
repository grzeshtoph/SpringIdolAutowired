package com.springinaction.springidol;

import com.springinaction.springidol.artifacts.Knife;
import com.springinaction.springidol.performers.KnifeJuggler;
import com.springinaction.springidol.performers.Performer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws PerformanceException {
        new App().execute();
    }

    private void execute() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");

        Ticket ticket = (Ticket) ctx.getBean("ticketExtra");
        ticket = (Ticket) ctx.getBean("ticketExtra");

        Performer performer = (Performer) ctx.getBean("duke");
        performer.perform();

        performer = (Performer) ctx.getBean("poeticDuke");
        performer.perform();
        performer.perform();

        performer = (Performer) ctx.getBean("kenny");
        performer.perform();

        performer = (Performer) ctx.getBean("kenny2");
        performer.perform();

        performer = (Performer) ctx.getBean("hank");
        performer.perform();

        performer = (Performer) ctx.getBean("hank2");
        performer.perform();

        performer = (Performer) ctx.getBean("hank3");
        performer.perform();

        performer = (Performer) ctx.getBean("hank4");
        performer.perform();

        performer = (Performer) ctx.getBean("carl");
        performer.perform();

        Knife knife = (Knife) ctx.getBean("knife");
        knife.printId();

        KnifeJuggler toby = (KnifeJuggler) ctx.getBean("toby");
        toby.perform();
    }
}
