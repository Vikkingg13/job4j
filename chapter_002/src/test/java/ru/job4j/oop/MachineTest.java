package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenChangeSameFifteenThenTenAndFive() {
        Machine machine = new Machine();
        int[] result = machine.changes(50, 35);
        int[] expected = new int[] {10, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenChangeSameEighteenThenTenFiveTwoOne() {
        Machine machine = new Machine();
        int[] result = machine.changes(50, 32);
        int[] expected = new int[] {10, 5, 2, 1};
        assertThat(result, is(expected));
    }
}
