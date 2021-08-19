import java.util.*;
import java.io.*;
/**
 * This is a program that will find the sum of the inverse of the Fibonacci's Sequence/Series.
 * Initially found to whatever term the user inputs.
 */
public class FibInvSum
{
    public static void main (String [] args)
    {
        System.out.println("Welcome to the Fibonacci's Series Calculator!");
        System.out.println("Do you need the list to be printed to the screen (slower, not recommended with large numbers)");
        Scanner sc = new Scanner(System.in);
        String xs = sc.nextLine();
        xs = xs.toLowerCase();
        System.out.println("Please enter an x for the function, F(x)"); 
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong() + 1;
        System.out.println("\n");
        if(xs.contains("y"))
        {
            for(long i = 0; i < x; i++)
            {
                if(i < x-1)
                    System.out.print(F(i) + ", ");
                else
                    System.out.println(F(i));
            }
        }
        System.out.println("\n");
        long y = F(x) + F(x-1) - 1;
        double z = Math.pow(y, -1);
        System.out.println("Sum: " + y);
        System.out.println("Inverse Sum: " + z + " or 1/" + y);
        scan.close();
    }

    public static long F(long x)
    {
        if(x == 0)
            return 0;
        else if(x == 1)
            return 1;
        else
            return F(x-1) + F(x-2);
    }
}
