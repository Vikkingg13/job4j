package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int monthly, int percent) {
        int year = 0;
        int sum = amount + (amount / 100) * percent;
        int sumYear = monthly * 12;
        int paid = 0;
        while (paid < sum) {
            paid += sumYear;
            year++;
        }
        return year;
    }
}
