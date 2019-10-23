package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoreTest {
    @Test
    public void whenAddUserInStore() {
        UserStore store = new UserStore(10);
        User user = new User("k1abc");
        store.add(user);
        assertThat(store.findById("k1abc"), is(user));
    }

    @Test
    public void whenReplaceUserInStoreThenOldUserNotHaveAndHaveNewUser() {
        UserStore store = new UserStore(10);
        User first = new User("k1abc");
        User second = new User("e4def");
        store.add(first);
        store.replace(first.getId(), second);
        assertThat(store.findById("e4def"), is(second));
        assertThat(store.findById("k1abc"), is((User) null));
    }

    @Test
    public void whenDeleteUserInStore() {
        UserStore store = new UserStore(10);
        User first = new User("k1abc");
        store.add(first);
        store.delete(first.getId());
        assertThat(store.findById(first.getId()), is((User) null));
    }

    @Test
    public void whenAddRoleInStore() {
        RoleStore store = new RoleStore(5);
        Role role = new Role("3etgh");
        store.add(role);
        assertThat(store.findById("3etgh"), is(role));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddRoleInFullStoreThenDropException() {
        RoleStore store = new RoleStore(1);
        Role first = new Role("3etgh");
        Role second = new Role("4rthn");
        store.add(first);
        store.add(second);
    }

    @Test
    public void whenTryDeleteNonexistentRoleThenReturnFalse() {
        RoleStore store = new RoleStore(5);
        assertThat(store.delete("rt2yk"), is(false));
    }

    @Test
    public void whenTryReplaceNonexistentRoleThenReturnFalse() {
        RoleStore store = new RoleStore(5);
        Role role = new Role("3etgh");
        assertThat(store.replace("rt2yk", role), is(false));
    }
}
