import java.util.*;
import java.io.*;
/**
 * This class checks to see if the numerator is higher than the denominator, and if it isn't,
 * it does the Geometric sum of the series
 * Σ, ∞
 * 
 * The asFraction and gcm methods are used from Stack Overflow:
 * https://stackoverflow.com/a/6619618
 */
public class GeometricSum
{
    public static void main (String [] args)
    {
        System.out.println("Hello, and welcome to the Geometric Series' Sum Calculator!!!");
        System.out.println("Enter a number (above 0): ");
        Scanner si = new Scanner(System.in);
        int x = si.nextInt();
        System.out.println("Enter another number (above 0): ");
        int y = si.nextInt();
        if(y == 0)
            y = 1;
        System.out.println("Enter your starting value (n)");
        int n = si.nextInt();
        System.out.println("Your Geometric Series looks like this: ");
        //Checking to see how many digits in x or y
        String xs = Integer.toString(x);
        String ys = Integer.toString(y);

        char [] dash;
        char [] space1;
        char [] space2;
        space1 = new char[(xs.length()-1)/2];
        space2 = new char[(ys.length()-1)/2];
        if(xs.length() >= ys.length())
            dash = new char [xs.length()];
        else
            dash = new char[ys.length()];
        
        for(int i = 0; i < dash.length; i++)
        {
            dash[i] = '-';
        }

        for(int i = 0; i < space1.length; i++)
        {
            space1[i] = ' ';
        }

        for(int i = 0; i < space2.length; i++)
        {
            space2[i] = ' ';
        }
        //This will only be printed if the bottom is bigger
        //if(d.isBigger)... d = denominator
        if(x<y)
        {
            //ASCII Art
            System.out.println("\n\n\n\n\n\n");
            System.out.println("                      ∞                  ");
            System.out.println("  ----------------------------------------");
            System.out.println("  \\                                       \\");
            System.out.println("   \\                                       \\");
            System.out.println("    \\");
            System.out.println("     \\");
            System.out.println("      \\");
            System.out.println("       \\                                      ");
            System.out.print("        \\                                 ");
            /*for(int i = 0; i < space1.length; i++)
            System.out.print(space1[i]);
             */
            System.out.print("/");
            if(ys.length() != xs.length())
            {
                for(int i = 0; i < ys.length()/2; i++)
                    System.out.print(" ");
                System.out.print(x);
                for(int i = 0; i < ys.length()/2; i++)
                    System.out.print(" ");
            }
            else
                System.out.print(x);
            System.out.println("\\   n");
            System.out.print("        /                                (-");
            for(int i = 0; i < dash.length; i++) //good
                System.out.print(dash[i]);
            System.out.println("-)");
            System.out.print("       /                                  ");
            /* for(int i = 0; i < space2.length; i++)
            System.out.print(space2[i]);
             */
            System.out.println("\\" + y + "/");
            System.out.println("      /");
            System.out.println("     / ");
            System.out.println("    /  ");
            System.out.println("   /   ");
            System.out.println("  /                                       /");
            System.out.println(" /                                       /");
            System.out.println(" ---------------------------------------- ");
            System.out.println("                     n=" + n);

        }

        //This is when the numerator is bigger
        //if(!d.isBigger)... d = denominator
        else if(x>=y)
        {
            //ASCII Art
            System.out.println("\n\n\n\n\n\n");
            System.out.println("                      ∞                  ");
            System.out.println("  ----------------------------------------");
            System.out.println("  \\                                       \\");
            System.out.println("   \\                                       \\");
            System.out.println("    \\");
            System.out.println("     \\");
            System.out.println("      \\");
            System.out.println("       \\                                      ");
            System.out.print("        \\                                 ");

            System.out.println("/" + x + "\\   n");
            System.out.print("        /                                (-");
            for(int i = 0; i < dash.length; i++) //good
                System.out.print(dash[i]);
            System.out.println("-)");
            System.out.print("       /                                  ");

            System.out.print("\\");
            if(ys.length() != xs.length())
            {
                for(int i = 0; i < xs.length()/2; i++)
                    System.out.print(" ");
                System.out.print(y);
                for(int i = 0; i < xs.length()/2; i++)
                    System.out.print(" ");
            }
            else
                System.out.print(y);
            System.out.println("/");
            System.out.println("      /");
            System.out.println("     / ");
            System.out.println("    /  ");
            System.out.println("   /   ");
            System.out.println("  /                                       /");
            System.out.println(" /                                       /");
            System.out.println(" ---------------------------------------- ");
            System.out.println("                     n=" + n);
        }

        System.out.println("\n\n\n\n\n\n");

        //Sum findings
        //      (5/2)/(3/4)
        //       20/6

        //       (x/y)/(z/a)
        //        (a*x)/(z*y)

        //      a/(1-r)

        /*
         * 
         *        (x/y)^n
         *        --------
         *        1 - x/y
         *        
         *        
         *          x^n
         *          ---
         *          y^n
         *        -------
         *          y-x
         *          ---
         *           y
         *           
         *           
         *           
         *                 x^n
         *         ------------------
         *          (y^(n-1)) * (y-x)
         */
        double sumd = Math.pow(x, n) / ((Math.pow(y, n-1) * (y-x)));
        if(x>=y)
            System.out.println("Σ = ∞, divergent, or undefined");
        else if(n == 0)
            System.out.println("Σ = " + asFraction(y, y-x) + " or " + sumd);
        else if(x == 0)
            System.out.println("Σ = 0");
        else
            System.out.println("Σ = " + asFraction(((long)Math.pow(x, n)), (long)((long)(Math.pow(y, n-1) * (y-x)))) + " or " + sumd);
    }

    /** @return the greatest common denominator */
    //from stackoverflow
    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    /**@return longs as Fractions as a String*/
    public static String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }
}
