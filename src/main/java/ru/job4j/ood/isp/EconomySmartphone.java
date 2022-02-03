package ru.job4j.ood.isp;

public class EconomySmartphone implements Smartphone {
    @Override
    public void call() {
        System.out.println("Smartphone call");
    }

    @Override
    public void shootVideo() {
        throw new UnsupportedOperationException();
    }
}
