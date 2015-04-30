package geometry;

import org.junit.Test;
import org.junit.Assert;

public class tritypTest {

    @Test
    public void testEqualSizes() {
        Assert.assertEquals(trityp.type(1,1,1), 3);
    }

    @Test
    public void testZeros() {
        Assert.assertEquals(trityp.type(0,0,0), 4);
    }

    @Test
    public void testImpossible() {
        Assert.assertEquals(trityp.type(1,1,3), 4);
    }

}