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
        Max maxim = new Max(1, 2);
        int result = maxim.max();
        assertThat(result, is(2));
    }
}
