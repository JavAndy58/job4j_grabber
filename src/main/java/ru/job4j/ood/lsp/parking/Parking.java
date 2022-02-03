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

    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public boolean addAuto(Auto auto) {
        boolean shouldAddAuto = false;
        if (auto.getSize() == AutoPassenger.SIZE && placeAutoPassenger != 0) {
            placeAutoPassenger -= 1;
            shouldAddAuto = autoPassenger.add(auto);
        } else if ((shouldAddAuto != true) && auto.getSize() > AutoPassenger.SIZE && placeAutoTruck == 0) {
            placeAutoPassenger -= auto.getSize();
            if (placeAutoPassenger >= 0) {
                shouldAddAuto = autoPassenger.add(auto);
            }
        } else if ((shouldAddAuto != true) && auto.getSize() > AutoPassenger.SIZE && placeAutoTruck != 0) {
            placeAutoTruck -= 1;
            shouldAddAuto = autoTruck.add(auto);
        }
        return shouldAddAuto;
    }
}
