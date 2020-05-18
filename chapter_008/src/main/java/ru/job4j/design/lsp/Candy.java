package ru.job4j.design.lsp;

import java.util.Calendar;
import java.util.Date;

public class Candy extends Food {

    public Candy(String name, Date createDate, Date expiredDate, double price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }

    @Override
    public void setDiscount() {
        setDiscount(60);
    }
}
