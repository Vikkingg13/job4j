package ru.job4j.design.lsp;

public class MazdaCar implements Car {

    private final int size = 1;
    private final String number;

    public MazdaCar(String number) {
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
