package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;
    private int position;

    public StubInput(String[] value) {
        this.value = value;
    }

    public String ask(String text) {
        return this.value[position++];
    }
}
