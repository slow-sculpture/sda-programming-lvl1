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
    public E remove() {
        size--;
        E elementToDelete = tail.getData();
        tail = tail.getPrev();
        tail.setNext(null);
        return elementToDelete;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    private int indexOf(E element) {

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
