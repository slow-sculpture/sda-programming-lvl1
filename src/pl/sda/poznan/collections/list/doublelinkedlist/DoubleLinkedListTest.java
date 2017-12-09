package pl.sda.poznan.collections.list.doublelinkedlist;

import org.junit.Test;
import pl.sda.poznan.collections.list.generic.GenericList;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {
    private GenericList<String> list = new DoubleLinkedList<>();
    @Test
    public void shouldAddFristElement() {

        list.add("First");
        assertEquals(1, list.size());
    }

    @Test
    public void shouldAddManyElements(){
        list.add("First");
        list.add("Second");
        assertEquals(2, list.size());
    }

    @Test
    public void shouldGetIndexOfElement(){
        list.add("First");
        list.add("Second");
        assertEquals(0, list.indexOf("First"));
        assertEquals(1, list.indexOf("Second"));
    }

    @Test
    public void shouldRemoveFromEnd(){
        list.add("First");
        list.add("Second");
        String s = list.removeFromEnd();
        assertEquals(1, list.size());
        assertEquals(s,"Second");
    }

    @Test
    public void shouldRemoveFromBeginning(){
        //poslugujemy sie typem klasy (a nie interfejsu)
        //poniewaz metoda zostala zdefiniowana w klasie
        //a nie w interfejsie

        DoubleLinkedList<String> linkedList = new DoubleLinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        String del = linkedList.removeFromBeginning();
        assertEquals(1, linkedList.size());
        assertEquals(del, "First");
    }

    @Test
    public void shouldReturnFalseIfIsNotPresent(){
        list.add("1st");
        list.add("2nd");
        list.add("3rd");
        list.add("4th");
        list.add("5th");

        boolean result = list.remove("Zero");
        assertEquals(false, result);
    }

    @Test
    public void shouldDeleteByElement(){
        list.add("1st");
        list.add("2nd");
        list.add("3rd");
        list.add("4th");
        list.add("5th");

        boolean result = list.remove("3rd");
        assertEquals(result, true);
        assertEquals(4, list.size());
        assertEquals(false, list.contains("3rd"));
    }

}