package ru.job4j.ood.lsp.foods;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class ControllQualityTest {

    @Test
    public void whenMovingWarehose() {
        Storage storageExpected = new Warehouse();
        ControllQuality controllQuality = new ControllQuality(List.of(storageExpected, new Shop(), new Trash()));
        Food expectedFood = new Food("carror", new GregorianCalendar(2022, Calendar.FEBRUARY, 27),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expectedFood);
        Storage actual = controllQuality.getStorages().get(0);
        assertThat(storageExpected, is(actual));
    }

    @Test
    public void whenMovingShop() {
        Storage storageExpected = new Shop();
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), storageExpected, new Trash()));
        Food expectedFood = new Food("milk", new GregorianCalendar(2022, Calendar.FEBRUARY, 12),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expectedFood);
        Storage actual = controllQuality.getStorages().get(1);
        assertThat(storageExpected, is(actual));
    }

    @Test
    public void whenMovingShopDiscount() {
        Storage storageExpected = new Shop();
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), storageExpected, new Trash()));
        Food expectedFood = new Food("milk", new GregorianCalendar(2022, Calendar.MARCH, 10),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expectedFood);
        controllQuality.moving(expectedFood);
        Storage actual = controllQuality.getStorages().get(1);
        assertThat(storageExpected, is(actual));
    }

    @Test
    public void whenMovingTrash() {
        Storage storageExpected = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), storageExpected));
        Food expectedFood = new Food("milk", new GregorianCalendar(2022, Calendar.JANUARY, 30),
                new GregorianCalendar(2022, Calendar.JANUARY, 1), 100, 0);
        controllQuality.moving(expectedFood);
        Storage actual = controllQuality.getStorages().get(2);
        assertThat(storageExpected, is(actual));
    }


}
