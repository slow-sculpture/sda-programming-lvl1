package pl.sda.poznan.collections.array;

public interface MyList {
    /**
     * Zwraca aktualny rozmiar listy
     */
    int size();

    /**
     * Odp na pytanie czy lista jest pusta
     */
    boolean isEmpty();

    /**
     * czy zawiera element
     */
    boolean contains(String o);

    /**
     * dodawanie elementu na koniec listy
     */
    boolean add(String e);

    /**
     * Dodaje element na okreslona pozycje
     */
    void add(int index, String element);

    /**
     * Usuwa element podany jako argument (o ile taki wystepuje)
     */
    boolean remove(String o);

    /**
     * Czysci liste ze wszystkich elementow
     */
    void clear();

    /**
     * Zwraca el po indeksie (pozycji)
     */
    String get(int index);

    /**
     * usuwanie po indeksie
     */
    String remove(int index);

    /**
     * Usuwa element na koncu
     */
    String removeFromEnd();

    /**
     * Zwraca indeks pierwszego wystapienia napisu
     * lub -1 jezeli wartosc nie wystepuje
     */
    int indexOf(String s);
}
