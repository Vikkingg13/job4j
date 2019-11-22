package ru.job4j.map;

import java.util.*;

public class SimpleHashMap<K, V>  implements Iterable<V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int modCount = 0;
    private int count = 0;
    private Map.Entry[] table = new Map.Entry[16];

    public boolean insert(K key, V value) {
        boolean result = false;
        int index = indexFor(hash(key));
        if (table[index] == null) {
            if ((float) count / table.length >= LOAD_FACTOR) {
                table = Arrays.copyOf(table, table.length * 2);
            }
            table[index] = Map.entry(key, value);
            result = true;
            count++;
            modCount++;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        V result = null;
        int index = indexFor(hash(key));
        if (table[index] != null && key.equals(table[index].getKey())) {
            result = (V) table[index].getValue();
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = indexFor(hash(key));
        if (table[index] != null && key.equals(table[index].getKey())) {
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    public Iterator<V> iterator() {
        return new Iterator<>() {

            private int expectedModCount = modCount;
            private int current = 0;
            private int position = 0;

            @Override
            public boolean hasNext() {
                return current < count;
            }

            @Override
            @SuppressWarnings("unchecked")
            public V next() throws NoSuchElementException, ConcurrentModificationException {
                V result = null;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (position < table.length) {
                    if (table[position] != null) {
                        result = (V) table[position++].getValue();
                        this.current++;
                        break;
                    }
                    position++;
                }
                return result;
            }
        };
    }

    private int hash(K key) {
        int h = key.hashCode();
        return key == null ? 0 : h ^ h >>> 16;
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }
}