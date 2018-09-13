package ru.job4j.array;

/**
 * Matrix class
 */
public class Matrix {
    /**
     * A square matrix with multiplication values.
     *
     * @param size Size of the square matrix.
     * @return A square matrix with multiplication values.
     */
    public int[][] multiple(int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        return matrix;
    }
}
