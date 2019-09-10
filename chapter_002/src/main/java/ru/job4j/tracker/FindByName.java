package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки для поиска :");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
            }
        } else {
            System.out.println("Заявки с таким именем не найдено");
        }
    }

    @Override
    public String info() {
       return "5. Искать по имени.";
    }
}
