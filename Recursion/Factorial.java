import java.util.Scanner;
/**
 * The Recursive form of Factorial
 * 
 */
public class Factorial
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What n term do you want to get the factorial of (0 - 15)");
        int n = scan.nextInt();
        long start = System.nanoTime();
        long c;
        if(n == 0 )
        {
            c = 1;
        }
        else
        {
            c = fact(n);
        }
        System.out.println("--Factorial--");
        long stop = System.nanoTime() - start;
        System.out.println("Factorial: " + c + " Time: " + stop);
    }

    public static int fact (int x)
    {
        //RECURSION!!!
        if( x == 1)
        {
            return 1;
        }
        else
        {
            return fact(x-1)*x;
        }
    }
}
