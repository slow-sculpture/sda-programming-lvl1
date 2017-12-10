package pl.sda.poznan.collections.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue<String> kolejka = new Queue<>();
    private Queue<Integer> kolejka2 = new Queue<>();

    @Test
    public void shouldReturnSize(){
        assertEquals(0, kolejka.size());
        kolejka.add("1st");
        kolejka.add("2nd");
        assertEquals(2, kolejka.size());
    }

    @Test
    public void contains()  {
        kolejka.add("1st");
        kolejka.add("2nd");
        kolejka.add("3rd");
        kolejka.add("4th");
        assertEquals(true, kolejka.contains("2nd"));
    }

    @Test
    public void shouldAddElements()  {
        kolejka.add("1st");
        kolejka.add("2nd");
        kolejka.add("3rd");
        kolejka.add("4th");
        assertEquals(4, kolejka.size());

        kolejka2.add(2);
        kolejka2.add(4);
        kolejka2.add(5);
        assertEquals(3, kolejka2.size());
    }

    @Test
    public void shouldRemoveElement() {
        kolejka.add("1st");
        kolejka.add("2nd");
        kolejka.add("3rd");
        kolejka.add("4th");

        kolejka.remove();
        assertEquals(3, kolejka.size());
    }

    @Test
    public void shouldClearQueue() {
        kolejka.add("1st");
        kolejka.add("2nd");
        kolejka.add("3rd");
        kolejka.add("4th");

        kolejka.clear();
        assertEquals(0, kolejka.size());
    }

    @Test
    public void shouldReturnIndexOfElement(){
        kolejka.add("1st");
        kolejka.add("2nd");
        kolejka.add("3rd");
        kolejka.add("4th");
        assertEquals(2, kolejka.indexOf("3rd"));
    }

}