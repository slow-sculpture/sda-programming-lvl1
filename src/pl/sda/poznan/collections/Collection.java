package pl.sda.poznan.collections;

//ogolny interfejs dla kolekcji zawierajacy metody wspolne dla wszystkich przypadkow

public interface Collection<E> {
    int size();

    boolean isEmpty();

    boolean contains(E element);

    boolean add(E element);

    E remove();

    void clear();

}
