package ru.job4j.design.lsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenAddCarToParkingThenReturnTrue() {
        Parking parking = new Parking(1, 1);
        Car car = new AudiCar("FC351");
        assertTrue(parking.add(car, 0));
    }

    @Test
    public void whenAddTwoCarsToParkingWhereOnlyOnePlaceForCarThenReturnFalse() {
        Parking parking = new Parking(1, 1);
        Car one = new AudiCar("FC351");
        Car second = new MazdaCar("TA144");
        assertTrue(parking.add(one, 0));
        assertFalse(parking.add(second, 1));
    }

    @Test
    public void whenAddTruckToParkingTruckPlaceThenReturnTrue() {
        Parking parking = new Parking(2, 1);
        Truck truck = new MercedesTruck(2,"BH143");
        assertTrue(parking.add(truck, 2));
    }

    @Test
    public void whenAddTruckToParkingCarPlacesThenReturnTrue() {
        Parking parking = new Parking(2, 1);
        Truck truck = new MercedesTruck(2, "BH143");
        assertTrue(parking.add(truck, 2));
    }

    @Test
    public void whenAddTwoTruckToParkingWhereTwoCarPlaceThenReturnTrue() {
        Parking parking = new Parking(2, 1);
        Truck one = new MercedesTruck(2, "BH143");
        Truck second = new VazTruck(2, "MN439");
        assertTrue(parking.add(one, 0));
        assertTrue(parking.add(second, 2));
    }

    @Test
    public void whenAddTwoTruckToParkingWhereOneCarPlaceThenReturnFalse() {
        Parking parking = new Parking(1, 1);
        Truck one = new MercedesTruck(2, "BH143");
        Truck second = new VazTruck(2, "MN439");
        assertTrue(parking.add(one, 1));
        assertFalse(parking.add(second, 0));
    }

    @Test
    public void whenAddTruckAndCarToParkingWhereNotInRowThenReturnFalse() {
        Parking parking = new Parking(3, 0);
        Truck truck = new MercedesTruck(2, "BH143");
        Car car = new AudiCar("FC351");
        assertTrue(parking.add(car, 1));
        assertFalse(parking.add(truck, 0));
    }
}
