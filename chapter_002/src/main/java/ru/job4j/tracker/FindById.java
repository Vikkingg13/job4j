package ru.job4j.tracker;

public class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки для поиска :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        } else {
            System.out.println("Заявка с таким ID не найдена");
        }
    }
}
