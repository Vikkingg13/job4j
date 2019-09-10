package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public int key() {
        return 4;
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

    @Override
    public String info() {
        return "4. Искать по ID.";
    }
}
