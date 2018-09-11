package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for Max class
 */
public class MaxTest {

    @Test
    /**
     * Test for max-defining function
     */
    public void whenALessBThenB() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    /**
     * Test for the method maxFromThree: Maximum of three numbers
     */
    public void whenALesBAndBMoreCThenB() {
        int maximum = new Max().maxFromThree(1, 5, 3);
        assertThat(maximum, is(5));
    }
}
