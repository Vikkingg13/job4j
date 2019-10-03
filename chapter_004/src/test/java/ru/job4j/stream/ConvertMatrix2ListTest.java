package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertMatrix2ListTest {
    @Test
    public void whenConvertMatrixToList() {
        ConvertMatrix2List converter = new ConvertMatrix2List();
        Integer[][] matrix = new Integer[][] {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        List<Integer> result = converter.convert(matrix);
        assertThat(result, is(List.of(10, 20 ,30, 40, 50, 60, 70, 80, 90)));
    }
}
