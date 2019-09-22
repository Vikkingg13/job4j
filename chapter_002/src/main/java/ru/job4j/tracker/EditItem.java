package ru.job4j.tracker;

public class EditItem extends BaseAction{

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки для редактирования :");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        String answer = "---------Заявка с таким ID не найдена---------";
        if (tracker.replace(id, item)) {
            answer = "---------Заявка с getid : " + item.getId() + " успешно отредактирована---------";
        }
        System.out.println(answer);
    }
}
