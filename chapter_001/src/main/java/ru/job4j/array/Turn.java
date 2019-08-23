package ru.job4j.array;

public class Turn {

    public int[] back(int[] arr){
        int lastIndex = arr.length-1;
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[lastIndex-i];
            arr[lastIndex-i] = temp;
        }
        return arr;
    }
}
