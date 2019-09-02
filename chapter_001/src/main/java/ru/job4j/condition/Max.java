package ru.job4j.condition;

public class Max {

    public int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public int max(int first, int second, int third, int fourth) {
        return max(max(first, second), max(third, fourth));
    }
}
