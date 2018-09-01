package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class CalculatorTest - Tests for Class Calculator
 *
 */
public class CalculatorTest {

    /**
    * Test for summarasing
    */
    @Test
    public void whenOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test for subtraction
     */
    @Test
    public void whenOneMinusOneThenNull() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 1D);
        double result = calc.getResult();
        double expected = 0;
        assertThat(result, is(expected));
    }

    /**
     * Test for division
     */
    @Test
    public void whenFourDivideTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test for multiplication
     */
    @Test
    public void whenTwoIncreaseByTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * Test for getting result
     */
    @Test
    public void whenSetNineInResultThenReturnNineInResult() {
        Calculator calc = new Calculator();
        double expected = 9D;
        calc.result = expected;
        double result = calc.getResult();
        assertThat(result, is(expected));
    }

}
