package ru.job4j.tracker;

import java.awt.*;

public class StartUI {

    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FIND_BY_ID = 4;
    private static final int FIND_BY_NAME = 5;
    private static final int EXIT = 6;
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Введите пункт меню:")));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
        /*
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            int ask = Integer.parseInt(this.input.ask("\nВведите пункт меню: "));
            switch (ask) {
                case ADD:
                    createItem();
                    break;
                case SHOW:
                    showItems();
                    break;
                case EDIT:
                    replaceItem();
                    break;
                case DELETE:
                    deleteItem();
                    break;
                case FIND_BY_ID:
                    showItemById();
                    break;
                case FIND_BY_NAME:
                    showItemByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Введите корректный номер пункта меню");
            }
        }
        System.out.println("---------Выход---------");
    }

    private void createItem() {
        System.out.println("---------Добавление новой заявки---------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("---------Новая заявка с getid : " + item.getId() + " ---------");
    }

    private void showItems() {
        System.out.println("---------Заявки---------");
        for (Item item : this.tracker.getAll()) {
            System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        }
    }

    private void replaceItem() {
        String id = this.input.ask("Введите ID заявки для редактирования :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        String answer = "---------Заявка с таким ID не найдена---------";
        if (this.tracker.replace(id, item)) {
            answer = "---------Заявка с getid : " + item.getId() + " успешно отредактирована---------";
        }
        System.out.println(answer);
    }

    private void deleteItem() {
        String id = this.input.ask("Введите ID заявки для удаления :");
        String answer = "---------Заявка с таким ID не найдена---------";
        if (this.tracker.delete(id)) {
            answer = "---------Заявка с getid : " + id + " успешно удалена---------";
        }
        System.out.println(answer);
    }

    private void showItemById() {
        String id = this.input.ask("Введите ID заявки для поиска :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
        } else {
            System.out.println("Заявка с таким ID не найдена");
        }
    }

    private void showItemByName() {
        String name = this.input.ask("Введите имя заявки для поиска :");
        Item[] items = this.tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println("Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId());
            }
        } else {
            System.out.println("Заявки с таким именем не найдено");
        }
    }

    private void showMenu() {
        System.out.println("\nМеню.");
        System.out.println("0. Добавить заявку.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Искать по ID.");
        System.out.println("5. Искать по имени.");
        System.out.println("6. Выйти.");
    }
    */
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
