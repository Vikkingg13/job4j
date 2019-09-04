package ru.job4j.oop;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, long birthday) {
        super(name, surname, education, birthday);
    }

    public Product develop(Project project) {
        Product product = new Product();
        return product;
    }
}
