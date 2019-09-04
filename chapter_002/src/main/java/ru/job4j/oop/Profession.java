package ru.job4j.oop;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private long birthday;

    public Profession(String name, String surname, String education, long birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public long getBirthday() {
        return birthday;
    }
}
