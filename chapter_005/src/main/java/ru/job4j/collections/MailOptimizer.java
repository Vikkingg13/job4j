package ru.job4j.collections;

import java.util.*;

public class MailOptimizer {

    public void optimize(Map<User, Set<String>> map) {
        Queue<User> users = new LinkedList<>(map.keySet());
        while (users.size() > 1) {
            User current = users.poll();
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User target = iterator.next();
                if (map.get(current).stream().anyMatch(email -> map.get(target).contains(email))) {
                    map.get(current).addAll(map.get(target));
                    map.remove(target);
                    users.remove(target);
                    iterator = users.iterator();
                }
            }
        }
    }
}