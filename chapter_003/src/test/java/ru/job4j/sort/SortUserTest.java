package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    private User viktor = new User("Viktor", 25);
    private User stan = new User("Stan", 16);
    private User sam = new User("Sam", 32);
    private User sammy = new User("Sam", 31);

    @Test
    public void whenSortUsers() {
        SortUser sorter = new SortUser();
        Set<User> result = sorter.sort(Arrays.asList(sam, viktor, stan));
        assertThat(result.toArray(), is(new User[] {stan, viktor, sam}));
    }

    @Test
    public void whenSortUsersByLengthName() {
        SortUser sorter = new SortUser();
        List<User> result = sorter.sortNameLength(Arrays.asList(viktor, stan, sam));
        assertThat(result, is(Arrays.asList(sam, stan, viktor)));
    }

    @Test
    public void whenSortUsersByAllField() {
        SortUser sorter = new SortUser();
        List<User> result = sorter.sortByAllFields(Arrays.asList(sam, sammy, viktor));
        assertThat(result, is(Arrays.asList(sammy, sam, viktor)));

    }


}
