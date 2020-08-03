package ru.job4j.design.lsp;

public class MercedesTruck implements Truck {

    private final int size;
    private final String number;

    public MercedesTruck(int size, String number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String number() {
        return number;
    }
}
