package ru.job4j.tracker;

public class AddItem implements UserAction {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------Добавление новой заявки---------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("---------Новая заявка с getid : " + item.getId() + " ---------");
    }

    @Override
    public String info() {
        return "0. Добавить заявку.";
    }
}
