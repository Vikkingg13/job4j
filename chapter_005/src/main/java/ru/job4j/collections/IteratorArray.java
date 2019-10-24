package ru.job4j.collections;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorArray implements Iterator<Integer> {

    private final int[][] array;
    private int rows = 0;
    private int cells = 0;

    public IteratorArray(final int[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return array.length > rows && array[rows].length > cells;
    }

    public Integer next() {
        int result = array[rows][cells];
        cells++;
        if (array[rows].length == cells) {
            cells = 0;
            rows++;
        }
        return result;
    }



}
