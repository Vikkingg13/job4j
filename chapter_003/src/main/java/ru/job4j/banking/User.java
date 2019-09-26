package ru.job4j.banking;

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.passport.equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        return this.passport.hashCode();
    }
}
