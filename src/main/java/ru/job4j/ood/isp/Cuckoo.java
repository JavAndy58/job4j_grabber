package ru.job4j.ood.isp;

public class Cuckoo implements Bird {
    @Override
    public void shout() {
        System.out.println("Bird screaming");
    }

    @Override
    public void fly() {
        System.out.println("Bird flying");
    }
}
