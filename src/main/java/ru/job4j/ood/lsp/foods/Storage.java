package ru.job4j.ood.lsp.foods;

import java.time.LocalDate;
import java.util.List;

public interface Storage {

    boolean add(Food food);
    boolean accept(Food food);
    List<Food> get();
    void clearList();
    default double paymentPercent(Food food) {
        int translationPercent = 100;
        LocalDate now = LocalDate.now();

        return ((double) (now.toEpochDay() - food.getCreateDate().toEpochDay())
                / (food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay())) * translationPercent;

    }
}
