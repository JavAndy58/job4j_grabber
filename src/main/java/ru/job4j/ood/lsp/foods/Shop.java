package ru.job4j.ood.lsp.foods;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> foods = new ArrayList<>();
    private final int percentWarehouse = 25;
    private final int percentShop = 75;
    private final int discount = 15;

    @Override
    public boolean add(Food food) {
        if (paymentPercent(food) > percentShop) {
            food.setDiscount(discount);
        }
        return foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return paymentPercent(food) > percentWarehouse && paymentPercent(food) < percentShop;
    }

    @Override
    public List<Food> get() {
        return foods;
    }
}
