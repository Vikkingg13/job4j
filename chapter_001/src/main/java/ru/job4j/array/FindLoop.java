package ru.job4j.array;

public class FindLoop {

    public int indexOf(int[]data, int el){
        int rsl = -1;
        for(int i = 0; i < data.length; i++){
            if (data[i] == el){
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
