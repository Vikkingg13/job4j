package ru.job4j.oop;

public class Square implements Shape {

    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ln = System.getProperty("line.separator");
        pic.append("+++++++" + ln);
        pic.append("+++++++" + ln);
        pic.append("+++++++" + ln);
        pic.append("+++++++" + ln);
        return pic.toString();
    }
}
