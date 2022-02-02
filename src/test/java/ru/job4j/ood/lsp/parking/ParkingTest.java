package ru.job4j.ood.lsp.parking;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingTest {

    @Test
    public void whenTwoPassengerOneTruckTrue() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoPassenger("Lada", 1);
        Auto auto2 = new AutoPassenger("Mazda", 1);
        Auto auto3 = new AutoTruck("Kamaz", 2);
        parking.addAuto(auto1);
        parking.addAuto(auto2);
        assertThat(parking.addAuto(auto3), is(true));
    }

    @Test
    public void whenTwoTruckTrue() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoTruck("Kamaz", 2);
        Auto auto2 = new AutoTruck("Maz", 2);
        parking.addAuto(auto1);
        assertThat(parking.addAuto(auto2), is(true));
    }

    @Test
    public void whenTwoTruckFalse() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoTruck("Kamaz", 2);
        Auto auto2 = new AutoTruck("Maz", 3);
        parking.addAuto(auto1);
        assertThat(parking.addAuto(auto2), is(false));
    }

    @Test
    public void whenThreePassenger() {
        Parking parking = new Parking(2, 1);
        Auto auto1 = new AutoPassenger("Lada", 1);
        Auto auto2 = new AutoPassenger("Mazda", 1);
        Auto auto3 = new AutoPassenger("Oka", 1);
        parking.addAuto(auto1);
        parking.addAuto(auto2);
        assertThat(parking.addAuto(auto3), is(false));
    }










//    @Test
//    public void whenMovingWarehose() {
//        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
//        LocalDate today = LocalDate.now();
//        Food expected = new Food("milk", today.minusDays(5), today.plusDays(30), 100, 0);
//        controllQuality.moving(expected);
//        Food actual = controllQuality.getStorages().get(0).get().get(0);
//        assertThat(actual, is(expected));
//    }

}
