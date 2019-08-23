package ru.job4j.array;

/**
 * Обертка над строкой
 */
public class EndsWith {
    /**
     * Проверяет что слово заканчивается префиксом.
     * @param postfix префикс.
     * @return true если слово заканчивается префиксом.
     */

    public boolean endsWith(String word, String postfix) {
        boolean result = true;
        char[] pst = postfix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i=0; i<pst.length; i++) {
            if (wrd[(wrd.length-1)-i] != pst[(pst.length-1)-i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
