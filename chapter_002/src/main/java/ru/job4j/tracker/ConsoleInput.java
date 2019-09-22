package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    public int ask(String text, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(text));
        boolean exist = false;
        for (int value : range) {
            if (key == value) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
