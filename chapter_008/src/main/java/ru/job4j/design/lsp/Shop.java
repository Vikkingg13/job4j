package ru.job4j.design.lsp;

public class Shop extends Storage {

    private static Shop instance = new Shop();

    public static Shop getInstance() {
        return instance;
    }
}
