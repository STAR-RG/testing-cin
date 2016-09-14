package geometry;

import org.junit.Test;
import org.junit.Assert;

public class tritypTest {

    @Test
    public void testEqualateral() {
        Assert.assertEquals(trityp.type(1,1,1), 3);
    }

    @Test
    public void testIsosceles() {
        Assert.assertEquals(trityp.type(4,5,4), 2);
    }

    @Test
    public void testIsosceles2() {
        Assert.assertEquals(trityp.type(10,10,2), 2);
    }    

    @Test
    public void testNotTriangle1() {
        Assert.assertEquals(trityp.type(2,1,3), 4);
    }

    @Test
    public void testNotTriangle2() {
        Assert.assertEquals(trityp.type(0,0,0), 4);
    }

    @Test
    public void testNotTriangle3() {
        Assert.assertEquals(trityp.type(1,1,3), 4);
    }

    @Test
    public void testNotTriangle4() {
        Assert.assertEquals(trityp.type(0,1,1), 4);
    }

    @Test
    public void testNotTriangle5() {
        Assert.assertEquals(trityp.type(1,0,1), 4);
    }

    @Test
    public void testNotTriangle6() {
        Assert.assertEquals(trityp.type(1,1,0), 4);
    }


}
