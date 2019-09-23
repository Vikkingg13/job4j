package ru.job4j.comparator;

import java.util.*;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        for (int index = 0; index < size; index++) {
            result = Character.compare(left.toCharArray()[index], right.toCharArray()[index]);
            if (result != 0) {
                break;
            }
        }
        return result != 0 ? result : Integer.compare(left.length(), right.length());
    }
}