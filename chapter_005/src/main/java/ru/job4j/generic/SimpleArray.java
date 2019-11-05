package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] array;
    private int position = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    public void add(T model) {
        this.array[position++] = model;
    }

    public void set(int index, T model) {
        this.array[index] = model;
    }

    public void remove(int index) {
        int pos = index + 1;
        System.arraycopy(this.array, pos, this.array, index, this.position - pos);
        this.position--;
    }

    public int indexOf(T model) {
        int result = -1;
        int index = 0;
        for (Object obj : this.array) {
            if (model.equals(obj)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

    @SuppressWarnings ("unchecked")
    public T get(int index) {
        return (T) this.array[index];
    }

    @SuppressWarnings ("unchecked")
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int pos = 0;
            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[pos++];
            }

            @Override
            public boolean hasNext() {
               return position > pos;
            }
        };
    }
}