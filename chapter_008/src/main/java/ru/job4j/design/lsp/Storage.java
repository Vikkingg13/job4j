package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {

    private List<Food> list = new ArrayList<>();

    public boolean add(Food food) {
        return list.add(food);
    }

    public List<Food> getFoods() {
        return list;
    }
}
