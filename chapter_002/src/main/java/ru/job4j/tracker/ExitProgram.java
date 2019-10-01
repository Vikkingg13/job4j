package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {
    private final StartUI ui;

    public ExitProgram(int key, String name, StartUI ui, Consumer<String> output) {
        super(key, name, output);
        this.ui = ui;
    }

    public void execute(Input input, Tracker tracker) {
        output.accept("---------Выход---------");
        this.ui.stop();
    }

}
