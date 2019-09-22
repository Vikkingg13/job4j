package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortUsers() {
        SortUser sorter = new SortUser();
        User sam = new User("Sam", 35);
        User bobby = new User("Bobby", 54);
        User din = new User("Din", 31);
        Set<User> result = sorter.sort(Arrays.asList(sam, bobby, din));
        assertThat(result.toArray(), is(new User[] {din, sam, bobby}));

    }

}
