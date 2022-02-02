package ru.job4j.ood.lsp.parking;

public class AutoPassenger implements Auto {

    private String name;
    public static final int SIZE = 1;

    public AutoPassenger(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}
