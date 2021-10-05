/*
*TODO
package ru.job4j.design.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CinemaTest {

    @Test
    public void testBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertEquals(ticket, new Ticket3D());
    }

    @Test
    public void testBuyNotCorrectByRow() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 0);
        Ticket ticket = cinema.buy(account, -5, 1, date);
        assertNotEquals(ticket, new Ticket3D());
    }

    @Test
    public void testBuyNotCorrectByColumn() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 5, -3, date);
        assertNotEquals(ticket, new Ticket3D());
    }

    @Test
    public void testBuyNotCorrectByDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        Calendar date = Calendar.getInstance();
        date.set(2099, 10, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 5, 3, date);
        assertNotEquals(ticket, new Ticket3D());
    }

    @Test
    public void testFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertEquals(sessions, Arrays.asList(new Session3D()));
    }

    @Test
    public void testFindWithoutSession() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> true);
        assertEquals(sessions, Collections.emptyList());
    }
}
 */
