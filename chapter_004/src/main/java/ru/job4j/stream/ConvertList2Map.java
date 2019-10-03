package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertList2Map {
    public Map<String, Student> convert(List<Student> list) {
        return list.stream().collect(Collectors.toMap(Student::getSurname, e -> e, (x, y) -> x));
    }
}
