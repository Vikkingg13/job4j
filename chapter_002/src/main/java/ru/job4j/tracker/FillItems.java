package ru.job4j.tracker;

import java.util.function.Consumer;

public class FillItems extends BaseAction {

    public FillItems(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        String string = input.ask("Введите необходимое количество заявок :");
        int count = Integer.parseInt(string);
        int i;
        for (i = 0; i < count; i++) {
            tracker.add(new Item("item", "" + i));
        }
        output.accept("Создано " + i + " заявок.");

    }
}
