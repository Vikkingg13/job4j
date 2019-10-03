package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertList2MapTest {
    @Test
    public void whenConvertListToMap() {
        ConvertList2Map converter = new ConvertList2Map();
        Student nikolaev = new Student(50, "Nikolaev");
        Student ivanov = new Student(30, "Ivanov");
        Student antonov = new Student(76, "Antonov");
        Student vasilev = new Student(45, "Vasilev");
        Student sergeev = new Student(1, "Sergeev");
        Map<String, Student> result = converter.convert(Arrays.asList(nikolaev, ivanov, antonov, vasilev, sergeev, nikolaev));
        Map<String, Student> expected = Map.of(
                "Nikolaev", nikolaev,
                "Ivanov", ivanov,
                "Antonov", antonov,
                "Vasilev", vasilev,
                "Sergeev", sergeev
        );
        assertThat(result, is(expected));
    }
}
