package ru.galkinc.list;

import java.util.List;

/**
 * By the task I have use foreach.
 *
 * Implement Public int[][] toArray (List<Integer> list, int rows) {} -
 * method should create a two-dimensional array from the list.
 * If amount of elements is not multiple to number of strings, then add 0 to the end.
 *
 * Example:
 * List = (1, 2, 3, 4, 5, 6, 7)
 * Number of rows = 3
 * The result is {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
 *
 * PS:
 * Can throw "Divide by zero exception" if the rows value is equal 0
 *
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) throws ArithmeticException {

        int cells = (int)Math.ceil((double) list.size() / (double)rows);
        int[][] array = new int[rows][cells];

        int rowCounter = 0;
        int cellCounter = 0;
        for (int element : list) {
            if (cellCounter == cells) {
                cellCounter = 0;
                rowCounter++;
            }
            array[rowCounter][cellCounter] = element;
            cellCounter++;
        }
        return array;
    }
}
