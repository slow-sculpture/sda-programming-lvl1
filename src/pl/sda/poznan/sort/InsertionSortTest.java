package pl.sda.poznan.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    @Test
    public void shouldSortArray()  {
        int[] array = {4, 2, 1};
        InsertionSort.sort(array);
        int[] expectedArrayAfterSorting = {1, 2, 4};
        assertArrayEquals(expectedArrayAfterSorting, array);
    }

}