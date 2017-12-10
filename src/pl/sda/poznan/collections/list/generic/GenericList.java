package pl.sda.poznan.collections.list.generic;

//////////////list generyczna (ogolna) dla dowolnego typu - roboczo typ wskazuje np. T, E

import pl.sda.poznan.collections.Collection;

public interface GenericList<E> extends Collection<E> {

    void add(int index, E element);

    boolean remove(E element);

    E get(int index);

    E remove(int index);

    int indexOf(E element);
}
