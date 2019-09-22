package ru.job4j.tracker;

public class ExitProgram extends BaseAction {
    private final StartUI ui;

    public ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("---------Выход---------");
        this.ui.stop();
    }

}
