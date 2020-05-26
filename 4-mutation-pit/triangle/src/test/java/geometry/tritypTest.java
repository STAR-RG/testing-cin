package geometry;

import org.junit.Test;
import org.junit.Assert;

public class tritypTest {

    // @Test
    // public void testEqualateral() {
    //     Assert.assertEquals(trityp.type(1,1,1), 3);
    // }

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

    @Test
    public void testNotTriangle7() {
        Assert.assertEquals(trityp.type(11,5,5), 4);
    }

    @Test
    public void testNotTriangle8() {
        Assert.assertEquals(trityp.type(5,11,5), 4);
    }

    @Test
    public void testNotTriangle9() {
        Assert.assertEquals(trityp.type(1,1,3), 4);
    }

    @Test
    public void testNotTriangle10() {
        Assert.assertEquals(trityp.type(1,3,1), 4);
    }

    @Test
    public void testNotTriangle11() {
        int v = trityp.type(3,1,1);
        Assert.assertEquals(v, 4);
    }

    @Test
    public void testNotTriangle12() {
        int v = trityp.type(1,2,2);
        Assert.assertEquals(v, 2);
    }

    @Test
    public void testNotTriangle13() {
        Assert.assertEquals(trityp.type(4,8,4), 4);
    }

    @Test
    public void testNotTriangle14() {
        Assert.assertEquals(trityp.type(8,4,4), 4);
    }

    @Test
    public void testNotTriangle15() {
        Assert.assertEquals(trityp.type(4,4,8), 4);
    }

    @Test
    public void testNotTriangle16() {
        Assert.assertEquals(trityp.type(2,3,1), 4);
    }

    @Test
    public void testNotTriangle17() {
        Assert.assertEquals(trityp.type(3,2,1), 4);
    }

    @Test
    public void testScalene() {
        Assert.assertEquals(trityp.type(10,8,9), 1);
    }

}
