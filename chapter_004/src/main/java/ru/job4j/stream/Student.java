package ru.job4j.stream;

public class Student {
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.score == student.score;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(score);
    }
}
