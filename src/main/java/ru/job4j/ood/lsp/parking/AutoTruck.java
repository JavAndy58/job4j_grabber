package ru.job4j.ood.lsp.parking;

public class AutoTruck implements Auto {
    private String name;
    private int size;

    public AutoTruck(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
