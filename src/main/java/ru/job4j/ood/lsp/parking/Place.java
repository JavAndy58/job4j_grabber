package ru.job4j.ood.lsp.parking;

public interface Place {
    boolean decrease(Auto auto);
    boolean accept(Auto auto);

}
