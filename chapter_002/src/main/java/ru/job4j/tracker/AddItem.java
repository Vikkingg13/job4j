package ru.job4j.tracker;

import java.util.function.Consumer;

public class AddItem extends BaseAction {

    public AddItem(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("---------Добавление новой заявки---------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = tracker.add(new Item(name, desc));
        output.accept("---------Новая заявка с getid : " + item.getId() + " ---------");
    }
}
