package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * By the task #192 From 1 to 10 return sum of even numbers equal 30 (2 + 4 + 6 + 8 + 10)
 */
public class CounterTest {

    @Test
    /**
     * Test for Add method
     */
    public void whenOneToTenThenSumThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }

    @Test
    /**
     * Add method should work too if first value is bigger than second.
     */
    public void whenTenToOneThenSumThirty() {
        Counter counter = new Counter();
        int result = counter.add(10, 1);
        assertThat(result, is(30));
    }
}
