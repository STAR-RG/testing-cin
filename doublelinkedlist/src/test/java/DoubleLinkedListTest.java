import org.junit.Test;
import org.junit.Assert;

import java.util.NoSuchElementException;

public class DoubleLinkedListTest {

    @Test(expected=NoSuchElementException.class)
    public void testFirstAtEmptyList() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.getFirst();
    }


    @Test
    public void testAddOne() {
        DoubleLinkedList dll = new DoubleLinkedList();
	dll.add("one element");
        dll.getFirst();
    }

    @Test
    public void testAddAll() {
        DoubleLinkedList dll = new DoubleLinkedList();
	java.util.Collection col = java.util.Arrays.asList("one element");
	dll.addAll(0, col);
    }

    @Test
    public void testAddAllWithEmptyCollection() {
        DoubleLinkedList dll = new DoubleLinkedList();
	java.util.Collection col = new java.util.ArrayList();
	dll.addAll(0, col);
    }

    @Test
    public void testAddAllAtEnd() {
        DoubleLinkedList dll = new DoubleLinkedList();
	dll.add("one element");
	java.util.Collection col = java.util.Arrays.asList("another element");
	dll.addAll(0, col);
    }




}