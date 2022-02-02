package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private int placeAutoPassenger;
    private int placeAutoTruck;

    private List<Auto> autoPassenger = new ArrayList<>();
    private List<Auto> autoTruck = new ArrayList<>();


    public Parking(int placeAutoPassenger, int placeAutoTruck) {
        this.placeAutoPassenger = placeAutoPassenger;
        this.placeAutoTruck = placeAutoTruck;
    }

    public boolean addAuto(Auto auto) {
        boolean shouldAddAuto = false;
        if (auto.getSize() == 1 && placeAutoPassenger != 0) {
            placeAutoPassenger -= 1;
            shouldAddAuto = autoPassenger.add(auto);
        }
        if (auto.getSize() > 1 && placeAutoTruck == 0) {
            placeAutoPassenger -= auto.getSize();
            shouldAddAuto = autoPassenger.add(auto);
        }
        if (auto.getSize() > 1 && placeAutoTruck != 0) {
            placeAutoTruck -= 1;
            shouldAddAuto = autoTruck.add(auto);
        }
        if (placeAutoPassenger < 0 || placeAutoTruck < 0) {
            shouldAddAuto = false;
        }
        return shouldAddAuto;
    }
}
