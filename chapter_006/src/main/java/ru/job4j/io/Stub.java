package ru.job4j.io;

public class Stub implements Input {

    private String[] values;
    private int position;

    public Stub(String[] values) {
        this.values = values;
    }

    public String write() {
        String value = values[position++];
        System.out.println(value);
        return value;
    }
}
