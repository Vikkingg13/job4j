package ru.job4j.gc;

public class User {

    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() for " + this.getName() + " called");
    }
}
