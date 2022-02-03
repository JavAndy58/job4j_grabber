package ru.job4j.ood.isp;

public class Penguin implements Bird {
    @Override
    public void shout() {
        System.out.println("Bird screaming");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}
