package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByName extends BaseAction {

    public FindByName(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки для поиска :");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                output.accept("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
            }
        } else {
            output.accept("Заявки с таким именем не найдено");
        }
    }
}
