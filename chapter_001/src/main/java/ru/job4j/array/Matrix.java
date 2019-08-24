package ru.job4j.array;

/**
 * Таблица умножения
 *
 * @author Viktor Grigoriev (14GameOver@mail.ru)
 */
public class Matrix {

    /**
     *
     * @param size размер таблицы
     * @return возвращает массив таблицу умножения
     */
    public int[][] multiply(int size) {
        int[][] table = new int[size][size];
        for (int i=0; i < size; i++) {
            for (int j=0; j < size; j++) {
                table[i][j] = (i+1)*(j+1);
            }
        }
        return table;
    }
}
