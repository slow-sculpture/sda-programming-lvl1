package pl.sda.poznan.sort;

/**
 * Sortowanie babelkowe
 * zlozonosc czasowa O(n^2)
 * zlozonosc pamieciowa O(1)
 * porownanie dwoch elementow i ew zamiana miejscami itd
 */
public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j-1]){
                    ///////  > ///// - to uszereguje od max do min
                    //zamien elementy tablicy
                    //zmienna pomocnicza przechowujaca wartosc
                    int helper = array[j];
                    array[j] = array[j-1];
                    array[j-1] = helper;
                }
            }
        }
    }
}
