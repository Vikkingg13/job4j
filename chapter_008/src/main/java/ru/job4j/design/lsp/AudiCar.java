package ru.job4j.design.lsp;

public class AudiCar implements Car {

    private static final int size = 1;
    private String number;

    public AudiCar(String number) {
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
