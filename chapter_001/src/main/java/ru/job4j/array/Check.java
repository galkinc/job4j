package ru.job4j.array;

/**
 * Class
 * {true, true, true} - вернет true;
 * {true, false, true} - вернет false;
 * {false, false, false} - вернет true;
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
        for (int i = 0; i < array.length && result; i++) {
            if (!array[i]) {
                result = false;
            }
        }
        return result;
    }
}
