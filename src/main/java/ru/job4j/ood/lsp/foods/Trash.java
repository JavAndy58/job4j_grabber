package ru.job4j.ood.lsp.foods;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> get() {
        return foods;
    }
}
