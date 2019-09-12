package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLength() {
        return actions.size();
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Добавить заявку."));
        this.actions.add(new ShowItems(1, "Показать все заявки."));
        this.actions.add(new EditItem(2, "Редактировать заявку."));
        this.actions.add(new DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindById(4, "Искать по ID."));
        this.actions.add(new FindByName(5, "Искать по имени."));
        this.actions.add(new ExitProgram(6, "Выйти.", ui));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("\nМеню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
