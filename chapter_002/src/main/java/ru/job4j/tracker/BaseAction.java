package ru.job4j.tracker;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;
    protected final Consumer<String> output;

    public BaseAction(int key, String name, Consumer<String> output) {
        this.key = key;
        this.name = name;
        this.output = output;
    }

    public int key() {
        return this.key;
    }

    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }

}
