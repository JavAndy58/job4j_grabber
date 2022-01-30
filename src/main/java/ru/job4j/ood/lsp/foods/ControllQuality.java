package ru.job4j.ood.lsp.foods;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllQuality {

    private Storage storage;
    private Food food;
    private Calendar currentData = new GregorianCalendar(2022, 00, 31);
    private final int percentWarehouse = 25;
    private final int percentShop = 75;
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
        } else {
            storage = new Trash();
            storage.add(food);
        }
    }

    public double paymentPercent(Food food) {
        return ((double) (currentData.getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                / (food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis())) * translationPercent;

    }

    public static void main(String[] args) {
        Food food = new Food("carror", new GregorianCalendar(2022, 01, 27),
                new GregorianCalendar(2022, 00, 01), 100, 0);
        ControllQuality controllQuality = new ControllQuality();
        System.out.println(controllQuality.paymentPercent(food));



    }
}
