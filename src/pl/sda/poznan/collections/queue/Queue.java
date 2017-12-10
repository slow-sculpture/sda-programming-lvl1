package pl.sda.poznan.collections.queue;

import pl.sda.poznan.collections.Collection;

/**
 * Kolejka - struktura danych gdzie dodajemy elemeny na koncu
 * a usuwamy na poczatku
 * Kolejka do list FIFO 1st in 1st out
 * Element ktory trafi na koniec bedzie obsluzony ostatni
 * @param <E>
 */

public class Queue<E> implements Collection<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    //dodanie ostatniego elementu do kolejki
    public boolean add(E element) {
        size++;
        if (head == null){
            head = new Node<>(element);
            tail = head;
        } else {
            Node<E> newNode = new Node<>(element);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        return true;
    }

    @Override
    //usuwanie pierwszego elementu z kolejki
    public E remove() {
        E elementToDelete = head.getData();
        head = head.getNext();
        head.setPrev(null);
        size--;
        return elementToDelete;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    public int indexOf(E element) {

        Node<E> helper = head;
        int index = 0;
        while (helper != null) {
            if (helper.getData().equals(element)) {
                return index;
            }
            helper = helper.getNext();
            index++;
        }
        return -1;
    }
}
