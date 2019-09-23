package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListUsersConvertToHashMap() {
        UserConvert convert = new UserConvert();
        User user = new User(700, "James Bond", "London");
        List<User> list = new ArrayList<>();
        list.add(user);
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result.get(700).getName(), is("James Bond"));

    }
}
