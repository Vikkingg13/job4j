package ru.job4j.oop;

public class Battery {
    private int value;

    public Battery(int size) {
        this.value = size;
    }

    public void exchange(Battery another) {
        another.value += this.value;
        this.value = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(15);
        Battery second = new Battery(7);
        System.out.println("first battery: " + first.value + " second: " + second.value);
        first.exchange(second);
        System.out.print("first battery: " + first.value + " second: " + second.value);
    }

}
