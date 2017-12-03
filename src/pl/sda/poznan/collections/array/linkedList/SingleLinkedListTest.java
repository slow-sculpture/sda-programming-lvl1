package pl.sda.poznan.collections.array.linkedList;

import org.junit.Test;


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
    public void shouldGetByIndexEmpty(){

    }



}