package ru.job4j.array;

/**
 * Class
 * {true, true, true} - return true;
 * {true, false, true} - return false;
 * {false, false, false} - return true;
 */
public class Check {
    /**
     *  Checking that all array items have the same boolean value.
     *  {true, true, true} - return true;
     *  {true, false, true} - return false;
     *  {false, false, false} - return true;
     *
     * @param array Input array
     * @return Boolean value of the array checking.
     */
    public boolean mono(boolean[] array) {
        boolean result = true;
        for (int i = 0; i < array.length - 1  && result; i++) {
            if (array[i] != array[i + 1]) {
                result = false;
            }
        }
        return result;
    }
}
