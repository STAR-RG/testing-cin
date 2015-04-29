package example;

import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BinarySearchTest {

    
    int[] a = new int[]{1,3,5,7,9,13,20,55,127,255};

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

}