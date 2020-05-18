package ru.job4j.design.lsp;

import java.util.Date;

public class Cheese extends Food {

    public Cheese(String name, Date createDate, Date expiredDate, double price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }

    @Override
    public void setDiscount() {
        setDiscount(25);
    }
}
