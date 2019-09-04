package ru.job4j.oop;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, long birthday, String specialty) {
        super(name, surname, education, birthday, specialty);
    }

    public Patient doSurgery(Patient patient) {
        return patient;
    }
}
