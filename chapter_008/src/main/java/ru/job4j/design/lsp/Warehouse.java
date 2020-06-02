package ru.job4j.design.lsp;

import java.util.Date;

public class Warehouse extends Storage {

    private static Warehouse warehouse = new Warehouse();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return warehouse;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        long period = food.getExpiredDate().getTime() - food.getCreateDate().getTime();
        Date top = new Date(food.getCreateDate().getTime() + period / 4);
        if (DateInfo.getDate().before(top)) {
            result = super.add(food);
        }
        return result;
    }
}
