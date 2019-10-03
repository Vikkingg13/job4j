package ru.job4j.stream;

public class Student {
    private int score;
    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Student) {
            Student student = (Student) obj;
            if (this.score == student.score) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(score);
    }
}
