package ru.job4j.design.lsp;

public class Parking {

    private CarPlace[] carPlaces;
    private TruckPlace[] truckPlaces;

    public Parking(int carSize, int truckSize) {
        carPlaces = new CarPlace[carSize];
        truckPlaces = new TruckPlace[truckSize];
        for (int i = 0; i < carSize; i++) {
            carPlaces[i] = new CarPlace();
        }
        for (int i = 0; i < truckSize; i++) {
            truckPlaces[i] = new TruckPlace();
        }
    }

    public boolean add(Car car, int pos) {
        boolean result = false;
        if (pos < carPlaces.length && carPlaces[pos].isFree()) {
            carPlaces[pos].add(car);
            result = true;
        }
        return result;
    }

    public boolean add(Truck truck, int pos) {
        boolean result = false;
        int endPos = pos + truck.size() - 1;
        if (endPos < carPlaces.length && isFreePlaces(pos, endPos)) {
            while (pos < endPos) {
                carPlaces[pos].add(truck);
                pos++;
            }
            result = true;
        } else if (pos >= carPlaces.length && truckPlaces[carPlaces.length - pos].isFree()) {
            truckPlaces[carPlaces.length - pos].add(truck);
            result = true;
        }
        return result;
    }

    private boolean isFreePlaces(int beginPos, int endPos) {
        boolean result = true;
        while (beginPos <= endPos) {
            if (!carPlaces[beginPos].isFree()) {
                result = false;
                break;
            }
            beginPos++;
        }
        return result;
    }
}
