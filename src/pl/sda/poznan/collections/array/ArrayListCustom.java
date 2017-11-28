package pl.sda.poznan.collections.array;


import java.util.Arrays;

/**
 * custom - nasza implementacja ArrayList ale wzorowana na gotowej z javy
 * Lista wykorzystujaca tablice, przechowuje wartosci typu String
 * implementacja podobna do klasy java.util.ArrayList
 * Lista powinna miec nastepujace funkcje:
 * a) zwracanie rozmiaru lisy
 * b) odp na pytanie czy lista pusta
 * c) czy list zawiera dany element
 * d) dodawanie elementu na koniec listy
 * e) dodawanie na okreslonej pozycji
 * f) usuwanie po okreslonej wartosci
 * g) wyczyszczenie wszystkich wartosci
 * h) pobieranie po indeksie
 * i) usuwanie po indeksie
 *
 * sygnatury dajemy do interfejsu
 */
public class ArrayListCustom implements MyList {
    private String[] values;
    private int size;                                //zmienna pomocnicza
    private static final int INITIAL_SIZE = 20;      //okreslamy ile pozycji ma miec lista

    public ArrayListCustom() {                         //wykorzystany gdy nieznana liczba el
        this.size = 0;                                //bo typ prymitywny
        this.values = new String[INITIAL_SIZE];        //new bo typ obiektowy
    }

    public ArrayListCustom(int size) {                 //wykorzystany gdy znana liczba el
        this.size = size;
        this.values = new String[size];
    }

    @Override
    public int size() {
        return this.size;          //zwroci 0
        //return value.length;    //zwroci INITIAL_SIZE po utworzeniu nowej listy mimo ze bedzie pusta
    }

    @Override
    public boolean isEmpty() {
        return size == 0;          //zamiast if/else
    }

    @Override
    public boolean contains(String o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(String e) {
        //jezeli mamy pelna tablice
        //przekopiuj stara tablice do nowej 2x wiekszej
        if (size == values.length) {
            values = Arrays.copyOf(values, size * 2);
        }
        values[size++] = e;
        return true;
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public boolean remove(String o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(String s) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
