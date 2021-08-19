import java.util.*;
import java.math.*;
/**
 * Write a description of class Factorization here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Factorization
{
    public static void main (String [] args)
    {
        System.out.println("Hello, welcome to my Factorization Program!");
        System.out.println("Give me a number, and I will find the factors of that number and the prime factorization of that number! (Between 1, 2,147,483,647.)\nNOTE: The larger the number (generally), the longer the program will take.\nRECOMMENDED: Between 1 and 250,000. Divide the number by 10,000 to get the amount of time in seconds for the program to run.");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int x = scan.nextInt();
        System.out.println("Factoring " + x);

        //Prime number generator
        ArrayList <Integer> primes = new ArrayList<Integer>();
        for(int i = x; i > 0; i--)
        {
            boolean p = true;
            for(int j = 2; j < i; j++)
            {
                if(i % j == 0)
                {
                    p = false;
                    break;
                }
            }
            if(p)
                primes.add(i);
        }

        Collections.reverse(primes);

        //Factor Number

        if(!primes.contains(x))
        {
            ArrayList <Integer> out = new ArrayList<Integer>();
            ArrayList <Integer> fac = new ArrayList<Integer>();
            for(int i = 2; i < x; i++)
            {
                if(x % i == 0)
                    out.add(i);
            }
            System.out.println(out);
            int bot = out.get(0);
            int top = out.get(out.size()-1);
            System.out.println("T: " + top + ", B: " + bot);
            fac.add(bot);
            System.out.println("fac: " + fac);
            int counterror = 0;
            while(out.size() > 2)
            {
                counterror++;
                out.clear();
                for(int i = 2; i < top; i++)
                {
                    if(top % i == 0)
                        out.add(i);
                }
                System.out.println(out);
                bot = out.get(0);
                top = out.get(out.size()-1);
                System.out.println("T: " + top + ", B: " + bot);
                fac.add(bot);
                System.out.println("fac: " + fac);
                if(top == bot || primes.contains(top))
                    fac.add(top);
                if(counterror >= 1000)
                {
                    System.out.println("ERRORED OUT OF LOOP");
                    break;
                }
            }

            System.out.println(fac);
            for(int i = 0; i < fac.size(); i++)
            {
                if(i != fac.size()-1)
                    System.out.print(fac.get(i) + "*");
                    else
                    System.out.println(fac.get(i));
            }
        }
        else
        {
            System.out.println(x + " is prime, silly!");
        }

    }
}
