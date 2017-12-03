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
        //1. przypadek - lista jest pusta (if)
        //2. przypadek - lista ma elementy (else)
        if (head == null) {
            //obslugujemy przypadek pustej listy - wstawiamy 1st element
            //jezeli lista jest pusta to stworz nowy wezel i ustaw referencje HEAD
            //na nowy wezel - kniec
            head = new Node<E>(element);
        } else {
            //wywolaj metode dodarwania n apoczatek lub konec - wybierz 1 wersje
            insertDataAtBeginning(element);
            //insertDataAtEnd(element);
        }
        return false;
    }

    private void insertDataAtBeginning(E element) {
        //utworz nowy wezel
        Node<E> newNode = new Node<>(element);
        //ustaw nastepnik nowego wezla na stare wskazanie glowy
        newNode.setNext(head);
        //zaktualizuj/przestaw stara wartosc glowy na nowy element
        head = newNode;
        //newNode(HEAD) -> OLD HEAD -> NULL

        //zlozonosc obliczeniowa O(1) stala
        // duzo wydajniejsza niz end czy ArrayList
    }

    private void insertDataAtEnd(E element) {
        //zmienna pomocnicz do iterowania po liscie
        //na poczatku ustawiamy ja na glowe listy
        //helper i head wskazuja na pocztek listy
        //zmienna helper jes tpotrzeban aby nie stracic referencji z HEAD
        //teraz helper i head pokazuja na pierwszy element listy
        Node<E> helper = head;

        //sprawdzamy czy el ma nastepnik -> jezeli tak to przestaw helper na nastepnik
        //w przeciwym przypadku dotarlismy do konca listy -> mozemy wstawic element
        while (helper.getNext() != null) {
            helper = helper.getNext();
        }

        //wstawianie elementu
        //utworz nowy wezel
        //teraz helper pokazduja na aktualnie ostatni element wiec ustaw wskaznik next
        //ostatniego elementu na newNode
        Node<E> newNode = new Node<>(element);
        helper.setNext(newNode);

        //operacja ma zlozonosc obliczeniowa O(n) zalezna od iloci elementow
    }

    @Override
    public void add(int index, Object element) {

    }


    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        //spr czy operujemy na dobrym zakresie
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Wrong index");
        }

        //jezeli mamy jakis el to szuakmy go na liscie przechodzac przez jego wezly
        int i = 0;
        Node<E> helper = head;
        //wykonuj tak dlugo az znajdziesz index szukanego el
        while (i != index) {
            helper = helper.getNext();
            i++;
        }
        //zwroc wartosc z listy
        return helper.getValue();
    }

    /**
     * W tej implementacji kazdy element tylko wskazanie na nastepny element
     * wiec potrzebujemy dwoch referencji - jednej na znalezienie el do usuniecia
     * a drugiej na el poprzedzajacy
     * wiec helper ustawiamy na glowe a prev na null
     * poniewaz poprzednik glowy ma wartosc null
     *
     * @param element
     * @return
     */
    @Override
    public boolean remove(E element) {
        //jezeli nie mamy takiego el w kolekcji to zwroc false
        if (!contains(element)) {
            return false;
        }
        Node<E> helper = head;
        Node<E> prev = null;  //poprzedni element
        while (helper != null) {
            if (helper.getValue().equals(element)) {
                break;
            }
            prev = helper;
            helper = helper.getNext();

        }
        //jezeli poprzednik wynosi null -> to oznacza ze mamy skasowac glowe
        //wiec referencje head przestawiamy o jeden el dalej
        //w przciwnym przypadku w poprzedniku usuwanego el ustawaimy jego nastepnik
        //na wartosc nastepnika aktualnie usuwanego elementu

        if (prev == null) {
            head = helper.getNext();

        } else {
            prev.setNext(helper.getNext());
        }
        //wstaw null do referencji helper -> garbage collector usunie obiekt z pamieci
        helper = null;
        size--;
        return true;
    }

    @Override
    public E remove(int index) {
        E element = this.get(index);
        this.remove(element);
        return element;
    }

    @Override
    public E removeFromEnd() {
        return null;
    }

    @Override
    public int indexOf(E element) {

        Node<E> helper = head;
        int index = 0;
        //dopiki nie dojdziesz do konca listy, wykonuj:
        while (helper != null) {
            if (helper.getValue().equals(element)) {
                return index;
            }
            helper = helper.getNext();
            index++;
        }
        return -1;

        //analogiczny zapis prz uzyciu petli for
        /*for (int i = 0; i < size; i++) {
            if (helper.getValue().equals(element)) {
                return i;
            }
            helper = helper.getNext();

        }
        return -1;*/
    }


    public void print() {
        Node<E> helper = head;

        while (helper.getNext() != null) {
            System.out.println(helper.getValue().toString());
            helper = helper.getNext();
        }
        System.out.println(helper.getValue().toString());
    }

}
