package geometry;

import org.junit.Test;
import org.junit.Assert;

public class TriangleTest {

    private void check(Triangle tri, TriangleType expectedType) {
        Assert.assertFalse(tri.getType().ordinal() == expectedType.ordinal());
    }
    
    @Test
    public void testEqualSizes() {
        check(new Triangle(1,1,1), TriangleType.ERROR);
    }

    @Test
    public void testZeros() {
        check(new Triangle(0,0,0), TriangleType.ERROR);
    }

}