package ru.job4j.tracker;

import java.util.ArrayList;

public class StubInput implements Input {

    private final String[] value;
    private int position;

    public StubInput(String[] value) {
        this.value = value;
    }

    public String ask(String text) {
        return this.value[position++];
    }

    public int ask(String text, ArrayList range) {
        return Integer.valueOf(this.ask(text));
    }
}
