package ru.job4j.loop;

public class PrimeNumber {

    public int calc(int finish) {
        int result = 0;
        for (int i = 1; i <= finish; i++) {
            for (int j = 2; j <= i; j++) {
                if (j == i) {
                    result++;
                } else if (i % j == 0) {
                    break;
                }
            }
        }
        return result;
    }
}
