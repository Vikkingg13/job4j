package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindById extends BaseAction {

    public FindById(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        String id = input.ask("Введите ID заявки для поиска :");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        } else {
            output.accept("Заявка с таким ID не найдена");
        }
    }
}
