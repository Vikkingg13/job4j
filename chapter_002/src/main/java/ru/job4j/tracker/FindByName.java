package ru.job4j.tracker;

import java.util.List;

public class FindByName extends BaseAction {

    public FindByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки для поиска :");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
            }
        } else {
            System.out.println("Заявки с таким именем не найдено");
        }
    }
}
