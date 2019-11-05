package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {
    @Test
    public void whenArrayHasElementSearchingThenReturnIndexOfElement() {
        BinarySearch searcher = new BinarySearch();
        int [] array = {1, 4, 7, 11, 34, 39, 42, 55, 56, 58, 71};
        int expected = searcher.search(array, 55);
        assertThat(expected, is(7));
    }

    @Test
    public void whenArrayHasElementSearchingThenReturnMenusOne() {
        BinarySearch searcher = new BinarySearch();
        int [] array = {1, 4, 7, 11, 34, 39, 42, 55, 56, 58, 71};
        int expected = searcher.search(array, 3);
        assertThat(expected, is(-1));
    }
}
