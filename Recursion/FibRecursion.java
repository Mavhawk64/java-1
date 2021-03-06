import java.util.Scanner;
/**
 * Recursive form of Fibonacci
 */
public class FibRecursion
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What n term do you want to go to?");
        int n = scan.nextInt();
        long start = System.nanoTime();
        int c = fib(n);
        System.out.println("--Recursive Form--");
        long stop = System.nanoTime() - start;
        System.out.println("FibRecursion: " + c + " Time: " + stop);
    }

    public static int fib (int x)
    {
        //RECURSION!!!
        if( x == 0 )
        {
            return 0; //base case
        }
        else if( x == 1)
        {
            return 1;
        }
        else
        {return fib(x-1) + fib(x-2);
        }
    }
}
