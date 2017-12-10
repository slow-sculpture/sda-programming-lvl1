package pl.sda.poznan.collections.list.generic;

import java.util.Arrays;

public class GenericArrayList<E> implements GenericList<E> {

    //////////////////////////////// to samo jest w ArrayListCustom
    private Object[] values;    //na razie dajemy typu Object bo zeby dac E trzeba sie posluzyc mechanizmem refleksji ktory bedzie pozniej
    private int size;
    private static final int INITIAL_SIZE = 20;

    public GenericArrayList() {
        this.size = 0;
        values = new Object[INITIAL_SIZE];
    }

    public GenericArrayList(int size) {
        this.size = 0;
        this.values = new Object[size];
    }

    /////////////////////////////////////////////////////////////
    @Override
    public int size() {
        return this.size;
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
        if (size == values.length) {
            values = Arrays.copyOf(values, size * 2);
        }
        values[size++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkRange(index);
        if (size == values.length) {
            values = Arrays.copyOf(values, size * 2);
        }
        Object[] restOfArray = Arrays.copyOfRange(values, index, size);
        values[index] = element;
        size++;
        int j = 0;
        for (int i = index + 1; i < size; i++) {
            values[i] = restOfArray[j];
            j++;
        }

    }

    @Override
    public boolean remove(E element) {
        int i = indexOf(element);
        E deleted = remove(i);
        return deleted != null;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Object toDelete = values[index];
        values[index] = null;
        Object[] restOfArrays = Arrays.copyOfRange(values, index + 1, size);
        size--;
        int j = 0;
        for (int i = index; i < size; i++) {
            values[i] = restOfArrays[j++];
        }
        values[size] = null;
        return (E) toDelete;
    }

    @Override
    public void clear() {
        size = 0;
        int newSize = values.length;
        values = null;
        values = new Object[newSize];
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return (E) this.values[index];
    }




    @Override
    //former removeFromEnd
    public E remove() {
        int indexOfLastElement = size - 1;
        Object toDelete = values[size];
        values[indexOfLastElement] = null;
        size--;
        return (E) toDelete;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }
}
