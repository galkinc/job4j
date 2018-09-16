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
    // * Vertical line tests *
    // ---------------------------------------------------

    /*
    @Test
    public void whenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(true), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGas() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }
    */


    // ---------------------------------------------------
    // * Vertical line tests *
    // ---------------------------------------------------

    /**
     * Vertical line X winning test
     */
    @Test
    public void whenAllVerticalElementsHaveXAndCheckXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()}
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXVerticalWinner(true), is(true));
    }

    /**
     * Vertical line: check winning parameter, if it'X but we expect O return false
     */
    @Test
    public void whenAllVerticalElementsHaveXAndCheck0ThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXVerticalWinner(false), is(false));
    }

    /**
     * Vertical line O winning test
     */
    @Test
    public void whenAllVerticalElementsHave0AndCheck0ThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXVerticalWinner(false), is(true));
    }

    /**
     * Vertical line doesn't include a same value (nobody win)
     */
    @Test
    public void whenVerticalElementsHaveNotSameValueXThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(true), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXVerticalWinner(true), is(false));
    }

    // ---------------------------------------------------
    // * Horizontal line tests *
    // ---------------------------------------------------

    /**
     * Horizontal line: X winning test
     */
    @Test
    public void whenAllHorizontalElementsHaveXAndCheckXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXHorizontalWinner(true), is(true));
    }

    /**
     * Horizontal line: check winning parameter, if it'X but we expect O return false
     */
    @Test
    public void whenAllHorizontalElementsHaveXAndCheck0ThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXHorizontalWinner(false), is(false));
    }

    /**
     * Horizontal line: O winning test
     */
    @Test
    public void whenAllHorizontalElementsHave0AndCheck0ThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXHorizontalWinner(false), is(true));
    }

    /**
     * Horizontal line doesn't include a same value (nobody win)
     */
    @Test
    public void whenHorizontalElementsHaveNotSameValueXThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXHorizontalWinner(true), is(false));
    }

    // ---------------------------------------------------
    // * Diagonal lines tests *
    // ---------------------------------------------------

    /**
     * Diagonal lines: X winning test
     */
    @Test
    public void whenAllDiagonalElementsHaveXAndCheckXThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXDiagonalWinner(true), is(true));
    }

    /**
     * Diagonal lines: check winning parameter, if it'X but we expect O return false
     */
    @Test
    public void whenAllDiagonalElementsHaveXAndCheck0ThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXDiagonalWinner(false), is(false));
    }

    /**
     * Diagonal lines: O winning test
     */
    @Test
    public void whenAllDiagonalElementsHave0AndCheck0ThenTrue() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXDiagonalWinner(false), is(true));
    }

    /**
     * Diagonal lines doesn't include a same value (nobody win)
     */
    @Test
    public void whenDiagonalElementsHaveNotSameXValueThenFalse() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.whenHasXDiagonalWinner(true), is(false));
    }

}
