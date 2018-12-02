package ru.galkinc.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void when7ElementsDropBy3ElementsThenMatrix3x3() {
        ConvertList list = new ConvertList();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when8ElementsDropBy2ElementsThenMatrix2x4() {
        ConvertList list = new ConvertList();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        assertThat(result, is(expect));
    }
    /**
     * list.add(new int[]{1, 2})
     * list.add(new int[]{3, 4, 5, 6})
     * List<Integer> result = convertList.convert(list)
     *
     * List<Integer> result should contain: (1, 2, 3, 4, 5, 6)
     */
    @Test
    public void whenAddArraysToTheListAndConvertThenGetList() {
        ArrayList list = new ArrayList();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
