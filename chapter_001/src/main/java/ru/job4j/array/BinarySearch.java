package ru.job4j.array;

public class BinarySearch {

    public int search(int[] array, int value) {
        int result = -1;
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == value) {
                result = mid;
                break;
            }
            if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
