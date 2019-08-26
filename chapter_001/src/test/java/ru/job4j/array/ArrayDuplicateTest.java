package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenArrayHasDuplicateThenDropIt() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Olya", "Olya", "Nadya", "Nadya", "Masha"};
        String[] expected = {"Olya", "Nadya", "Masha"};
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void whenArrayHasNumDuplicateThenDropIt() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"2", "1", "1", "1", "3"};
        String[] expected = {"1", "2", "3"};
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}
