package ru.job4j.sort;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentSortTest {
    private List<String> departments = Arrays.asList(
            "K1/SK1",
            "K1/SK2",
            "K1/SK1/SSK1",
            "K1/SK1/SSK2",
            "K2",
            "K2/SK1/SSK1",
            "K2/SK1/SSK2"
    );

    @Test
    public void whenSortAscending() {
        DepartmentSort sorter = new DepartmentSort();
        List<String> list = new ArrayList<>(departments);
        sorter.sortAscending(list);
        List<String> result = List.of(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        assertThat(list, is(result));
    }

    @Test
    public void whenSortDescending() {
        DepartmentSort sorter = new DepartmentSort();
        List<String> list = new ArrayList<>(departments);
        sorter.sortDescending(list);
        List<String> result = List.of(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        );
        assertThat(list, is(result));
    }
}
