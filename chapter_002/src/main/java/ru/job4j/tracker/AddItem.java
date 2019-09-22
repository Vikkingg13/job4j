package ru.job4j.tracker;

public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------Добавление новой заявки---------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = tracker.add(new Item(name, desc));
        System.out.println("---------Новая заявка с getid : " + item.getId() + " ---------");
    }
}
