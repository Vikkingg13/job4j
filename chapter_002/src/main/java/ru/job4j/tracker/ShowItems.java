package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------Заявки---------");
        for (Item item : tracker.getAll()) {
            System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        }
    }
}
