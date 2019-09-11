package ru.job4j.tracker;

import java.awt.*;
import java.util.ArrayList;

public class StartUI {

    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FIND_BY_ID = 4;
    private static final int FIND_BY_NAME = 5;
    private static final int EXIT = 6;
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(this.input.ask("Введите пункт меню:", range));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
