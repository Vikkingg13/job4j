package ru.job4j.list;

public class SimpleStack<T> {

    private BaseLinkedList<T> list = new BaseLinkedList<>();
    private int size = 0;

    public T poll() {
        int last = size - 1;
        T result = this.list.get(last);
        this.list.remove(last);
        size--;
        return result;
    }

    public void push(T value) {
        list.add(value);
        size++;
    }

    public int getSize() {
        return size;
    }
}