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
     * Test of optimised bubble sort method
     */
    @Test
    public void set35813WhenOptSortThen13358() {
        int[] set = {9, 8, 1, 3, 5, 4};
        int[] expected = {1, 3, 4, 5, 8, 9};
        BubbleSort sinking = new BubbleSort();
        assertThat(sinking.optSort(set), is(expected));
    }

}