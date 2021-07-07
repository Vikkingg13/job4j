package ru.job4j.gc;

public class GCTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new User(1234 + i, "Max", "4321");
            new User(5678 + i, "Viktor", "8765");
            new User(91011 + i, "Maria", "12131");
        }
    }
}
