package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SchoolTest {
    private List<Student> students = Arrays.asList(
            new Student(55),
            new Student(80),
            new Student(35),
            new Student(63),
            new Student(15)
    );
    @Test
    public void whenScoreHigher70() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() >= 70);
        assertThat(result, is(Arrays.asList(new Student(80))));
    }

    @Test
    public void whenScoreHigher50AndLower70() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> 50 <= student.getScore() && 70 > student.getScore());
        assertThat(result, is(Arrays.asList(new Student(55), new Student(63))));
    }

    @Test
    public void whenScoreLower50() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() < 50);
        assertThat(result, is(Arrays.asList(new Student(35), new Student(15))));
    }
}
