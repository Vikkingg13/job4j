package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SchoolTest {
    private List<Student> students = List.of(
            new Student(55, "Nikolaev"),
            new Student(80, "Semenov"),
            new Student(35, "Andreev"),
            new Student(63, "Ivanov"),
            new Student(15, "Isaev")
    );
    @Test
    public void whenScoreHigher70() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() >= 70);
        assertThat(result, is(List.of(new Student(80, "Semenov"))));
    }

    @Test
    public void whenScoreHigher50AndLower70() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> 50 <= student.getScore() && 70 > student.getScore());
        assertThat(result, is(List.of(new Student(55, "Nikolaev"), new Student(63, "Ivanov"))));
    }

    @Test
    public void whenScoreLower50() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() < 50);
        assertThat(result, is(List.of(new Student(35, "Andreev"), new Student(15, "Isaev"))));
    }

    @Test
    public void whenGroupingStudentsByScore() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student(80, "Semenov"), null, new Student(35, "Andreev"),
                new Student(15, "Isaev"), null, null, new Student(55, "Nikolaev"),
                null, new Student(63, "Ivanov")
        );
        List<Student> result = school.levelOf(students, 40);
        List<Student> expected = List.of(
                new Student(80, "Semenov"), new Student(63, "Ivanov"),
                new Student(55, "Nikolaev")
        );
        assertThat(result, is(expected));
    }
}
