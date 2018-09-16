package ru.job4j.tictactoe;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for logic of Tic tac toe
 * @author galkinc
 * @version 0.0.1
 */
public class Logic3TTest {

    // ---------------------------------------------------
    // * Test for X winning (isWinnerX()) *
    // ---------------------------------------------------

    // --- Vertical line for X ---

    /**
     * Vertical line, 3x3 matrix: X winning true test
     */
    @Test
    public void set3x3MatrixIsWinnerXWhenVerticalXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(true)}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    /**
     * Vertical line. 4x4 matrix: X winning true test
     */
    @Test
    public void set4x4MatrixIsWinnerXWhenVerticalXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    /**
     * Vertical line, 3x3 matrix: X winning false test
     */
    @Test
    public void set3x3MatrixIsWinnerXWhenVerticalOThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(false));
    }

    // --- Horizontal line for X ----

    /**
     * Horizontal line, 3x3 matrix: X winning true test
     */
    @Test
    public void set3x3MatrixIsWinnerXWhenHorizontalXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    /**
     * Horizontal line, 5x5 matrix: X winning true test
     */
    @Test
    public void set5x5MatrixIsWinnerXWhenHorizontalXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    /**
     * Horizontal line, 3x3 matrix: X winning false test
     */
    @Test
    public void set3x3MatrixIsWinnerXWhenHorizontalOThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(false));
    }

    // --- Diagonal line for X ----

    /**
     * Diagonal line (up do down), 5x5 Matrix: X winning true test
     */
    @Test
    public void set5x5MatrixIsWinnerXWhenUpToDawnDiagonalXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    /**
     * Diagonal line (down do up), 4x4 Matrix: X winning true test
     */
    @Test
    public void set4x4MatrixIsWinnerXWhenDownToUpDiagonalXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    /**
     * Diagonal line (up do down), 3x3 Matrix: X winning false test
     */
    @Test
    public void set3x3MatrixIsWinnerXWhenUpToDawnDiagonalOThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(false));
    }

    // ---------------------------------------------------
    // * Test for O winning (isWinnerO()) *
    // ---------------------------------------------------

    // --- Vertical line for O ---

    /**
     * Vertical line, 3x3 matrix: O winning test
     */
    @Test
    public void set4x4MatrixWhenVerticalOThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    /**
     * Vertical line. 5x5 matrix: O winning test
     */
    @Test
    public void set5x5MatrixWhenVerticalOThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    /**
     * Vertical line, 3x3 matrix: O winning false test
     */
    @Test
    public void set3x3MatrixIsWinnerOWhenVerticalXThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(false));
    }

    // --- Horizontal line for O ----

    /**
     * Horizontal line, 3x3 matrix: O winning test
     */
    @Test
    public void set3x3MatrixWhenHorizontalOThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    /**
     * Horizontal line, 5x5 matrix: O winning test
     */
    @Test
    public void set5x5MatrixwhenHorizontalOThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    /**
     * Horizontal line, 3x3 matrix: O winning false test
     */
    @Test
    public void set3x3MatrixIsWinnerOWhenHorizontalXThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(false));
    }

    // --- Diagonal line for O ----

    /**
     * Diagonal line (up do down), 4x4 Matrix: O winning test
     */
    @Test
    public void set5x5MatrixWhenUpToDawnDiagonalHaveOThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    /**
     * Diagonal line (down do up), 3x3 Matrix: O winning test
     */
    @Test
    public void set4x4MatrixWhenDownToUpDiagonalHaveOThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    /**
     * Diagonal line (up do down), 3x3 Matrix: O winning false test
     */
    @Test
    public void set3x3MatrixIsWinnerOWhenUpToDawnDiagonalXThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(false));
    }

    // ---------------------------------------------------
    // * Game is continuing but nobody win *
    // ---------------------------------------------------

    /**
     * 3x3 Matrix, isWinnerX()
     */
    @Test
    public void set3x3MatrixIsWinnerXWhenNoWinnerThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(false));
    }

    /**
     * 4x4 Matrix, isWinnerX()
     */
    @Test
    public void set4x4MatrixIsWinnerXWhenNoWinnerThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(false));
    }

    /**
     * 3x3 Matrix, isWinnerO()
     */
    @Test
    public void set3x3MatrixIsWinnerOWhenNoWinnerThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(false));
    }

    /**
     * 4x4 Matrix, isWinnerO()
     */
    @Test
    public void set4x4MatrixIsWinnerOWhenNoWinnerThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(false));
    }

    // ---------------------------------------------------
    // * Test if there isn't a place for X or O *
    // ---------------------------------------------------


}
