package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] array;
    private int index = 0;

    public EvenIterator(final int[] array) {
        this.array = array;
    }

    public Integer next() throws NoSuchElementException {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No such element.");
        }
        this.index = getNext();
        return array[index++];
    }

    public boolean hasNext() {
        return getNext() != -1;
    }

    public int getNext() {
        int result = -1;
        for (int index = this.index; index != array.length; index++) {
            if (array[index] % 2 == 0) {
                result = index;
                break;
            }
        }
        return result;
    }
}