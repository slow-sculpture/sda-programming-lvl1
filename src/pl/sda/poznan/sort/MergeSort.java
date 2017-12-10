package pl.sda.poznan.sort;

/**
 * Dziel i zwyciezaj
 * rozbicie zbioru danych na pol i znow na pol i znow na pol itd
 * az zostana pojedyncze lementy juz posortowane
 * i parami sortujemy scalajac z powortome w coraz wieksze zbiory az bedzie wszystko
 * <p>
 * 4 5 6 7 8 9 6 4   -> divide
 * 4 5 6 7  _ 8 9 6 4
 * 4 5 _ 6 7 _ 8 9 _ 6 4
 * 4 5 _ 6 7 _ 8 9 _ 4 6
 * 4 5 6 7 _ 4 6 8 9  -> merge
 * 4 4 5 6 6 7 8 9
 */

public class MergeSort {
    //tablica z oryginalnymi danymi
    private int[] numbers;
    //tablica pomocnicza
    private int[] helper;

    //przekopiowanie wartosci i utworzenie tablicy pomocnicznej
    public void sort(int[] values) {
        this.numbers = values;
        this.helper = new int[numbers.length];
        mergesort(0, numbers.length - 1);
    }

    //index najmniejszy i najwiekszy
    private void mergesort(int low, int high) {
        //jezeli index startowy jest mniejszy od indeksu koncowego
        //to tablica ma wieje niz 1 el
        //czyli mozna ja podzielic
        //jezeli tablica bedzie miala 1 el (nie da sie rozdzielic)
        //to low bedzie 0 i high tez bedzie 0
        if (low < high) {
            //oblicz srodkowy index
            int middle = low + (high - low) / 2;
            //posortuj lewa czesc tablicy
            mergesort(low, middle);
            //posortuj prawa czesc tablicy
            mergesort(middle + 1, high);
            //scal
            merge(low, middle, high);
        }
    }

    //algorytm  scalania dwoch tablic
    private void merge(int low, int middle, int high) {
        //przekopiowanie do pomocniczej
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }
        //3 zmienne pomocnicze
        //poczatek lewej tablicy
        int i = low;
        //poczatek prawej tablicy
        int j = middle + 1;
        //do wpisywana do scalonej tablicy - zaczynamy od lewej (low)
        int k = low;
        //tak dlugo az dojdziemy do konca jednej z tablic
        //middle wyznacza konie lewej talibcy
        //jezeli i albo j dojdzie do konca
        //to jeden z warunkow zwroci falsz
        //wiec alternatywa bedzie falszywa
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                //tzn ze lewa strona jest mniejsza
                numbers[k] = helper[i];
                i++;
            } else { //el z prawej jest mniejszy
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while(i<=middle){
            numbers[k] = helper[i];
            i++;
            k++;
        }


    }
}
