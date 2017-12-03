package pl.sda.poznan.collections.array.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SingleLinkedListTest {
    @Test
    public void add() {
        SingleLinkedList<Person> people = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Bob");
        Person zul = new Person("Witek");
        Person zul2 = new Person("Czarek");

        people.add(kierownik);
        people.add(dyrektor);
        people.add(zul);
        people.add(zul2);
        assertEquals(4, people.size());
        people.print();
        System.out.println();


    }

    @Test
    public void shouldGetByIndex(){
        SingleLinkedList<Person> list = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Bob");
        Person zul = new Person("Witek");
        Person zul2 = new Person("Czarek");
        list.add(kierownik);
        list.add(dyrektor);
        list.add(zul);
        list.add(zul2);

        Person personByIndex = list.get(1);
        System.out.println(personByIndex);

    }

    @Test
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

    /////////////

    /////////////

    @Test
    public void shouldDeleteByReference(){
        SingleLinkedList<Person> list = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Bob");
        Person zul = new Person("Witek");
        Person zul2 = new Person("Czarek");
        list.add(kierownik);
        list.add(dyrektor);
        list.add(zul);
        list.add(zul2);

        list.remove(zul);
        assertEquals(3, list.size());
        assertEquals(-1, list.size());
    }

}