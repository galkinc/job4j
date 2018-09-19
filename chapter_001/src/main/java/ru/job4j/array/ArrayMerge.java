package ru.job4j.array;

public class ArrayMerge {
    /**
     * The method merges two pre-sorted arrays into a new sorted array
     * (e.g. {1, 2, 3, 4, 5} = {1, 5} + {2, 3, 4}).
     * The method also includes an optimized solution to the frequent case where arrays do not intersect.
     * (e.g. {1, 2, 3} and {4, 5, 6})
     * @param array1 Presorted array
     * @param array2 Presorted array
     * @return One sorted array
     */
    public int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        if (array1[array1.length - 1] < array2[0]) {
            System.arraycopy(array1, 0, result, 0, array1.length);
            System.arraycopy(array2, 0, result, array1.length, array2.length);
        } else if (array2[array2.length - 1] < array1[0]) {
            System.arraycopy(array2, 0, result, 0, array2.length);
            System.arraycopy(array1, 0, result, array2.length, array1.length);
        } else {
            result = hasIntersection(array1, array2);
        }

        return result;
    }

    /**
     * The method compares elements of the inserted arrays.
     * Elements are put in the result array by sorting from smaller to bigger.
     * Also two conditions are used to reduce ArrayIndexOutOfBoundsException
     * @param leftArray Presorted array
     * @param rightArray Presorted array
     * @return
     */
    private int[] hasIntersection(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];

        for (int i = 0, ia1 = 0, ia2 = 0; i < result.length; i++) {
            if (ia1 == leftArray.length) {
                System.arraycopy(rightArray, ia2, result, i, rightArray.length - ia2);
                break;
            }
            if (ia2 == rightArray.length) {
                System.arraycopy(leftArray, ia1, result, i, leftArray.length - ia1);
                break;
            }
            if (leftArray[ia1] < rightArray[ia2]) {
                result[i] = leftArray[ia1];
                ia1++;
            } else {
                result[i] = rightArray[ia2];
                ia2++;
            }
        }

        return result;
    }
}
