package ru.job4j.array;

/** Проверка массива по диагонали
 * @author Viktor Grigoriev (14GameOver@mail.ru)
 */
public class MatrixCheck {
    /**
     *
     * @param data булевый массив
     * @return возвращает true если элементы по диагонали одинаковы
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int lastIndex = data.length-1;
        for (int i=0; i<lastIndex; i++) {
            if (data[i][i] != data[i+1][i+1] ||
                    data[lastIndex-i][i] != data[(lastIndex-i)-1][i+1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
