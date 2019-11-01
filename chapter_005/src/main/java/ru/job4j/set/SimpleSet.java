package ru.job4j.set;

import ru.job4j.list.SimpleList;

import java.util.Iterator;

public class SimpleSet<T> {

    private SimpleList<T> list = new SimpleList<>(10);

    public  void  add(T value) {
        if (value != null && isUnique(value)) {
            list.add(value);
        }
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    private boolean isUnique(T value) {
        boolean result = true;
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()) {
            T element = iterator.next();
            if (element.hashCode() == value.hashCode() && element.equals(value)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
