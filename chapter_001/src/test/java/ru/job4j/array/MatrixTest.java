package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void when3on3() {
        Matrix matrix = new Matrix();
        int size = 3;
        int[][] result = matrix.multiply(size);
        int[][] expected = new int[][]{
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void when5on5() {
        Matrix matrix = new Matrix();
        int size = 5;
        int[][] result = matrix.multiply(size);
        int[][] expected = new int[][] {
                {1, 2, 3, 4, 5},
                {2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15},
                {4, 8, 12, 16, 20},
                {5, 10, 15, 20, 25}
        };
        assertThat(result, is(expected));
    }

}
