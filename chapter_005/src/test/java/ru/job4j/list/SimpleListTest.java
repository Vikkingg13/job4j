package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleListTest {
    @Test
    public void whenAddElementInFullArrayThenNewSizeArray() {
        SimpleList<Integer> array = new SimpleList<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenArrayModifiedThenCurrentIteratorDropException() {
        SimpleList<Integer> array = new SimpleList<>(10);
        array.add(1);
        Iterator<Integer> iterator = array.iterator();
        array.add(2);
        iterator.next();
    }
}
