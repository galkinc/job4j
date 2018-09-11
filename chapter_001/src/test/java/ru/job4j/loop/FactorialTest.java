package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for Factorial
 * The factorial for 5 is 120 (1 * 2 * 3 * 4 * 5).
 * The factorial for 0 is 1
 */
public class FactorialTest {

    /**
     * Test for factorial calculation.
     * The factorial for 5 is 120 (1 * 2 * 3 * 4 * 5).
     */
    @Test
    public void setFiveThen120() {
        Factorial factorial = new Factorial();
        assertThat(factorial.factorialCalc(5), is(120));
    }

    /**
     * Test for calculation of factorial for 0 (is 1).
     */
    @Test
    public void setNullThenOne() {
        Factorial factorial = new Factorial();
        assertThat(factorial.factorialCalc(0), is(1));
    }


}
