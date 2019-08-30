package ru.job4j.condition;

public class SqArea {

    public static int square(int p, int k) {
        int part = (p / 2) / (k + 1);
        int width = part * k;
        int height = part * 1;
        return width * height;
    }

    public static void main(String[] args) {
        int result = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result);
    }
}
