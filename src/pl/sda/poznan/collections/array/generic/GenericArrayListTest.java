package pl.sda.poznan.collections.array.generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericArrayListTest {
    @Test
    public void size() {
        GenericList<String> list = new GenericArrayList<>();
        list.add("sth");

        GenericList<Integer> genericList = new GenericArrayList<Integer>();
        ///boxing & unboxing
        int liczba = 5;
        Integer wiek = 5;

        genericList.add(liczba);
        genericList.add(wiek);

        Integer wynikObliczen = 5;  //boxing
        int wartoscPryimtywna = wynikObliczen;  //unboxing



    }

}