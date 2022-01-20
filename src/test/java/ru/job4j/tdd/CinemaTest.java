package ru.job4j.tdd;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void whenRowNull() {
        Cinema cinema = new Cinema3D();
        int result = cinema.getRow(null);
        assertThat(result, is(nullValue()));
    }

    @Ignore
    @Test
    public void whenColumnNull() {
        Cinema cinema = new Cinema3D();
        int result = cinema.getColumn(null);
        assertThat(result, is(nullValue()));
    }

    @Ignore
    @Test
    public void whenTicketClone() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket1 = cinema.buy(account, 1, 1, date);
        Ticket ticket2 = cinema.buy(account, 1, 1, date);
        assertEquals(ticket1, is(ticket2));
    }
}
