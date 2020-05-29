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
    public void testGetLast() {
            DoubleLinkedList dll = new DoubleLinkedList();
            dll.add(1);
            dll.add(3);
            dll.add(27);
            Assert.assertEquals(27, dll.getLast());
    }

    @Test(expected=NoSuchElementException.class)
    public void testExceptionGetLast() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.getLast();
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

    @Test
    public void testAddRemove() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add("one element");
        dll.add(null);        
        dll.remove(null);        
        dll.remove("other");
        dll.remove("one element");
    }

    @Test(expected=java.lang.IndexOutOfBoundsException.class)
    public void testRemove() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.remove(-1);
    }

    @Test(expected=java.lang.IndexOutOfBoundsException.class)
    public void testRemove2() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.remove(1);
    }    

    @Test
    public void testIndexOf() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(null);        
        Assert.assertEquals(2, dll.indexOf(null));
    }

    @Test
    public void testIndexOf2() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add(1);
        dll.add(null);        
        dll.add(2);
        Assert.assertEquals(-1, dll.indexOf(3));
    }        

}
