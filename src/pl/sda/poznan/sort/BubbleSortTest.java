package pl.sda.poznan.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void shouldSortArray() {
        int[] array = {9, 5, 7, 12, 3};
        BubbleSort.sort(array);
        int[] expectedArrayAfterSorting = {3, 5, 7, 9, 12};
        assertArrayEquals(expectedArrayAfterSorting , array);
    }

}