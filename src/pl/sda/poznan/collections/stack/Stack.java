package pl.sda.poznan.collections.stack;

public class Stack<E> {
    //stos - lista gdzie dodajemy i usuwamy tylko na koncu
    //LIFO ostatni przyszedl pierwszy wyjdzie

    private Node<E> top;
    private int size = 0;

    //odkladanie elementu na stos
    public void push(E element) {
        //Pierwsza wersja
        Node<E> newNode = new Node<>(element);
        newNode.setPrev(top);
        top = newNode;
        size++;

        //Druga wersja
        //1. pusty
        //2. jest jakis element
       /* if (top == null)
            top = new Node<>(element);
        else {
            Node<E> newNode = new Node<>(element);
            newNode.setPrev(top);
            top = newNode;
        }
        size++;*/
    }

    //pobieranie elementu ze stosu
    //zawsze pobieramy szczyowy element
    //wiec metoda nie przejmuje argumentu
    public E pop() {
        if (top == null)
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        Node<E> toDel = top;
        top = top.getPrev();
        size--;
        return toDel.getData();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    //usuwa wszystkie elementy
    public void clear() {
        top = null;
        size = 0;
    }

    //zwraca element top bez usuwania
    public E peak() {
        if (top == null)
            return null;
        return top.getData();

        //lub tak:
        //return isEmpty() ? null : top.getData();
    }

    //czy el wystepuje na stososie - jezeli tak to ile el od top
    //jezeli na szczycie - retunr 1
    //jezeli drugi itd - return 2 itd
    //jesli nie - return -1
    public int search(E element) {
        int positionFromTop = 1;
        Node<E> helper = top;
        for (int i = size - 1; i >= 0; i--) {
            while (helper != null) {
                if (helper.getData().equals(element)) {
                    return positionFromTop;
                }
                helper = helper.getPrev();
                positionFromTop++;
            }
        }
        return -1;
    }

    public int size() {
        return this.size;
    }
}
