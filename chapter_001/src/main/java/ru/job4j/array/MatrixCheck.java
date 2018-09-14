package ru.job4j.array;

public class MatrixCheck {
    /**
     * The method MatrixCheck.mono has to return True when elements within a diagonal of a square matrix are
     * equal to the same boolean value, true or false.
     * The method check the main diagonals. (First: from x[0][0] to y[n][n]; Second: from x[n][0] to y[0][n]).
     * Non-intersecting matrix diagonals can be different, but each has to contain the same elements.
     *
     * @param data Square matrix
     * @return True - the condition is true; False - the condition isn't true.
     */
    public boolean mono(boolean[][] data) {
        boolean condition = true;
        int size = data.length - 1;

        for (int i = 0; i < size; i++) {
            //Does the point be in the FIRST main diagonal? && Comparing with the next element in the diagonal
            if (data[i][i] != data[i + 1][i + 1]) {
                condition = false;
                break;
            }
            //Does the point be in the SECOND main diagonal? && Comparing with the next element in the diagonal
            if (data[size - i][i] != data[size - i - 1][i + 1]) {
                condition = false;
                break;
            }
        }
        return condition;
    }
}
