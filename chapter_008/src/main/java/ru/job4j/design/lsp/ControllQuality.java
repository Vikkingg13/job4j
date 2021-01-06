package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Storage> storage = List.of(
            Warehouse.getInstance(),
            Shop.getInstance(),
            Trash.getInstance()
    );

    public void distribute(Food food) {
        for (Storage store : storage) {
            if (store.add(food)) {
                break;
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storage) {
            foods.addAll(storage.unload());
        }
        for (Food food : foods) {
            distribute(food);
        }
    }

    public void clearAll() {
        for (Storage storage : this.storage) {
            storage.clear();
        }
    }
}
