package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        int finish = array.length;
        for (int out = 0; out < finish; out++) {
            for (int in = out + 1; in < finish; in++) {
                if (array[out].equals(array[in])) {
                    String tmp = array[array.length - 1];
                    array[array.length - 1] = array[in];
                    array[in] = tmp;
                    finish--;
                    in--;
                  }
            }
        }
        return  Arrays.copyOf(array, finish);
    }
}
