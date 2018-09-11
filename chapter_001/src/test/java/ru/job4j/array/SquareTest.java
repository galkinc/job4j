package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for Square class
 */
public class SquareTest {

    /**
     * When size of massive is 3, the massive will be created by method calculate.
     * Each element of the massive is squared natural integer.
     * @implNote Will be compared a whole massive, not elements-numbers.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
    @Test
    public void whenBound6ThenLastItem36() {
        Square square = new Square();
        int[] rst = square.calculate(6);
        assertThat(rst[5], is(36));
    }

}
