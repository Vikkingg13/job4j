package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeTest {
    @Test
    public void when6ElementFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void whenAddDuplicateElementThenShouldReturnFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.add(1, 3), is(true));
        assertThat(tree.add(1, 2), is(false));
    }

    @Test
    public void when6ElementFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void testsIteratorForTree() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 5);
        tree.add(4, 7);
        tree.add(5, 8);
        tree.add(1, 6);
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.hasNext(), is(false));

    }
}
