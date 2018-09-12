package ru.job4j.array;

public class Turn {
    /**
     * Turn array (e.g. before [1, 2, 3] after [3, 2, 1]
     * @param array
     * @return Reverse array
     */
    public int[] turn(int[] array) {
        int length = array.length;
        // using half of length
        for (int i = 0; i < length - i - 1; i++) {
            int tmp;
            tmp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = tmp;
        }
        return array;
    }
}
