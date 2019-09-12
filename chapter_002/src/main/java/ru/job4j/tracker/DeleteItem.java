package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
       super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки для удаления :");
        String answer = "---------Заявка с таким ID не найдена---------";
        if (tracker.delete(id)) {
            answer = "---------Заявка с getid : " + id + " успешно удалена---------";
        }
        System.out.println(answer);
    }

}
