package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Chessboard drawing
 */
public class BoardTest {

    @Test
    /**
     * Test for 3x3 chessboard drawing:
     * Х	 Х
     *    Х
     * Х	 Х
     */
    public void when3x3ThenPass() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    @Test
    /**
     *  test for 5x4 chessboard drawing:
     *  Х	 	Х	 	Х
     *      Х	 	Х
     *  Х	 	Х	 	Х
     *      Х	 	Х
     */
    public void when4x5ThenPass() {
        //напишите здесь тест, проверяющий формирование доски 5 на 4.
        Board board = new Board();
        String result = board.paint(5, 4);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
                )
        );
    }
}
