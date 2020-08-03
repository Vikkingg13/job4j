package ru.job4j.design.lsp;

public class CarPlace implements ParkingPlace<Vehicle> {

    private Vehicle vehicle;

    @Override
    public void add(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean isFree() {
        return vehicle == null;
    }
}
