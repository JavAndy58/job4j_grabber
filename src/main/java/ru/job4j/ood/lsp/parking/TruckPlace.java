package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class TruckPlace implements Place {
    private List<Place> places;

    public TruckPlace(List<Place> places) {
        this.places = places;
    }

    @Override
    public boolean decrease(Auto auto) {
        return false;
    }

    @Override
    public boolean accept(Auto auto) {
        return false;
    }
}
