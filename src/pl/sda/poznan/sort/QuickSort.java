package pl.sda.poznan.sort;

//w srednim przypadku podobny do mergeSort
//w najgorszym n2
//ale ma duzo mniej pamieci
public class QuickSort {
    private int[] numbers;

    public void sort(int[] values) {
        //walidacja - spr czy tablica nie jest pusta
        // || wartosc leniwa - jesli po pierwszym wiadomy jest wynik to drugiego nie sprawdzaj
        // drugi wynik nieistotny -> alternatywa matematyczna
        if (values == null || values.length == 0) {
            //jesli tak to wyjscie z funkcji
            return;
        }
        /*analogiczny zapis jak powyzej
        if(values != null && values.length > 0){
            return;
        }*/

        //jesli doszlismy tutaj to tablica nie jest nullem i posiada elementy
        this.numbers = values;
        quicksort(0, numbers.length - 1);
    }

    private void quicksort(int low, int high) {
        // i -> wskazuje na poczatek lewej listy
        int i = low;
        // j -> wskazuje na koniec prawej listy
        int j = high;
        //wybierz srodkowy element -> pivot
        int midIndex = (low + high) / 2;
        int pivot = numbers[midIndex];
        //przejdz lewa czesc i prawa czesc listy
        //wykonuj tak dlugo az indeksy lewej i prawej polowy sie zejda
        while (i <= j) {
            //szukamy elementu wiekszego od pivota z lewej czesci i mniejszego z prawej
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                //zamien miejscami i oraz j
                int helper = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = helper;
                i++;
                j--;
            }
        }
        //rekurencyjne wywolanie algorytmy
        //zadbac trzeba zeby nie wejsc w nieskonczona rekursje
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }

    }
}
