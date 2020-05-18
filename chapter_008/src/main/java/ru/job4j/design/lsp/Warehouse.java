package ru.job4j.design.lsp;

public class Warehouse extends Storage {

    private static Warehouse instance = new Warehouse();

    public static Warehouse getInstance() {
        return instance;
    }
}
