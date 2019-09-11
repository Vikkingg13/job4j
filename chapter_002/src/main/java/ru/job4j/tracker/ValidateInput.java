package ru.job4j.tracker;

import java.util.ArrayList;

public class ValidateInput extends ConsoleInput {

    public int ask(String text, ArrayList<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(text, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter number");
            }
        } while (invalid);
        return value;
    }
}
