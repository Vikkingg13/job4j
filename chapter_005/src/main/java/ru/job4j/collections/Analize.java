package ru.job4j.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int added, changed, deleted;
        added = changed = deleted = 0;
        Map<Integer, String> map = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User user : current) {
            int key = user.id;
            if (map.get(key) != null) {
                if (!map.get(key).equals(user.name)) {
                    changed++;
                }
                map.remove(key);
            } else {
                added++;
            }
        }
        deleted = map.size();
        return new Info(added, changed, deleted);
    }

    public static class Info {

        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + added;
            result = 31 * result + changed;
            result = 31 * result + deleted;
            return result;
        }
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
