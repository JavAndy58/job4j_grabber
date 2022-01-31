package ru.job4j.ood.lsp.foods;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class ControllQualityTest {

    @Test
    public void whenMovingWarehose() {
        ControllQuality controllQuality = new ControllQuality(Arrays.asList(new Warehouse(), new Shop(), new Trash()));
        Food expected = new Food("carror", new GregorianCalendar(2022, Calendar.FEBRUARY, 27),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getList().get(0);
        assertThat(expected, is(actual));
    }

}
