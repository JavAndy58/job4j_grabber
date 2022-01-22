package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceNot() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 02, 10, 23, 00);
        cinema.buy(account, -1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenDateNot() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2000, 10, 10, 23, 00);
        cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenCloneTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 02, 10, 23, 00);
        cinema.buy(account, 1, 1, date);
        cinema.buy(account, 1, 1, date);
    }

}
