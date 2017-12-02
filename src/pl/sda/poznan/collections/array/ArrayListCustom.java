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
 * <p>
 * sygnatury dajemy do interfejsu
 */
public class ArrayListCustom implements MyList {
    private String[] values;
    private int size;                                //zmienna pomocnicza - .lendgth dalaby NullPointerException - bo przy mniejszej ilosci elementów reszta bylaby nullem ktroy nie ma referencji
    private static final int INITIAL_SIZE = 20;      //okreslamy ile pozycji ma miec lista

    public ArrayListCustom() {                         //wykorzystany gdy nieznana liczba el
        this.size = 0;                                //bo typ prymitywny
        this.values = new String[INITIAL_SIZE];        //new bo typ obiektowy
    }

    public ArrayListCustom(int size) {                 //wykorzystany gdy znana liczba el
        this.size = 0;
        this.values = new String[size];
    }

    @Override
    public int size() {
        return this.size;          //zwroci 0; mozna bez this
        //return value.length;    //zwroci INITIAL_SIZE po utworzeniu nowej listy mimo ze bedzie pusta
    }

    @Override
    public boolean isEmpty() {
        return size == 0;          //zamiast if/else
    }

    @Override
    public boolean contains(String o) {
        //krotki zapis
        //jesli to prawda to zwrocona bedzie wartosc true
        return indexOf(o) >= 0;

        //1. napisanie petli for ktora sprwdza wszyskit el i zwraca true jesli wystepuje
        //2. zauwazanie ze to samo robi metoda indexOf wiec mozna z niej skorzystac

        //dluzszy zapis powyzszego
        /*if (indexOf(o) >= 0) {
            return true;
        } else {
            return false;
        }*/
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
        //spr czy index nie wykracza poza tablice
        checkRange(index);

        //przkopiuj reszte elementow do pomocniczej tablicy
        String[] restOfArray = Arrays.copyOfRange(values, index, size);

        //wstaw nowy el w miejscu index
        values[index] = element;
        size++;

        //przekopiuj stare wartosci na nowe pozycje
        int j = 0;
        for(int i = index+1; i<size; i++){
            values[i] = restOfArray[j];
        }

        //nie zapominaj o zmennej size!

    }

    @Override
    public boolean remove(String o) {
        /*
        mamy usunac el podany jako argument
        wiec funkcja indexOf sprawdzamy jaki ma index
        mamy funkcje ktora usuwa el po indeksie
        wec majac indeks wywolujemy funcje do kasowania po indeksie
        funkcja ta zwraca usuniety el
        wiec jezeli ten el jest rozny od null
        to zakladamy ze kasowanie sie udalo i wynikiem tej funkcji bedzie true
         */
        int i = indexOf(o);
        String deleted = remove(i);
        return deleted != null;
    }

    @Override
    public void clear() {
        //1. Ustawienie rozmiaru na 0 (staly czas wykonania be wzgledu na ilosc elementow)
        // i utworzenie nowej tablicy - stara zostani usunieta
        size = 0;
        int newSize = values.length;  //dotychczasowa wielkosc (moze byc inna niz INITIAL_SIZE bo np zwikszyl uzytkownik a chcemy taka sama tylko usta)
        values = null;  //usuwamy referencje (nie musi byc nastepna linijka zrobi to samo)
        values = new String[newSize];   //przypisanie nowe tablicy - stara usunie garbage collector

        //2. Przejscie z uzyciem petli for (zlozonosc n)
        // i wpisanie wartosci null do kazdego elementu
        /*for (int i = 0; i<size; i++){
            values[i] = null;
        } size = 0;
         */


    }

    @Override
    public String get(int index) {
        checkRange(index);
        return this.values[index];
    }

    @Override
    public String remove(int index) {
        //pomocncza metoda prywatna do sprawdzenia prawidlowego zakresu tablicy
        checkRange(index);
        String toDelete = values[index]; //przechwytujemy wartosc
        values[index] = null;
        String[] restOfArrays = Arrays.copyOfRange(values, index + 1, size);
        size--;
        //kopiowanie reszty tablicy do oryginalenj tablicy
        int j = 0;
        for (int i = index; i < size; i++) {

            values[i] = restOfArrays[j++];
        }
        values[size] = null;
        return toDelete;
    }


    //Pobierz ostatni element do zmiennej pomocnicznej toDelete
    //do tablicy o ostatnim indeksie wpisz null
    //zmniejsz rozmiar o 1
    //zwroc usuniety element
    @Override
    public String removeFromEnd() {
        int indexOfLastElement = size - 1;  //size pokazduje na pierwsze wolne miejsce, a my chcemy usunac ostatni element
        String toDelete = values[size];
        values[indexOfLastElement] = null;
        size--;
        return toDelete;

//        String toDelete = values[size];
//        values[size--] = null;
//        return toDelete;
    }

    /**
     * Metoda zwracajaca pozycje napisu s w liscie
     * Jezeli el wystepuje to zwracamy jego indeks
     * jezeli el nie wystepuje to zwracamy -1
     * Na pewno indeks w tablicy nie bedzie ujemny, wiec mozemy zwrocic -1
     *
     * @param s - szukany element
     * @return
     */
    @Override
    public int indexOf(String s) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }


    /////klasa pomocnicza - refactor-extract-method z remove zrobione
    /////automatycznie podmienilo tez w get
    private void checkRange(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }
}


