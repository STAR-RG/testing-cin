package example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class BinarySearchTest {
    
    int[] a;

    @Before
    public void setup() {
        a = new int[]{7,9,1,3,5,13,20,55,255,127};
        Arrays.sort(a);
    }
    
    @Test
    public void elementFound() {
        // junit style
        Assert.assertEquals(2, BinarySearch.binarySearch(a, 5));
        // hamcrest style
        assertThat(BinarySearch.binarySearch(a, 20), is(6));
    }
    
    @Test
    public void elementNotFound() {
        assertThat(BinarySearch.binarySearch(a, 15), is(lessThan(0)));
    }
    
    @Test
    public void emptyArray() {
        assertThat(BinarySearch.binarySearch(new int[]{}, 99), is(lessThan(0)));
    }

    @Test(expected=NullPointerException.class)
    public void nullArray() {
        BinarySearch.binarySearch(null, 99);
    }
    
}
