package ru.job4j.ood.lsp.foods;

import java.util.*;

public class ControllQuality {

    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void moving(Food food) {
        for (Storage stor : storages) {
            if (stor.accept(food)) {
                stor.add(food);
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            List<Food> foodsTemp = storage.get();
            foods.addAll(foodsTemp);
        }
        for (Food food : foods) {
            moving(food);
        }
    }

    public List<Storage> getStorages() {
        return new ArrayList<>(storages);
    }
}
