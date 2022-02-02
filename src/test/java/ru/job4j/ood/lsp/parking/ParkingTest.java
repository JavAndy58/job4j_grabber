package ru.job4j.ood.lsp.parking;

import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ParkingTest {
    @Test
    public void whenTwoPassengerOneTruckTrue() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoPassenger("Lada");
        Auto auto2 = new AutoPassenger("Mazda");
        Auto auto3 = new AutoTruck("Kamaz", 2);
        parking.addAuto(auto1);
        parking.addAuto(auto2);
        assertTrue(parking.addAuto(auto3));
    }

    @Test
    public void whenTwoTruckTrue() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoTruck("Kamaz", 2);
        Auto auto2 = new AutoTruck("Maz", 2);
        parking.addAuto(auto1);
        assertTrue(parking.addAuto(auto2));
    }

    @Test
    public void whenTwoTruckFalse() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoTruck("Kamaz", 2);
        Auto auto2 = new AutoTruck("Maz", 3);
        parking.addAuto(auto1);
        assertFalse(parking.addAuto(auto2));
    }

    @Test
    public void whenThreePassenger() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoPassenger("Lada");
        Auto auto2 = new AutoPassenger("Mazda");
        Auto auto3 = new AutoPassenger("Oka");
        parking.addAuto(auto1);
        parking.addAuto(auto2);
        assertFalse(parking.addAuto(auto3));
    }
}
