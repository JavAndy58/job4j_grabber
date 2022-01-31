package ru.job4j.ood.lsp.foods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllQuality {

    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public Storage moving(Food food) {
        Storage storage;
        for (Storage storages : storages) {
            if (storage.accept(food)) {
                storage.add(food);
                return storage;
            }
        }
    }






    public static void main(String[] args) {
        ControllQuality controllQuality = new ControllQuality(Arrays.asList(new Warehouse(), new Shop(), new Trash()));

    }
}
