package ru.job4j.design.lsp;

import java.util.List;

public class ControllQuality {

    private List<Storage> storage = List.of(Warehouse.getInstance(), Shop.getInstance(), Trash.getInstance());

    public void distribute(Food food) {
        for (Storage store : storage) {
            if (store.add(food)) {
                break;
            }
        }
    }
}
