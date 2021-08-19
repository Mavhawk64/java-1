import java.util.*;
/**
 * Write a description of class getPrimes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class getPrimes
{
    public static void main (String [] args)
    {
        System.out.println("List of primes: ");
        ArrayList <Integer> primes = new ArrayList<Integer>();
        for(int i = 2147483647; i > 1; i--)
        {
            boolean p = true;
            for(int j = 2; j < i/2; j++)
            {
                if(i % j == 0)
                {
                    p = false;
                    break;
                }
            }
            if(p && i != 4)
            {
                primes.add(i);
                //break;
            }
            System.out.println(i);
        }
        
        Collections.reverse(primes);
        int [] primenums = new int[primes.size()];
        for(int i = 0; i < primes.size(); i++)
        {
            primenums[i] = primes.get(i);
            //System.out.println(primenums[i]);
        }
        System.out.println(primes);
    }
}
