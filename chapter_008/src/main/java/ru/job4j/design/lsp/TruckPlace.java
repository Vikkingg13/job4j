package ru.job4j.design.lsp;

public class TruckPlace implements ParkingPlace<Truck> {

    private Truck truck;

    @Override
    public void add(Truck vehicle) {
        truck = vehicle;
    }

    @Override
    public boolean isFree() {
        return truck == null;
    }
}
