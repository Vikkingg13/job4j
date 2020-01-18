package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name, Consumer<String> output) {
       super(key, name, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        String id = input.ask("Введите ID заявки для удаления :");
        String answer = "---------Заявка с таким ID не найдена---------";
        if (tracker.delete(id)) {
            answer = "---------Заявка с getid : " + id + " успешно удалена---------";
        }
        output.accept(answer);
    }

}
