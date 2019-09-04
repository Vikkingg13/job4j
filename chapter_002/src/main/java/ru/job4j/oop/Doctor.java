package ru.job4j.oop;

public class Doctor extends Profession {

    private String specialty;

    public Doctor(String name, String surname, String education, long birthday, String specialty) {
        super(name, surname, education, birthday);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
