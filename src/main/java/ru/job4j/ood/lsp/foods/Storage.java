package ru.job4j.ood.lsp.foods;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public interface Storage {
    Calendar CURRENT_DATA = new GregorianCalendar(2022, Calendar.JANUARY, 31);
    int TRANSLATION_PERCENT = 100;

    boolean add(Food food);
    boolean accept(Food food);
    List<Food> get();
    default double paymentPercent(Food food) {
        return ((double) (CURRENT_DATA.getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                / (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis())) * TRANSLATION_PERCENT;

    }
}
