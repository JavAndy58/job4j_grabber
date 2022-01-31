package ru.job4j.ood.lsp.foods;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllQuality {

    private Storage storage;
    private Calendar currentData = new GregorianCalendar(2022, Calendar.JANUARY, 31);
    private final int percentWarehouse = 25;
    private final int percentShop = 75;
    private final int percentTrash = 100;
    private final int translationPercent = 100;
    private final int discount = 15;

    void moving(Food food) {
        if (paymentPercent(food) < percentWarehouse) {
            storage = new Warehouse();
            storage.add(food);
        } else if (paymentPercent(food) > percentWarehouse && paymentPercent(food) < percentShop) {
            storage = new Shop();
            storage.add(food);
        } else if (paymentPercent(food) > percentShop) {
            storage = new Shop();
            food.setDiscount(discount);
            storage.add(food);
        } else if (paymentPercent(food) > percentTrash) {
            storage = new Trash();
            storage.add(food);
        }
    }

    public List<Food> getList() {
        return storage.get();
    }

    private double paymentPercent(Food food) {
        return ((double) (currentData.getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                / (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis())) * translationPercent;

    }
}
