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

    public int ask(String text, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(text));
        boolean exist = false;
        for (int value : range) {
            if (key == value) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
