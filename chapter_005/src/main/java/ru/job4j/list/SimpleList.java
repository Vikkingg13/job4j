package ru.job4j.list;

import java.util.*;

public class SimpleList<T> implements Iterable<T> {
    private Object[] container;
    private int modCount = 0;
    private int position = 0;

    public SimpleList(int size) {
        container = new Object[size];
    }

    public void add(T model) {
        if (position == this.container.length) {
            container = Arrays.copyOf(this.container, this.container.length * 2);
        }
        this.container[position++] = model;
        this.modCount++;
    }

    @SuppressWarnings ("unchecked")
    public T get(int index) {
        return (T) this.container[index];
    }

    @SuppressWarnings ("unchecked")
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int pos = 0;

            @Override
            public T next() throws NoSuchElementException, ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[pos++];
            }

            @Override
            public boolean hasNext() {
               return position > pos;
            }
        };
    }
}