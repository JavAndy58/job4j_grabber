package ru.job4j.ood.lsp.foods;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> foods = new ArrayList<>();
    private final int percentTrash = 100;

    @Override
    public boolean add(Food food) {
        return foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return paymentPercent(food) > percentTrash;
    }

    @Override
    public List<Food> get() {
        return foods;
    }
}
