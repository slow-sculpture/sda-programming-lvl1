package pl.sda.poznan.collections.list.doublelinkedlist;

import pl.sda.poznan.collections.list.generic.GenericList;

public class DoubleLinkedList<E> implements GenericList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public DoubleLinkedList() {
        size = 0;
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
        if (first == null) {
            first = new Node<>(element);
            last = first;
        } else {
            insertDataAtEnd(element);
        }

        return true;
    }

    private void insertDataAtBeginning(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(first);
        first.setPrev(newNode);
        first = newNode;
    }

    private void insertDataAtEnd(E element) {
        Node<E> newNode = new Node<>(element);
        last.setNext(newNode);
        newNode.setPrev(last);
        last = newNode;
    }

    @Override
    public void add(int index, E element) {
        Node<E> current = getNodeByIndex(index);
        size++;
        if (current == first) {
            insertDataAtBeginning(element);
        } else if (current == last) {
            insertDataAtEnd(element);
        } else {
            Node<E> prev = getNodeByIndex(index - 1);
            Node<E> next = getNodeByIndex(index + 1);
            Node<E> newNode = new Node<>(element);
            prev.setNext(newNode);
            newNode.setPrev(prev);
            newNode.setNext(next);
            next.setPrev(newNode);

        }
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> helper = first;
        int i = 0;
        while (i != index) {
            helper = helper.getNext();
            i++;
        }
        return helper;
    }

    private Node<E> getNodeByElement(E element) {
        Node<E> helper = first;
        while (helper != null) {
            if (helper.getData().equals(element)) {
                return helper;
            }
            helper = helper.getNext();
        }
        return null;
    }

    @Override
    public boolean remove(E element) {
        if (!contains(element)) {
            return false;
        }
///////////////z zajec/\\\\\\\\\\\\\\\\\\
    /*    Node<E> toDel = getNodeByElement(element);
        //pobierz poprzednik usuwanego elementu
        Node<E> prev = toDel.getPrev();
        //pobierz nastepnik usuwanego elementu
        Node<E> next = toDel.getNext();
        //korekta wiazan
        prev.setNext(next);
        next.setPrev(prev);*/
///////////////////\\\\\\\\\\\\\\\\\\\\\

     ////////////////////////////moje/////////////////
//        Node<E> toDel = first;
//        Node<E> prev = null;
//        while (toDel != null) {
//            if (toDel.getData().equals(element)) {
//                break;
//            }
//            prev = toDel;
//            toDel.getNext();
//        }

        Node<E> current = getNodeByElement(element);
        Node<E> previous = current.getPrev();
        if (current == first) {
//            first = first.getNext();
//            first.setPrev(null);
            removeFromBeginning();
        } else if (current == last) {
//            last = last.getPrev();
//            last.setNext(null);
            remove();
        } else {
            current = current.getNext();
            current.setPrev(previous);
            previous.setNext(current);
            size--;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if(index<0 || index >=size){
            throw new IllegalArgumentException("Wrong index");
        }
        Node<E> helper = first;
        int i = 0;
        while(i!=index){
            helper = helper.getNext();
            i++;
        }
        return helper.getData();
    }

    @Override
    public E remove(int index) {
        E delEl = this.get(index);
        this.remove(delEl);
        return delEl;
    }

    @Override
    //former removeFromEnd
    public E remove() {
        //dzieki podwojnemu wiazaniu mozliwe jest o wiele szybsze usuwanie

        //pobierz wartosc ostatniego elementu
        E deEl = last.getData();
        //przestaw referencje last na przedostatni element
        last = last.getPrev();
        //nastepnik ostatniego elementu musi wskazywac na null
        last.setNext(null);
        //zmniejsz liste
        size--;
        //zwroc wartosc usuwanego elementu
        return deEl;
    }

    public E removeFromBeginning() {
        E delEl = first.getData();
        first = first.getNext();
        first.setPrev(null);
        size--;
        return delEl;
    }

    @Override
    public int indexOf(E element) {

        Node<E> helper = first;
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
