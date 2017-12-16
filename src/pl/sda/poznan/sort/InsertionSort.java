package pl.sda.poznan.sort;

/**
 * Sortowanie przez wstawianie - analogia do ukladania kart
 * Na poczatku zakladamy ze z lewej strony mamy zbiot 1el ju zposortowany -> i = 1
 * z prawej strony zbior nieposortowany
 * wybieramy jeden el ze zbioru nieposortowanego -> j
 * i proboujemy wstawic do zbioru posortowanego
 * jezeli napotkamy mniejszy elemeny to zamieniamy elementy
 */

public class InsertionSort {
    public static void sort(int[] arr) {
        //zaczynamy od pierwszego elementu bo pierwszy juz jest posortowany
        for (int i = 1; i < arr.length; i++) {
            //przechodzimy przez zbior posortowany od tylu
            //wazne! j>0 po porownujemy j-1
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int helper = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = helper;
                }
            }
        }
    }
}
