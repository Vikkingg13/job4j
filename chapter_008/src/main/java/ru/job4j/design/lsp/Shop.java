package ru.job4j.design.lsp;

import java.util.Date;

public class Shop extends Storage {

    private static Shop shop = new Shop();

    private Shop() {
    }

    public static Shop getInstance() {
        return shop;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        long period = food.getExpiredDate().getTime() - food.getCreateDate().getTime();
        Date expiringDate = new Date(food.getCreateDate().getTime() + period - (period / 4));
        if (DateInfo.getDate().before(expiringDate)) {
           result = super.add(food);
        } else if (DateInfo.getDate().before(food.getExpiredDate())) {
            result = super.add(food);
            food.setDiscount();
        }
        return result;
    }
}
