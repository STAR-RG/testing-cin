package numeric;

import static numeric.Median.median;

import org.junit.Test;

public class MedianTest {

    @Test public void midIsFirst() {
        median(2, 1, 3);
    }

    @Test public void midIsLast() {
        median(1, 3, 2);
    }
    
    @Test public void midIsMiddle() {
        median(1, 2, 3);
    }

}