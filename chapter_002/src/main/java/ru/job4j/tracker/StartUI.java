package ru.job4j.tracker;

import java.awt.*;
import java.util.ArrayList;

public class StartUI {

    private boolean working = true;
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(this.input.ask("Введите пункт меню:", range));
        } while (working && !"y".equals(this.input.ask("Exit? (y): ")));
    }

    public void stop() {
        this.working = false;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
