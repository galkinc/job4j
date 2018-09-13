package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BubbleSortTest {

    /**
     * Test of unoptimised bubble sort method
     */
    @Test
    public void set35813WhenNotOptSortThen13358() {
        int[] set = {3, 5, 8, 1, 3};
        int[] expected = {1, 3, 3, 5, 8};
        BubbleSort sinking = new BubbleSort();
        assertThat(sinking.notOptSort(set), is(expected));
    }

    /**
     * Test of unoptimised bubble sort method
     */
    @Test
    public void set35813WhenOptSortThen13358() {
        int[] set = {1, 2, 3, 3, 5, 8};
        int[] expected = {1, 2, 3, 3, 5, 8};
        BubbleSort sinking = new BubbleSort();
        assertThat(sinking.optSort(set), is(expected));
    }

}