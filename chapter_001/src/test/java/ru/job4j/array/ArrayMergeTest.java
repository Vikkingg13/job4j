package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayMergeTest {
    @Test
    public void when3And3() {
        ArrayMerge test = new ArrayMerge();
        int[] left = new int[]{1, 3, 4};
        int[] right = new int[]{2, 5, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        int[] result = test.merge(left,right);
        assertThat(result, is(expected));
    }
    @Test
    public void when3And5() {
        ArrayMerge test = new ArrayMerge();
        int[] left = new int[]{1, 3, 4};
        int[] right = new int[]{2, 5, 6, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = test.merge(left,right);
        assertThat(result, is(expected));
    }

    @Test
    public void when4And5() {
        ArrayMerge test = new ArrayMerge();
        int[] left = new int[]{1, 3, 4, 9};
        int[] right = new int[]{2, 5, 6, 7, 11};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 9, 11};
        int[] result = test.merge(left,right);
        assertThat(result, is(expected));
    }
}
