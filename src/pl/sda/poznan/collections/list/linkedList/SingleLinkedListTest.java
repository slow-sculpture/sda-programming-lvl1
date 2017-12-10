package pl.sda.poznan.collections.list.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SingleLinkedListTest {
    @Test
    public void add() {
        SingleLinkedList<Person> people = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        people.add(kierownik);
        people.add(dyrektor);
        people.add(student);
        people.add(pacjent);
        assertEquals(4, people.size());
    }

    @Test
    public void shouldGetByIndex() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        Person personByIndex = peopleList.get(1);
        System.out.println(personByIndex);


    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetByIndexWhenEmptyList() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person personByIndex = peopleList.get(0);
        assertEquals(null, personByIndex);


    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException(){
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person personByIndex = peopleList.get(-5);

    }

    @Test
    public void shouldGetIndexOf() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        peopleList.add(student);
        peopleList.add(pacjent);

        assertEquals(0, peopleList.indexOf(pacjent));
        assertEquals(1, peopleList.indexOf(student));
        assertEquals(2, peopleList.indexOf(dyrektor));
        assertEquals(3, peopleList.indexOf(kierownik));
    }

    @Test
    public void shouldDeleteByReference() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        peopleList.add(student);
        peopleList.add(pacjent);

        peopleList.remove(dyrektor);
        assertEquals(3, peopleList.size());
        assertEquals(-1, peopleList.indexOf(dyrektor));

    }

    @Test
    public void shouldDeleteHeadByReference() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(pacjent);

        peopleList.remove(pacjent);
        assertEquals(1, peopleList.size());
        assertEquals(-1, peopleList.indexOf(pacjent));

    }

    @Test
    public void shouldDeleteLastElementByReference() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        peopleList.add(student);
        peopleList.add(pacjent);

        peopleList.remove(kierownik);
        assertEquals(3, peopleList.size());
        assertEquals(-1, peopleList.indexOf(kierownik));

    }

    @Test
    public void shouldReturnFalseWhenElementIsNotPresent() {
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        peopleList.add(student);

        assertEquals(false, peopleList.remove(pacjent));

    }

    @Test
    public void shouldClearList(){
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(pacjent);

        peopleList.clear();
        assertEquals(0, peopleList.size());
    }

    @Test
    public void shouldRemoveFromEnd(){
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        peopleList.add(student);
        peopleList.add(pacjent);

        peopleList.remove();
        assertEquals(3, peopleList.size());
    }

    @Test
    public void shouldInsertWithIndex(){
        SingleLinkedList<Person> peopleList = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Adam");
        Person student = new Person("Kasia");
        Person pacjent = new Person("Ewelina");
        peopleList.add(kierownik);
        peopleList.add(dyrektor);
        peopleList.add(student);
        peopleList.add(0,pacjent);
        assertEquals(pacjent, peopleList.get(0));
        assertEquals(4, peopleList.size());
    }

}