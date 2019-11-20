package ru.job4j.collections;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MailOptimizerTest {
    @Test
    public void whenFirstAndThirdUserHasCommonEmailThenUniteUsers() {
        User viktor = new User("Viktor");
        User max = new User("Max");
        User alex = new User("Alex");
        Map<User, Set<String>> accounts = new LinkedHashMap<>();
        accounts.put(new User("user1"), new LinkedHashSet<>(Arrays.asList("xxx@ya.ru", "lol@mail.ru")));
        accounts.put(new User("user2"), new LinkedHashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        accounts.put(new User("user3"), new LinkedHashSet<>(Arrays.asList("xyz@biz.net", "vasya@pupkin.com")));
        accounts.put(new User("user4"), new LinkedHashSet<>(Arrays.asList("lol@mail.ru", "aaa@bbb.ru")));
        accounts.put(new User("user5"), new LinkedHashSet<>(Arrays.asList("xyz@biz.net", "foo@gmail.com")));
        new MailOptimizer().optimize(accounts);
        assertThat(accounts, is(
                Map.of(
                        new User("user1"),
                            new LinkedHashSet<>(Arrays.asList("xxx@ya.ru", "lol@mail.ru", "aaa@bbb.ru")),
                        new User("user2"),
                            new LinkedHashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net", "xyz@biz.net", "vasya@pupkin.com")))
        ));
    }
}

