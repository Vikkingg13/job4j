package ru.job4j.sort;

import java.util.*;

public class DepartmentSort {
    public void sortAscending(List<String> list) {
        this.addDepartments(list);
        Collections.sort(list);
    }

    public void sortDescending(List<String> list) {
        this.addDepartments(list);
        Comparator<String> descending = new Comparator<>() {
            @Override
            public int compare(String left, String right) {
                int result = 0;
                int size = Math.min(left.length(), right.length());
                for (int index = 0; index < size; index++) {
                    result = Character.compare(left.toCharArray()[index], right.toCharArray()[index]) * -1;
                    if (result != 0) {
                        break;
                    }
                }
                return result != 0 ? result : Integer.compare(left.length(), right.length());
            }
        };
        list.sort(descending);
    }

    public void addDepartments(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String[] strings = iterator.next().split("/");
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < strings.length - 1; i++) {
                string.append(strings[i]);
                String department = string.toString();
                if (!list.contains(department)) {
                    iterator.add(department);
                }
                string.append("/");
            }
        }
    }
}
