package ru.job4j.design.lsp;

import java.util.Calendar;
import java.util.Date;

public class IceCream extends Food {

    public IceCream(String name, Date createDate, Date expiredDate, double price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }

    @Override
    public void setDiscount() {
        setDiscount(40);
    }
}
