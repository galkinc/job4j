package ru.job4j.array;

public class ArrayChar {

    private char[] data;

    /**
     * Class constructor
     * @param line
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Checking that ArrayChar has the same the word in ArrayChar.data[].
     * @param word String for checking.
     * @return True - word is in ArrayChar.data[]; False - word isn't in ArrayChar.data[].
     */
    public boolean startWith(String word) {
        boolean result = true;
        char[] value = word.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (this.data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

}
