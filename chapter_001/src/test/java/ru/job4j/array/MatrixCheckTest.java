package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    /**
     * The method MatrixCheck.mono has to return True when elements within a diagonal of a square matrix are
     * _EQUAL_ to the same boolean value, true or false.
     * The method check the main diagonals. (First: from x[0][0] to y[n][n]; Second: from x[n][0] to y[0][n]).
     * Non-intersecting matrix diagonals can be different, but each has to contain the same elements.
     */
    @Test
    public void whenMainMatrixDiagonalsHaveSameValuesThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Check additional condition:
     * non-intersecting matrix diagonals can be different, but each has to contain the same elements.
     */
    @Test
    public void whenMainDiagonalsIn4x4MatrixHaveSameValuesThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, false, true, true},
                {true, false, true, false},
                {true, true, false, false},
                {true, true, true, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * The method MatrixCheck.mono has to return False when elements within a diagonal of a square matrix are
     * _NOT EQUAL_ to the same boolean value, true or false.
     * The method check the main diagonals. (First: from x[0][0] to y[n][n]; Second: from x[n][0] to y[0][n]).
     * Non-intersecting matrix diagonals can be different, but each has to contain the same elements.
     */
    @Test
    public void whenMatrixDiagonalsHaveNotASameValueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
