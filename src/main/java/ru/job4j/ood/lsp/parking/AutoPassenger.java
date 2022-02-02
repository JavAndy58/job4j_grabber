package ru.job4j.ood.lsp.parking;

public class AutoPassenger implements Auto {

    private String name;
    private int size;

    public AutoPassenger(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
