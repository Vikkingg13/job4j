package ru.job4j.tracker;

import java.util.ArrayList;

public interface Input {

    String ask(String text);
    int ask(String text, ArrayList<Integer> range);
}
