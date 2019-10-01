package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public int getActionsLength() {
        return actions.size();
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Добавить заявку.", this.output));
        this.actions.add(new ShowItems(1, "Показать все заявки.", this.output));
        this.actions.add(new EditItem(2, "Редактировать заявку.", this.output));
        this.actions.add(new DeleteItem(3, "Удалить заявку.", this.output));
        this.actions.add(new FindById(4, "Искать по ID.", this.output));
        this.actions.add(new FindByName(5, "Искать по имени.", this.output));
        this.actions.add(new ExitProgram(6, "Выйти.", ui, this.output));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        output.accept("\nМеню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}
