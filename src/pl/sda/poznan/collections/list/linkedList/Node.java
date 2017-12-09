package pl.sda.poznan.collections.list.linkedList;

/**
 * Klasa reprezentujaca jeden wezel listy
 * Kazdy wezel listy (jednokierunkowej)
 * sklada sie z pola danych i wskazania na nastepny elemenet
 */

public class Node<E>{
    //pole przechowujace dane
    private  E value;
    //pole przechowujace wskazanie do kolejnego wezla
    private  Node<E> next;

    //konstruktory
    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this(value);
        this.next = next;
    }

    //gettery i settery
    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
