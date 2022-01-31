package ru.job4j.ood.lsp.foods;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class ControllQualityTest {

    @Test
    public void whenMovingWarehose() {
        ControllQuality controllQuality = new ControllQuality();
        Food expected = new Food("carror", new GregorianCalendar(2022, Calendar.FEBRUARY, 27),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getList().get(0);
        assertThat(expected, is(actual));
    }

    @Test
    public void whenMovingShop() {
        ControllQuality controllQuality = new ControllQuality();
        Food expected = new Food("milk", new GregorianCalendar(2022, Calendar.FEBRUARY, 12),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getList().get(0);
        assertThat(expected, is(actual));
    }

    @Test
    public void whenMovingShopDiscount() {
        ControllQuality controllQuality = new ControllQuality();
        double expectedDiscount = 15;
        Food food = new Food("milk", new GregorianCalendar(2022, Calendar.FEBRUARY, 5),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(food);
        Double actual = controllQuality.getList().get(0).getDiscount();
        assertThat(expectedDiscount, is(actual));
    }

    @Test
    public void whenMovingTrash() {
        ControllQuality controllQuality = new ControllQuality();
        Food expected = new Food("milk", new GregorianCalendar(2022, Calendar.JANUARY, 30),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getList().get(0);
        assertThat(expected, is(actual));
    }

}
