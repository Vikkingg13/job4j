package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    @Override
    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("---------Выход---------");
    }

    public String info() {
        return "6. Выйти.";
    }
}
