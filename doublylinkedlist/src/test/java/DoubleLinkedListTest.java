import org.junit.Test;
import org.junit.Assert;

import java.util.NoSuchElementException;

public class DoubleLinkedListTest {

    @Test(expected=NoSuchElementException.class)
    public void testCycle() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.getFirst();
    }


}