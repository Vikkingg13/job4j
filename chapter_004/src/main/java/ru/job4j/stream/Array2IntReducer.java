package ru.job4j.stream;

import java.util.Arrays;
import java.util.OptionalInt;

public class Array2IntReducer {
    public int convert(int[] numbers) {
        OptionalInt result = Arrays.stream(numbers).filter(e -> e % 2 == 0).map(e -> (int) Math.pow(e, 2))
                .reduce(Integer::sum);
        return  result.isPresent() ? result.getAsInt() : 0;
    }
}
