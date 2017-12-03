package pl.sda.poznan.collections.array.linkedList;

import org.junit.Test;
import pl.sda.poznan.collections.array.generic.GenericList;

public class SingleLinkedListTest {
    @Test
    public void add() {
        GenericList<Person> people = new SingleLinkedList<>();
        Person kierownik = new Person("Jan");
        Person dyrektor = new Person("Bob");
        Person zul = new Person("Witek");
        Person zul2 = new Person("Czarek");

        people.add(kierownik);
        people.add(dyrektor);
        people.add(zul);
        people.add(zul2);
        //people.print();
        System.out.println();
    }

}