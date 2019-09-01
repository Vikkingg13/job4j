package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String title = "Песня не найдена";
        if (position == 1) {
            title = "Пусть бегут неуклюже";
        } else if (position == 2) {
            title = "Спокойной ночи";
        }
        System.out.println(title);
    }

    public static void main(String[] args) {
        Jukebox box = new Jukebox();
        box.music(1);
        box.music(3);
        box.music(2);
    }
}
