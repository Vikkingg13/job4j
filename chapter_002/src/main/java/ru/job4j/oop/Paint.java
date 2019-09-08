package ru.job4j.oop;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint first = new Paint();
        first.draw(new Square());
        Paint second = new Paint();
        second.draw(new Triangle());
    }
}
