package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractStore<T extends Base> implements Store<T>{

    private SimpleArray<T> array;

    public AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
    }

    public void add(T model) {
        this.array.add(model);
    }

    public boolean replace(String id, T model) {
        boolean result = true;
        try {
            int index = this.array.indexOf(this.findById(id));
            this.array.set(index, model);
        } catch (NullPointerException ex) {
            result = false;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = true;
        try {
            int index = this.array.indexOf(this.findById(id));
            this.array.remove(index);
        } catch (NullPointerException ex) {
            result = false;
        }
        return result;
    }

    public T findById(String id) {
        Iterator<T> iterator = this.array.iterator();
        T result = null;
        while(iterator.hasNext()) {
            T model = iterator.next();
            if (model.getId().equals(id)) {
                result = model;
                break;
            }
        }
        return result;
    }
}