package geometry;

import java.util.Scanner;

public class Main {

    private static String[] triTypes = { "",    /* Ignore 0 */
        "scalene", "isosceles", "equilateral", "not a valid triangle"};
    
    private static String instructions = "This is the ancient TriTyp program.\nEnter three integers that represent the lengths of the sides of a triangle.\nThe triangle will be categorized as either scalene, isosceles, equilateral\nor invalid\n";
    
    public static void main (String[] argv)
    {  // Driver program for trityp
        int A, B, C;
        int T;

        System.out.println (instructions);
        Scanner input = new Scanner(System.in);
        System.out.println ("Enter side 1: ");
        A = input.nextInt();
        System.out.println ("Enter side 2: ");
        B = input.nextInt();
        System.out.println ("Enter side 3: ");
        C = input.nextInt();
        input.close();

        System.out.print("A=" + A + " B=" + B + " C=" + C);
        T = trityp.type(A, B, C);
        System.out.println(" T=" + T);
        System.out.println ("Result is: " + triTypes [T]);

        // assertions below added to express correctness -- see
        // Yang et al.'s ICSE 2014 paper on iProperty for details

        /*A0*/assert T != 0;

        /*A1*/assert A <= 0 || B <= 0 || C <= 0 ? T == 4 : true;

        /*A2*/assert A + B <= C ? T == 4 : true;
        /*A3*/assert A + C <= B ? T == 4 : true;
        /*A4*/assert B + C <= A ? T == 4 : true;

        /*A5*/assert A == B && B == C && A > 0 ? T == 3 : true;

        /*A6*/assert A == B && A != C && C < A + B && C > 0 ? T == 2 : true;
        /*A7*/assert A == C && A != B && B < A + C && B > 0 ? T == 2 : true;
        /*A8*/assert B == C && B != A && A < B + C && A > 0 ? T == 2 : true;

        /*A9*/assert A != B && A != C && B != C && A + B > C && A + C > B && B + C > A ? T == 1 : true;
    }

}