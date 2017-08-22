package numeric;

import static numeric.Median.median;

import org.junit.Test;
import org.junit.Assert;

public class MoreMedianTest {

    @Test
    public void midIsFirst() {
       Assert.assertEquals(-2, median(-2, -1, -3));
    }

    @Test
    public void midIsSecond() {
       Assert.assertEquals(-2, median(-1, -2, -3));
    }

    @Test
    public void midIsLast() {
       Assert.assertEquals(-2, median(-1, -3, -2));
    }

    @Test
    public void midIsSameLo() {
       Assert.assertEquals(0, median(0, 1, 0));
    }

    @Test
    public void midIsSameHi() {
       Assert.assertEquals(2, median(2, 1, 2));
    }

}
