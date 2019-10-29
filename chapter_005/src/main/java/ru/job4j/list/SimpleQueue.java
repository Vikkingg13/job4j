package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> base = new SimpleStack<>();
    private SimpleStack<T> reverse = new SimpleStack<>();

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
