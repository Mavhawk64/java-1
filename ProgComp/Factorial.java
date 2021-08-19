import java.util.*;
/**
 * Write a description of class Factorial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Factorial
{
    public static void main ()
    {
        System.out.println("Give me a whole number, and I will take the factorial of it. Current Max: 20");
        Scanner num = new Scanner(System.in);
        long x = num.nextInt();
        long y = x;
        if(x > 1)
        {
            for(long i = x; i > 1; i--)
            {
                x = x*(i-1);
            }
            System.out.println(y + "! = " + x);
        }
        else if(x == 2)
            System.out.println("2! = 2");
        else if( x == 1)
            System.out.println("1! = 1");
        else if(x == 0)
            System.out.println("0! = 1");
        else
            System.out.println("Sorry, I cannot compute " + x + "!");
            main();
    }
}
