package ru.job4j.tdd;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tdd.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class CinemaTest {


    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));

    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceNot() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        cinema.bookingTicket(2, 3, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenDateNot() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2000, 10, 10, 23, 00);
        cinema.bookingTicket(1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenCloneTicket() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2000, 10, 10, 23, 00);
        cinema.bookingTicket(1, 1, date);
        cinema.bookingTicket(1, 1, date);
    }

}
