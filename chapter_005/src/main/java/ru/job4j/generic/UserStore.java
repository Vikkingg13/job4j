package ru.job4j.generic;

import java.util.Iterator;

public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}