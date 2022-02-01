package ru.job4j.ood.lsp.foods;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        int percentTrash = 100;

        return paymentPercent(food) > percentTrash;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(foods);
    }
}
