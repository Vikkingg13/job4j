package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenAddElementInArray() {
        SimpleArray<Integer> array = new SimpleArray<>(4);
        array.add(5);
        assertThat(array.get(0), is(5));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInFullArrayThenDropException() {
        SimpleArray<Integer> array = new SimpleArray<>(0);
        array.add(1);
    }

    @Test
    public void whenReplaceValueInArray() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(1);
        array.set(0, 2);
        assertThat(array.get(0), is(2));
    }

    @Test
    public void whenRemoveElementByIndex() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(0);
        assertThat(array.get(1), is(3));
    }

    @Test
    public void whenGetIteratorForArray() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(5);
        array.add(10);
        array.add(20);
        Iterator<Integer> iterator = array.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(10));
        assertThat(iterator.next(), is(20));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIteratorNotHaveNextElementsThenDropException() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(100);
        Iterator<Integer> iterator = array.iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenElementsTypeIsString() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("C++ is hardcore");
        array.add("Java is best");
        array.add("Pascal forever");
        assertThat(array.get(2), is("Pascal forever"));
    }
}
