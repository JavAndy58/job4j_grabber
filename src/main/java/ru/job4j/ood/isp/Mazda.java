package ru.job4j.ood.isp;

public class Mazda implements Auto {
    @Override
    public void drive() {
        System.out.println("Auto drive");
    }

    @Override
    public void signal() {
        System.out.println("Auto signal");
    }

    @Override
    public void fire() {
        throw new UnsupportedOperationException();
    }
}
