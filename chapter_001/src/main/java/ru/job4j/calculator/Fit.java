package ru.job4j.calculator;

public class Fit {

    public static double manWeigth(double height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeigth(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeigth(170);
        System.out.println("Man 175 is " + man);
        double woman = womanWeigth(157);
        System.out.println("Woman 160 is " + woman);
    }
}
