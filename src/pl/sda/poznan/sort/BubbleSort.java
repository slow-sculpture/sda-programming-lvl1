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
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    ///////  > ///// - to uszereguje od max do min
                    //zamien elementy tablicy
                    //zmienna pomocnicza przechowujaca wartosc
                    int helper = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = helper;
                }
            }
        }
    }

    public static void sortString(String[] array) {
//        String s1 = "ala";
//        String s2 = "pies";
//        int result = s1.compareTo(s2);
        //jezeli sa rowne zwroci 0, w przeciwnym przypadku <0 lub >0 (< >)
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                int result = array[j].compareTo(array[j - 1]);
                if (result < 0) {
                    String helper = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = helper;
                }
            }
        }
    }
}
