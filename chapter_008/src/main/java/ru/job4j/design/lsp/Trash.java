package ru.job4j.design.lsp;

public class Trash extends Storage {

    private static Trash instance = new Trash();

    public static Trash getInstance() {
        return instance;
    }
}
