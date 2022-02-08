package ru.job4j.ood.lsp.foods;

import org.junit.Test;
import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class ControllQualityTest {

    @Test
    public void whenMovingWarehose() {
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate today = LocalDate.now();
        Food expected = new Food("milk", today.minusDays(5), today.plusDays(30), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getStorages().get(0).get().get(0);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenMovingShop() {
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate today = LocalDate.now();
        Food expected = new Food("cabbage", today.minusDays(30), today.plusDays(30), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getStorages().get(1).get().get(0);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenMovingShopDiscount() {
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate today = LocalDate.now();
        Food expected = new Food("cabbage", today.minusDays(120), today.plusDays(30), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getStorages().get(1).get().get(0);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenMovingTrash() {
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate today = LocalDate.now();
        Food expected = new Food("cabbage", today.minusDays(30), today.minusDays(10), 100, 0);
        controllQuality.moving(expected);
        Food actual = controllQuality.getStorages().get(2).get().get(0);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenResortWarehose() {
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate today = LocalDate.now();
        Food expected = new Food("milk", today.minusDays(5), today.plusDays(30), 100, 0);
        controllQuality.moving(expected);
        controllQuality.resort();
        Food actual = controllQuality.getStorages().get(0).get().get(0);
        assertThat(actual, is(expected));
    }
}
