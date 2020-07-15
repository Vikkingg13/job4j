package ru.job4j.design.lsp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParkingTest {

    @Test
    public void whenAddCarToParkingThenReturnTrue() {
        Parking parking = new Parking(1, 1);
        Car car = new AudiCar("FC351");
        assertEquals(parking.add(car, 0), true);
    }

    @Test
    public void whenAddTwoCarsToParkingWhereOnlyOnePlaceForCarThenReturnFalse() {
        Paking parking = new Parking(1, 1);
        Car one = new AudiCar("FC351");
        Car second = new MazdaCar("TA144");
        assertEquals(parking.add(one, 0), true);
        assertEquals(parking.add(second, 1), false);
    }

    @Test
    public void whenAddTruckToParkingTruckPlaceThenReturnTrue() {
        Paking parking = new Parking(2, 1);
        Truck truck = new MercedezTruck(2,"BH143");
        assertEquals(parking.add(truck, 2), true);
    }

    @Test
    public void whenAddTruckToParkingCarPlacesThenReturnTrue() {
        Paking parking = new Parking(2, 1);
        Truck truck = new MercedezTruck(2, "BH143");
        assertEquals(parking.add(truck, 0), true);
    }

    @Test
    public void whenAddTwoTruckToParkingWhereTwoCarPlaceThenReturnTrue() {
        Paking parking = new Parking(2, 1);
        Truck one = new MercedesTruck(2, "BH143");
        Truck second = new VazTruck(2, "MN439");
        assertEquals(parking.add(one, 0), true);
        assertEquals(parking.add(second, 2), true);
    }

    @Test
    public void whenAddTwoTruckToParkingWhereOneCarPlaceThenReturnFalse() {
        Paking parking = new Parking(1, 1);
        Truck one = new MercedesTruck(2, "BH143");
        Truck second = new VazTruck(2, "MN439");
        assertEquals(parking.add(one, 1), true);
        assertEquals(parking.add(second, 0), false);
    }

    @Test
    public void whenAddTruckAndCarToParkingWhereNotInRowThenReturnFalse() {
        Paking parking = new Parking(3, 0);
        Truck truck = new MercedesTruck(2, "BH143");
        Car car = new AudiCar("FC351");
        assertEquals(parking.add(car, 1), true);
        assertEquals(parking.add(truck, 0), false);
    }
}
