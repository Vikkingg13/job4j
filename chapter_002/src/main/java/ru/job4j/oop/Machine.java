package ru.job4j.oop;

import java.util.Arrays;

public class Machine {
    private final int[] coins = new int[] {10, 5, 2, 1};

    public  int[] changes(int value, int price) {
        int[] result = new int[100];
        int change = value - price;
        int position = 0;
        for (int coin : coins) {
            for (int i = 0;  i < change / coin; i++) {
                result[position] = coin;
                position++;
            }
            change %= coin;
            if (change == 0) {
                break;
            }
        }
        return Arrays.copyOf(result, position);
    }
}
