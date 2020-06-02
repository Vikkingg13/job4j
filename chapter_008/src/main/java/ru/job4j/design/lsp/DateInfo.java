package ru.job4j.design.lsp;

import java.util.Date;

public class DateInfo {

    private static Date date;

    public static void setDate(Date currentDate) {
        date = currentDate;
    }

    public static Date getDate() {
        return date;
    }
}
