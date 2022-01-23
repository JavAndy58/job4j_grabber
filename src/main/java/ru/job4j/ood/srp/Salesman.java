package ru.job4j.ood.srp;

public class Salesman {
    void sale() {
        System.out.println("Я продаю");
    }
    void merchandising() {
        System.out.println("Я раскладываю товар");
    }
    Accounting accounting = new AccountingSalesman();
}
