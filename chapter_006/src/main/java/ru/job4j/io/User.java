package ru.job4j.io;

import java.util.Scanner;

public class User implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String write() {
        return scanner.nextLine();
    }
}
