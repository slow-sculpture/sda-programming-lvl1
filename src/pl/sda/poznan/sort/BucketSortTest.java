package pl.sda.poznan.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BucketSortTest {
    @Test
    public void shouldSortArray(){
        int max = 9;
        int[] array = {5, 3, 3, 5, 6, 7, 8, 9, 9, 9, 1, 1, 3, 2};
        int[] expectedArrayAfterSorting = {1, 1, 2, 3, 3, 3, 5, 5, 6, 7, 8, 9, 9, 9};
        BucketSort.sort(array, max);
        assertArrayEquals(expectedArrayAfterSorting, array);
    }
}