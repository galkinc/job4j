package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    int tailStart = -1;

    /**
     * Remove string duplicates from an array
     *
     * @param array Array with duplicates
     * @return Array without duplicates
     */
    public String[] remove(String[] array) {
        String[] clearedArray = array;

        // Sorting part
        array = bruteDuplicatesSort(array);
        //Copy to the result array with cutting a tail of sorted duplicates
        clearedArray = Arrays.copyOf(array, tailStart + 1);

        return clearedArray;
    }

    /**
     * Put duplicates to the end of the array.
     * Implemented by brute force with left and right shifting.
     *
     * @implNote Use tailStart as
     * @param array Array with duplicates
     * @return Array where all duplicates on the end
     */
    public String[] bruteDuplicatesSort(String[] array) {
        this.tailStart = array.length - 1;

        //left shift
        for (int i = 0; i < this.tailStart; i++) {
            //right shift
            for (int j = this.tailStart; j > i; j--) {
                // Detect a duplicate and put to the end of the array
                String tmp;
                if (array[i].equals(array[j])) {
                    tmp = array[j];
                    array[j] = array[this.tailStart];
                    array[this.tailStart] = tmp;
                    this.tailStart--;
                }
            }
        }
        return array;
    }

}
