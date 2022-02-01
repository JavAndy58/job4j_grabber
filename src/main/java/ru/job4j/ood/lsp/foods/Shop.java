package ru.job4j.ood.lsp.foods;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        int percentShop = 75;
        int discount = 15;

        if (paymentPercent(food) > percentShop) {
            food.setDiscount(discount);
        }
        return foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        int percentWarehouse = 25;

        return paymentPercent(food) > percentWarehouse && paymentPercent(food) < 100;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(foods);
    }
}
