package pl.sda.poznan.collections.tree;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    Tree<Integer> tree = new BinarySearchTree<>();
    @Test
    public void insert() {

        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(13);
        tree.insert(18);
        tree.insert(23);

        System.out.println();
    }

    @Test
    public void insertRandomValues(){
        Random random = new Random();
        for(int i = 0; i<20; i++){
            tree.insert(random.nextInt(100));

        }
        tree.traversal();
    }

    @Test
    public void shouldFindMaxElement(){
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(13);
        tree.insert(18);
        tree.insert(23);

        int max = tree.getMax();
        assertEquals(23, max);
    }

    @Test
    public void shouldFindMinElement(){
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(13);
        tree.insert(18);
        tree.insert(23);

        int min = tree.getMin();
        assertEquals(5, min);
    }



}