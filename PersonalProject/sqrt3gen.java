import java.util.*;
/**
 * Write a description of class sqrt3gen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class sqrt3gen
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Root 2 Generator!\nEnter amount of iterations:");
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        //m = new MathContext(500);
        for(long i = 1; i <= x; i++)
        {
            String it = String.format("Iteration: %4d", i);
            //System.out.println(it + ", Approximation: " + sqrt2B(new BigDecimal("1", m), i));
            System.out.println(it + ", Approximation: " + sqrt3(1, i));
        }
    }

    public static double sqrt3(double x, long i)
    {
        return i==1 ? x : i==2 ? x+1 : i%2 == 0 ? sqrt3(1/(2+x),--i) : sqrt3(1/(1+x),--i);
    }
}
