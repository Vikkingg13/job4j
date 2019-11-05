package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BaseLinkedListTest {
    @Test
    public void whenAddElementThen() {
        BaseLinkedList<Integer> list = new BaseLinkedList<>();
        list.add(5);
        assertThat(list.get(0), is(5));
        list.add(7);
        assertThat(list.get(1), is(7));
        list.add(3);
        assertThat(list.get(2), is(3));
    }

    @Test
    public void testIteratorForLinkedList() {
        BaseLinkedList<Integer> list = new BaseLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNextElementNonexistentThenNextShouldReturnException() {
        BaseLinkedList<Integer> list = new BaseLinkedList<>();
        list.iterator().next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenListModifiedAfterCreationIteratorThenNextShouldDropException() {
        BaseLinkedList<String> list = new BaseLinkedList<>();
        Iterator<String> iterator = list.iterator();
        list.add("I search");
        iterator.next();
    }
}