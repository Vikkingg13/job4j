package ru.job4j.design.lsp;

public class Trash extends Storage {

    private static Trash trash = new Trash();

    private Trash() {
    }

    public static Trash getInstance() {
        return trash;
    }

    @Override
    public boolean add(Food food) {
        return super.add(food);
    }
}
