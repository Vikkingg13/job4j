package ru.job4j.array;

/**
 * Объединяет два отсортированных массива.
 */
public class ArrayMerge {
    public int[] merge(int[] left, int[] right) {
        int size = left.length + right.length;
        int[] array = new int[size];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            array[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        if (i < left.length) {
            System.arraycopy(left, i, array, k, left.length - i);
        } else {
            System.arraycopy(right, j, array, k, right.length - j);
        }
        return array;
    }
}
