package geometry;

import java.util.Scanner;

//Jeff Offutt -- Java version Feb 2003
//The old standby: classify triangles
//Figures 3.2 and 3.3 in the book.

public class trityp
{
    // ====================================
    // The main triangle classification method
    public static int type(int Side1, int Side2, int Side3)
    {
        int tri_out;
        // tri_out is output from the routine:
        //    Triang = 1 if triangle is scalene
        //    Triang = 2 if triangle is isosceles
        //    Triang = 3 if triangle is equilateral
        //    Triang = 4 if not a triangle
        // After a quick confirmation that it's a legal
        // triangle, detect any sides of equal length
        if (Side1 <= 0 || Side2 <= 0 || Side3 <= 0)
        {
            tri_out = 4;
            return (tri_out);
        }

        tri_out = 0;
        if (Side1 == Side2)
            tri_out = tri_out + 1;
        if (Side1 == Side3)
            tri_out = tri_out + 2;
        if (Side2 == Side3)
            tri_out = tri_out + 3;
        if (tri_out == 0)
        {  // Confirm it's a legal triangle before declaring
            // it to be scalene

            if (Side1+Side2 <= Side3 || Side2+Side3 <= Side1 ||
                    Side1+Side3 <= Side2)
                tri_out = 4;
            else
                tri_out = 1;
            return (tri_out);
        }

        /* Confirm it's a legal triangle before declaring  */
        /* it to be isosceles or equilateral  */

        if (tri_out > 3)
            tri_out = 3;
        else if (tri_out == 1 && Side1+Side2 > Side3)
            tri_out = 2;
        else if (tri_out == 2 && Side1+Side3 > Side2)
            tri_out = 2;
        else if (tri_out == 3 && Side2+Side3 > Side1)
            tri_out = 2;
        else
            tri_out = 4;
        return (tri_out);
    } // end Triang
}
