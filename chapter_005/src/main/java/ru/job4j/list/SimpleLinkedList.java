package ru.job4j.list;

public class SimpleLinkedList<E> {

    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete() {
        this.first = this.first.next;
        return this.first.data;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return  this.size;
    }

    private static class Node<E> {

        E data;

        Node(E data) {
            this.data = data;
        }

        Node<E> next;
    }
}
