package ru.galkinc.list;

        import java.util.ArrayList;
        import java.util.List;

/**
 * By the task, I have to use foreach.
 * public List<Integer> toList (int[][] array) {} -
 * the method add two-dimensional int arrays in the returned list.
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] subArray : array) {
            for (int element : subArray) {
                list.add(element);
            }
        }
        return list;
    }
}
