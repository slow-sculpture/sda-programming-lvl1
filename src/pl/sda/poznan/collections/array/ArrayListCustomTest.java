package pl.sda.poznan.collections.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayListCustomTest {

    /*
    Klasa testowa
    najechac na klase w kodzie - go to - test
    wybieramy junit4 - fix - ok
    import
    @Test
     */

    @Test
    public void shouldRemoveElement(){
        MyList stringList = new ArrayListCustom();
        stringList.add("Joe");
        stringList.add("Ross");
        stringList.add("Rachel");
        String deleted = stringList.removeFromEnd();
        //powyzej wykonuje kod ktory chce przetestowac

        //prosze junit o sprawdzenie czy wykonane operacje zakoczyly sie
        //zgodnie z zalozeniami
        //metoda assertEquals sprawdza wynik testu
        //jesli porownanie wynikow sie nie zgadza
        //to test zakonczy sie niepowodzeniem
        //perwsze parametr - to co oczekujemy
        //drugi parametr - faktyczna wartosc ktora zwraca funkcja
        assertEquals(2, stringList.size());
        assertEquals("Rachel", deleted);
    }

    //Test w ktorym usuwamy  pustej listy
    //To jest sytuacja wyjatkowa wiec oczekujemy ze skonczy sie wyrzuceniem wyjatka
    //nie umieszczamy bloku try-catch
    //tylko informuje junit. ze oczekuemy tego wyjatku
    //i test ma sie zakocznyc powodzeniem jest taki wyjatek zostanie rzucony
    //informujemy o tym fakcie podajac nazwe wyjatkuu jako argument adnotacji
    //w expected przy wyjatku piszemy klase wyjatku jaka oczekuje a nie wartosc z funkcji
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGetErrorWhenListEmpty(){
        MyList stringList = new ArrayListCustom();
        stringList.removeFromEnd();
    }

    ////////////to samo do metody contain

    @Test
    public void should_contain_element(){
        MyList list = new ArrayListCustom();
        list.add("Ala");
        boolean isElementPresent = list.contains("Ala");
        assertEquals(true, isElementPresent);
    }

    @Test
    public void shouldNotContainElement(){
        MyList list = new ArrayListCustom();
        boolean isPresent = list.contains("Ala");
        assertEquals(false, isPresent);
    }

    @Test
    public void shouldDeleteByIndex(){
        MyList list = new ArrayListCustom();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        String removed = list.remove(4);

        assertEquals("e", removed);
        assertEquals(4,list.size());
    }

    @Test
    public void shouldDeleteByName(){
        MyList list = new ArrayListCustom();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        boolean result = list.remove("c");
        assertEquals(true, result);
        assertEquals(2, list.size());
    }

    @Test
    public void shouldAddInSelectedIndex(){
        MyList list = new ArrayListCustom();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add(2, "ELEMENT");
        assertEquals(8,list.size());
        assertEquals("ELEMENT", list.get(2));
        System.out.println(list.get(2));
        System.out.println(list.get(0));
    }

}