package geometry;

public class Triangle {
    
    int a, b, c;
    
    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    
    TriangleType getType()
    {
        if(a<=0 || b<=0 || c<=0)
            throw new IllegalArgumentException("Length of sides cannot be equal to or less than zero");
        
        if(a==b && b==c && c==a)
            return TriangleType.EQUILATERAL;
        else if(a==b || b==c || c==a)
            return TriangleType.ISOSCELES;
        else if(a!=b && b!=c && c!=a)
            return TriangleType.SCALENE;
        else
            return TriangleType.ERROR;
    }
    
}

enum TriangleType {
    ISOSCELES, EQUILATERAL, SCALENE, ERROR;
}