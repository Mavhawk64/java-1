import java.util.*;
import java.math.*;
/**
 * This is a program that recursively generates digits for the square
 * root of 2.
 * 
 * 1
 * 1+1=2
 * 1+1/(2+1)=1.3333
 * 1+1/(2+1/(2+1))=10/7=1.428571428...
 * 1+1/(2+1/(2+1/(2+1)))=24/17=1.4117647...
 * ...
 * ...=1.41421356237309...
 *
 * @author Maverick Berkland
 * @version 1/20/2021
 */
public class sqrt2gen
{
    public static int mcAsInt;
    public static MathContext m;
    public static int p;
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Root 2 Generator!\nEnter amount of decimals:");
        mcAsInt = (new Scanner(System.in)).nextInt();
        m = new MathContext(mcAsInt);
        System.out.println("Would you like to enter the amount of iterations?");
        String in = (new Scanner(System.in)).nextLine();
        System.out.println("How often would you like to print?");
        p = (new Scanner(System.in)).nextInt();
        if(p == 0)
            p = 2147483647;
        if(in.toLowerCase().contains("y"))
        {
            Scanner scan = new Scanner(System.in);
            long x = scan.nextLong();
            for(long i = 1; i <= x; i++)
            {
                if(i%p == 0)
                {
                    String it = String.format("Iteration: %4d", i);
                    System.out.println(it + ", Approximation: " + sqrt2B(new BigDecimal("1", m), i));
                }//System.out.println(it + ", Approximation: " + sqrt2(1, i));
            }
            String it = String.format("Last Iteration: %4d", x);
            System.out.println(it + ", Approximation: " + sqrt2B(new BigDecimal("1", m), x));
        }
        else
        {
            automateSQRT();
        }
    }

    public static void automateSQRT()
    {
        String in = "0.";
        for(int i = 1; i < mcAsInt; i++)
        {
            in+="0";
        }
        in+="1";
        //System.out.println("I made it to the ASQRT()! In: " + in);
        BigDecimal comp = new BigDecimal(in, m);
        BigDecimal prev = new BigDecimal("0", m);
        BigDecimal curr = sqrt2B(new BigDecimal("1", m), 1);
        long j = 0;
        while(absVal(curr.subtract(prev, m)).divide(absVal(curr), m).compareTo(comp) > 0 || j < 2)
        {
            prev = curr;
            curr = sqrt2B(prev, ++j);
            if(j%p == 0)
            {
                String it = String.format("Iteration: %4d", j);
                System.out.println(it + ", Approximation: " + curr);
            }
        }
        String it = String.format("     Last: %4d", j);
        System.out.println(it + ", Approximation: " + curr);
    }

    public static double sqrt2(double x, long i)
    {
        return i==1 ? x : i==2 ? x+1 : sqrt2(1/(2+x),--i);
    }

    public static BigDecimal sqrt2B(BigDecimal x, long i)
    {
        return i==1 ? x : i==2 ? x.add(new BigDecimal("1", m)) : sqrt2B((new BigDecimal("1", m)).divide((new BigDecimal("2", m)).add(x, m), m),--i);
    }

    public static BigDecimal absVal(BigDecimal x)
    {
        return x.abs();
    }

}
