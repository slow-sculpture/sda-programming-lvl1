package pl.sda.poznan.collections.array.linkedList;

import pl.sda.poznan.collections.array.generic.GenericList;

/**
 * Implementacj alisty jednokierunkowej
 * W tej implementacji mamy wskazanie na glowe listy
 * Ostatni element listy ma wskazanaie next ustawione na null - po tym koniec listy
 */

public class SingleLinkedList<E> implements GenericList<E> {
    private Node<E> head;
    private int size;

    public SingleLinkedList() {
        this.size = 0;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean add(E element) {
        size++;
        //1. przypadek - lista jest pusta
        //2. przypadek - lista ma elementy
        if (head == null) { //obslugujemy przypadek pustej listy - wstawiamy 1st element
            head = new Node<E>(element);
        } else {
            insertDataAtBeginning(element);
        }
        return false;
    }

    private void insertDataAtBeginning(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(head);
        head = newNode;

        //zlozonosc obliceniowa O(1) stala
        // duzo wydajniejsza niz end czy ArrayList
    }

    private void insertDataAtEnd(E element) {
        //zmienna pomocnicz do iterowania po liscie
        //na poczatku ustawiamy ja na glowe listy
        //helper i head wskazuja na pocztek listy
        Node<E> helper = head;
        while (helper.getNext() != null) {
            helper = head.getNext();
        }
        Node<E> newNode = new Node<>(element);
        helper.setNext(newNode);

        //operacja ma zlozonosc obliczeniowa O(n) zalezna od iloci elementow
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E removeFromEnd() {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    public void print(E element) {
        Node<E> helper = head;
        while (helper.getNext() != null){
            System.out.println(helper);

        }}

}
