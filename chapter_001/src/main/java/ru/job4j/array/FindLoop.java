package ru.job4j.array;

/**
 * Ищет элемент в массиве
 *
 * @author Viktor Grigoriev (14GameOver.mail.ru)
 */
public class FindLoop {

    /**
     * Поиск элемента во всём массиве
     * @param data массив чисел
     * @param el искомый элемент
     * @return возвращает индекс элемента в массиве или -1
     */
    public int indexOf(int[]data, int el) {
        int rsl = -1;
        for(int i = 0; i < data.length; i++) {
            if (data[i] == el){
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    /**
     * Поиск элемента в диапазоне
     * @param data массив чисел
     * @param el искомый элемент
     * @param start начало диапазона
     * @param finish конец диапазона
     * @return возвращает индекс элемента в массиве или -1
     */
    public int indexOf(int[]data, int el, int start, int finish) {
        int rsl = -1;
        for(int i = start; i <= finish; i++){
            if (data[i] == el){
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    /**
     * Сортировка элементов массива по возрастанию
     * @param data массив чисел
     * @return возращает отсортированный массив
     */
    public int[] sort(int[] data){
        for (int i=0; i < data.length-1; i++) {
            for (int j = i+1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }


}
