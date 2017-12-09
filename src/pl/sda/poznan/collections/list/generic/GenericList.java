package pl.sda.poznan.collections.list.generic;

//////////////list generyczna (ogolna) dla dowolnego typu - roboczo typ wskazuje np. T, E

public interface GenericList<E> {
    int size();
    boolean isEmpty();
    boolean contains(E element);
    boolean add(E element);
    void add(int index, E element);
    boolean remove(E element);
    void clear();
    E get(int index);
    E remove(int index);
    E removeFromEnd();
    int indexOf(E element);
}
