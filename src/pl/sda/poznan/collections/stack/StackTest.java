package pl.sda.poznan.collections.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack<String> stringStack = new Stack<>();

    @Test
    public void shouldPushElement() {
        stringStack.push("1st");
        stringStack.push("2nd");
        stringStack.push("3rd");
        stringStack.push("4th");
        stringStack.push("5th");

        assertEquals(5, stringStack.size());
    }

    @Test
    public void shouldDeleteElement()  {
        stringStack.push("1st");
        stringStack.push("2nd");
        stringStack.push("3rd");
        stringStack.push("4th");
        stringStack.push("5th");

        stringStack.pop();
        assertEquals(4, stringStack.size());
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void peak() throws Exception {
    }

    @Test
    public void shouldGivePositionFromTop()  {
        stringStack.push("1st");
        stringStack.push("2nd");
        stringStack.push("3rd");
        stringStack.push("4th");
        stringStack.push("5th");


        assertEquals(3, stringStack.search("3rd"));
    }

}