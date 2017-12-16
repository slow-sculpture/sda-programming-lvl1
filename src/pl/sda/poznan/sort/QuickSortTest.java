package pl.sda.poznan.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    QuickSort quickSort = new QuickSort();

    @Test
    public void shouldSortArray()  {
        int[] array = {5, 2, 3, 5, 6, 8, 2, 1};
        int[] expectedArrayAfterSorting = {1, 2, 2, 3, 5, 5, 6, 8};
        quickSort.sort(array);
        assertArrayEquals(expectedArrayAfterSorting, array);
    }

}