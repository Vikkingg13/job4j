package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> base;
    private SimpleStack<T> reverse;

    public SimpleQueue() {
        this.base = new SimpleStack<>();
        this.reverse = new SimpleStack<>();
    }

    public T poll() {
        while (base.getSize() > 0) {
            reverse.push(base.poll());
        }
        return reverse.poll();
    }

    public void push(T value) {
        base.push(value);
    }
}
