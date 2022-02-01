package ru.job4j.ood.lsp.foods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean temp = false;
        if (accept(food)) {
            temp = foods.add(food);
        }
        return temp;
    }

    @Override
    public boolean accept(Food food) {
        int percentWarehouse = 25;

        return paymentPercent(food) < percentWarehouse;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(foods);
    }
}
