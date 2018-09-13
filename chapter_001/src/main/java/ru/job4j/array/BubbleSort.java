package ru.job4j.array;

/**
 *
 * Class for bubble sort (sinking sort).
 * The beautiful dance visualization of the bubble-sort: https://youtu.be/lyZQPjUT5B4 :-)
 *
 * @author galkinc
 * @version 1.0.0
 */
public class BubbleSort {

    /**
     * Bubble sort (sinking sort) of an array. (not optimized)
     * Worst-case and average complexity of О(n2)
     *
     * @param array Unsorted array
     * @return Sorted array
     */
    public int[] notOptSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * Bubble sort (sinking sort) of an array.
     * Optimized by:
     *  - isSorted flag - may reduce operation if array is already sorted
     *  - reducing unnecessary iterations when the array has a long sorted tail
     *
     * @param array Unsorted array
     * @return Sorted array
     */
    public int[] optSort(int[] array) {
        //Don't do anything if it was already sorted.
        boolean isSorted = false;
        //optimization for a long ordered tail
        int lastSwap = array.length - 1;

        for (int i = 0; isSorted && i < array.length - 1; i++) {
            isSorted = true;
            int currentSwap = -1;

            for (int j = 0; j < lastSwap; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    isSorted = false;
                    currentSwap = i;
                }
            }
            lastSwap = currentSwap;
        }
        return array;
    }

}