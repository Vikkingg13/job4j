package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {
    @Test
    public void whenAddElementInFullArrayThenNewSizeArray() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenArrayModifiedThenCurrentIteratorDropException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.add(1);
        Iterator<Integer> iterator = array.iterator();
        array.add(2);
        iterator.next();
    }
}
