package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }
}
