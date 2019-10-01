package ru.job4j.tracker;

import java.util.function.Consumer;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("---------Заявки---------");
        for (Item item : tracker.getAll()) {
            output.accept("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        }
    }
}
