import java.util.*;
/**
 * Write a description of class JavaTestin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JavaMath
{
    static long x;
    static long y;
    static long n;
    public static void main (String [] args)
    {
        /**
        for(int i = 1; i < 1001;)
        {
            i+= 2*i-i;
            System.out.println(i);
        }
        System.out.println(Math.pow(2, 10));
        
        for(int i = 1; i < Math.pow(3, 10);)
        {
            i+= 3*i-i;
            System.out.println(i);
        }
        System.out.println(Math.pow(3, 10));
        */
        //Coding a math.pow question... the long way...
        System.out.println("Enter a number");
        Scanner scan = new Scanner(System.in);
        x = scan.nextLong();
        System.out.println("Enter a power");
        n = scan.nextLong();
        Calc();
        System.out.println("The answer for " + x + "^" + n + " is " + y);
    }
    
    public static long Calc()
    {
        for(long i = 1; i < Math.pow(x, n);)
        {
            i+= x*i-i;
            y = i;
        }
        return y;
    }
}
