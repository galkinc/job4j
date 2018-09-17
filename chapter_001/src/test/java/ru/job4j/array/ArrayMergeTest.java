package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayMergeTest {
    @Test
    public void setTwoSortedSequenceArrays1Bigger2WhenMergeThenOneSortedArray() {
        int[] array1 = {5, 6, 7, 8};
        int[] array2 = {1, 2, 3, 4};
        ArrayMerge finalArray = new ArrayMerge();
        int[] result = finalArray.merge(array1, array2);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void setTwoSortedSequenceArrays2Bigger1WhenMergeThenOneSortedArray() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        ArrayMerge finalArray = new ArrayMerge();
        int[] result = finalArray.merge(array1, array2);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void setTwoSortedDifferentSizeWithIntersectionArraysWhenMergeThenOneSortedArray() {
        int[] array1 = {1, 2, 3, 7};
        int[] array2 = {5, 6, 8, 9, 10};
        ArrayMerge finalArray = new ArrayMerge();
        int[] result = finalArray.merge(array1, array2);
        int[] expected = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expected));
    }

    @Test
    public void setTwoSortedSameSizeWithIntersectionArraysWhenMergeThenOneSortedArray() {
        int[] array1 = {5, 6, 8, 11};
        int[] array2 = {1, 2, 3, 7};
        ArrayMerge finalArray = new ArrayMerge();
        int[] result = finalArray.merge(array1, array2);
        int[] expected = {1, 2, 3, 5, 6, 7, 8, 11};
        assertThat(result, is(expected));
    }

    @Test
    public void setTwoSortedSameSizeOneWithZeroWithIntersectionArraysWhenMergeThenOneSortedArray() {
        int[] array1 = {5, 6, 8, 11};
        int[] array2 = {0, 1, 2, 3, 7};
        ArrayMerge finalArray = new ArrayMerge();
        int[] result = finalArray.merge(array1, array2);
        int[] expected = {0, 1, 2, 3, 5, 6, 7, 8, 11};
        assertThat(result, is(expected));
    }
}
