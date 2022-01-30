package ru.job4j.ood.lsp.foods;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.job4j.template.Generator;
import ru.job4j.template.GeneratorText;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

public class ControllQualityTest {

    @Test
    public void whenMovingWarehose() {
        ControllQuality controllQuality = new ControllQuality();
        Food food = new Food("carror", new GregorianCalendar(2022, 01, 27),
                new GregorianCalendar(2022, 00, 01), 100, 0);
        controllQuality.moving(food);
        Storage storage = new Warehouse();
        System.out.println(storage.get().get(0));
    }














}
