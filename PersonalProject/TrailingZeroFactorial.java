
/**
 * Write a description of class TrailingZeroFactorial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrailingZeroFactorial
{
    public static void main ()
    {
        System.out.println("Initializing...");
        for(int i = 0; i < 101; i++)
        {
            System.out.println(i + " : " + zeros(i));
        }
    }

    public static int zeros(int n) 
    {
        int z = 0;
        //z = sum(n/5^k){k=1,floor(log_5 (n))}
        //log_5(n) = ln(n)/ln(5)

        for(int k = 1; k < 1 + Math.floor(Math.log(n)/Math.log(5)); k++)
        {
            z += n/Math.pow(5, k);
        }
        return z;

        /* RECURSIVE FORM
        if(n/5 == 0)
        return 0;
        return n/5 + zeros(n/5);
         */
    }
}
