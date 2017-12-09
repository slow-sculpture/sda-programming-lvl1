package pl.sda.poznan.collections.array.doublelinkedlist;

import pl.sda.poznan.collections.array.generic.GenericList;

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

    @Override
    public boolean remove(E element) {
        if (!contains(element)) {
            return false;
        }

        Node<E> helper = first;
        Node<E> prev = null;
        Node<E> next = helper.getNext();
        while (helper != null) {
            if (helper.getData().equals(element)) {
                break;
            }
            prev = helper;
            helper.getNext();

        }

        if(helper == first){
            first = first.getNext();
            first.setPrev(null);
        } else if (helper == last){
            last = last.getPrev();
            last.setNext(null);
        } else {
            helper = helper.getNext();

        }


            return true;
        }

        @Override
        public void clear(){

        }

        @Override
        public E get ( int index){
            return null;
        }

        @Override
        public E remove ( int index){
            return null;
        }

        @Override
        public E removeFromEnd () {
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

        public E removeFromBeginning(){
            E delEl = first.getData();
            first = first.getNext();
            first.setPrev(null);
            size--;
            return delEl;
        }

        @Override
        public int indexOf (E element){

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
