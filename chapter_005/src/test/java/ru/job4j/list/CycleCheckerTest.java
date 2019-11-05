package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CycleCheckerTest {
    @Test
    public void whenLinkedListNotClosedThenReturnFalse() {
        CycleChecker checker = new CycleChecker();
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        boolean expected = checker.hasCycle(first);
        assertThat(expected, is(false));
    }

    @Test
    public void whenLinkedListHClosedThenReturnTrue() {
        CycleChecker checker = new CycleChecker();
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(first);
        boolean expected = checker.hasCycle(first);
        assertThat(expected, is(true));
    }

    @Test
    public void whenLinkedListClosedInCenterThenReturnTrue() {
        CycleChecker checker = new CycleChecker();
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(second);
        boolean expected = checker.hasCycle(first);
        assertThat(expected, is(true));
    }
}
