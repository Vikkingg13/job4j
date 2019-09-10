package ru.job4j.tracker;

public class ShowItems implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------Заявки---------");
        for (Item item : tracker.getAll()) {
            System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        }
    }

    @Override
    public String info() {
        return "1. Показать все заявки.";
    }
}
