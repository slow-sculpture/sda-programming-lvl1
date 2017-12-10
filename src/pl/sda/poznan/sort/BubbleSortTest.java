package pl.sda.poznan.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void shouldSortArray() {
        int[] array = {9, 5, 7, 12, 3};
        BubbleSort.sort(array);
        int[] expectedArrayAfterSorting = {3, 5, 7, 9, 12};
        assertArrayEquals(expectedArrayAfterSorting, array);
    }

    @Test
    public void shouldCompareStrings() {
        String s1 = "Da";
        String s2 = "Df";
        int result = s1.compareTo(s2);
        System.out.println(result);

    }

    @Test
    public void shouldSortArrayOfStrting() {
        String[] array = {"b", "r", "a", "k"};
        BubbleSort.sortString(array);
        String[] expectedArrayAfterSorting = {"a", "b", "k", "r"};
        assertArrayEquals(expectedArrayAfterSorting, array);
    }

}