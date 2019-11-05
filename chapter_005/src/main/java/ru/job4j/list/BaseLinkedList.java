package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BaseLinkedList<E> implements Iterable<E> {

    private int modCount = 0;
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.prev = this.last;
            this.last.next = newNode;
            this.last = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Node<E> node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int position = 0;
            private int expectedModCount = modCount;

            public E next() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(position++);
            }

            public boolean hasNext() {
                return this.position < size;
            }
        };
    }

    private static class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }
}