package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E>  {

    private final Node<E> root;
    private int modCount = 0;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> optional = findBy(parent);
        if (optional.isPresent() && child != null) {
            Node<E> node = optional.get();
            if (node.leaves().stream().noneMatch(e -> e.eqValue(child))) {
                node.add(new Node<>(child));
                result = true;
                modCount++;
            }
        }
        return result;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.leaves().size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int expectedModCount = modCount;
            private Queue<Node<E>> data = new LinkedList<>();
            private Node<E> element = root;

            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (Node<E> child : element.leaves()) {
                    data.offer(child);
                }
                E result = element.getValue();
                element = data.poll();
                return result;
            }

            public boolean hasNext() {
                return element != null;
            }
        };
    }
}