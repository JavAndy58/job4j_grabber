package ru.job4j.ood.lsp.parking;

public class Parking {
    private int placeAutoPassenger;
    private int placeAutoTruck;

    public Parking(int placeAutoPassenger, int placeAutoTruck) {
        this.placeAutoPassenger = placeAutoPassenger;
        this.placeAutoTruck = placeAutoTruck;
    }

    public boolean addAuto(Auto auto) {
        return true;
    }

}
