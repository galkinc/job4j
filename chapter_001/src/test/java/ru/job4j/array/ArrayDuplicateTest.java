package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void setArrayWithDuplicateswhenRemoveDuplicatesThenArrayWithoutDuplicates() {
        String[] rowArray = {"Hello", "World", "World", "Hello", "!", "World"};
        String[] expectArray = {"Hello", "World", "!"};
        ArrayDuplicate array = new ArrayDuplicate();
        assertThat(array.remove(rowArray), is(expectArray));
    }

    @Test
    public void setArrayWithOutDuplicateswhenRemoveDuplicatesThenArrayWithoutDuplicates() {
        String[] rowArray = {"Hello", "World", "And", "Java"};
        String[] expectArray = {"Hello", "World", "And", "Java"};
        ArrayDuplicate array = new ArrayDuplicate();
        assertThat(array.remove(rowArray), is(expectArray));
    }

    @Test
    public void setAllArrayWithSameDuplicateswhenSortArrayThenArrayWithOneValue() {
        String[] rowArray = {"World", "World", "World", "World", "World", "World"};
        String[] expectArray = {"World"};
        ArrayDuplicate array = new ArrayDuplicate();
        assertThat(array.remove(rowArray), is(expectArray));
    }

    @Test
    public void setArrayWithDuplicateswhenSortArrayThenDuplicatesAtTheEndOfArray() {
        String[] rowArray = {"Hello", "World", "Hello", "And", "Java", "World"};
        String[] expectArray = {"Hello", "World", "Java", "And", "World", "Hello"};
        ArrayDuplicate array = new ArrayDuplicate();
        assertThat(array.bruteDuplicatesSort(rowArray), is(expectArray));
    }

}
