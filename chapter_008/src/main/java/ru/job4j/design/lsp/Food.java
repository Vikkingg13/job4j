package ru.job4j.design.lsp;

import java.util.Calendar;
import java.util.Date;

public abstract class Food {

    private String name;
    private Date createDate;
    private Date expiredDate;
    private double price;
    private int discount;

    public Food(String name, Date createDate, Date expiredDate, double price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiredDate = expiredDate;
        this.price = price;
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public abstract void setDiscount();
}
