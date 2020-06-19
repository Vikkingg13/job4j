package ru.job4j.design.lsp;

/**
 * ParkingPlace interface for implementing classes of specific place type.
 *
 * @author Viktor Grigoriev
 */
public interface ParkingPlace<T extends Vehicle> {

    /**
     * Adding vehicles to place.
     *
     * @param vehicle for add to place
     * @return true if added else false
     */
    boolean add(T vehicle);

    /**
     * Check free place.
     *
     * @return true if place free else false
     */
    boolean isFree();
}
