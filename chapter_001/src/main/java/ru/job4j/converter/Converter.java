package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result: " + passed);
        in = 180;
        expected = 3;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("180 rubles are 3. Test result: " + passed);
        int dollar = rubleToDollar(180);
        in = 3;
        expected = 210;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println("3 euro are 210. Test result: " + passed);
        in = 2;
        expected = 120;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println("2 dollars are 120. Test result: " + passed);

    }
}
