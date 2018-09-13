package ru.job4j.array;

/**
 * Find a value in an array
 */
public class FindLoop {
    /**
     * Brute force searching
     * @param input Input array
     * @param value Value for searching
     * @return Return index of the value in the input, or -1 if value wasn't in the array.
     */
    public int indexOf(int[] input, int value) {
        int result = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }
}
