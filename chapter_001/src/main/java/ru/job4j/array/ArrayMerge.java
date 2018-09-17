package ru.job4j.array;

public class ArrayMerge {
    /**
     * Merge two presorted arrays
     * @param array1
     * @param array2
     * @return One sorted array
     */
    public int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        //int i, ia1, ia2;

        //the first two conditions (simple)
        if (array1[array1.length - 1] < array2[0]) {
            System.arraycopy(array1, 0, result, 0, array1.length);
            System.arraycopy(array2, 0, result, array1.length, array2.length);
        } else if (array2[array2.length - 1] < array1[0]) {
            System.arraycopy(array2, 0, result, 0, array2.length);
            System.arraycopy(array1, 0, result, array2.length, array1.length);
        } else { //second condition with intersection
            for (int i = 0, ia1 = 0, ia2 = 0; i < result.length; i++) {
                //Make break point when can be ArrayIndexOutOfBoundsException
                if (ia1 == array1.length) {
                    System.arraycopy(array2, ia2, result, i, array2.length - ia2);
                    break;
                }
                if (ia2 == array2.length) {
                    System.arraycopy(array1, ia1, result, i, array1.length - ia1);
                    break;
                }
                //check if sizes of arrays are different
                if (array1[ia1] < array2[ia2]) {
                    result[i] = array1[ia1];
                    ia1++;
                } else {
                    result[i] = array2[ia2];
                    ia2++;
                }
            }
        }
        //the second condition with Intersection
        return result;
    }
}
