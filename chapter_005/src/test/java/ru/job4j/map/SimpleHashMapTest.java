package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    @Test
    public void whenInsertEntryThenGetByKeyReturnValue() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Alex", 23);
        assertThat(map.get("Alex"), is(23));
    }

    @Test
    public void whenInsertEntryWithCollisionTheInsertReturnFalse() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Alex", 23);
        assertThat(map.insert("Alex", 41), is(false));
    }

    @Test
    public void whenDeleteEntryThenReturnTrue() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Alex", 23);
        assertThat(map.delete("Alex"), is(true));
    }

    @Test
    public void whenDeleteNotExistEntryThenReturnFalse() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Alex", 23);
        assertThat(map.delete("Vova"), is(false));
    }

    @Test
    public void testIteratorForSimpleHashMap() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Alex", 23);
        map.insert("Viktor", 25);
        map.insert("Wolter", 40);
        map.insert("Kadzima", 14);
        Iterator<Integer> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(23));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(14));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(25));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(40));
        assertThat(iterator.hasNext(), is(false));
    }

}
