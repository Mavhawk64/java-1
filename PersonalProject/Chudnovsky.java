import java.util.*;
import java.io.*;
import java.math.*;
/**
 * This is an algorithm that approximates pi. It is adapted from the Chudnovsky Algorithm, program made by Maverick Berkland.
 * 
 * pi = 1/(12*sum[((k=0,inf)(-1)^k(6k)!(54514013k+13591409))/((3k)!(k!)^3(640320)^(3k+3/2)))
 * 
 * or 
 * 
 * pi = C(sum[(k=0,inf)ML/X)^-1
 * 
 * where
 * 
 * C = 426880sqrt(10005)
 * M = (6k)!/((3k)!(k!)^3)
 * L = 545140134k + 13591409
 * X = (-262537412640768000)^k
 *
 * @author Maverick Berkland
 * @version 15 September, 2019
 */
public class Chudnovsky
{
    public static void main ()
    {
        System.out.println("Welcome to the Pi Calculator!\nThis is adapted from the Chudnovsky Algorithm and is very accurate.\nPlease insert a number of iterations.\nNote: the numbers get extremely big really fast!");
        int input = (new Scanner(System.in)).nextInt();
        BigDecimal C = (new BigDecimal(426880)).multiply((new BigDecimal(10005)).sqrt(new MathContext(100000))); //Constant
        System.out.println(bigSum(C, input));
        System.out.println("Would you like to try another input?");
        String ag = (new Scanner(System.in)).nextLine();
        if(ag.toLowerCase().contains("y"))
            main();
    }

    public static BigDecimal bigSum(BigDecimal C, int input)
    {
        ArrayList <BigDecimal> M = new ArrayList<BigDecimal>(); //M(k)
        ArrayList <BigDecimal> L = new ArrayList<BigDecimal>(); //L(k)
        ArrayList <BigDecimal> X = new ArrayList<BigDecimal>(); //X(k)
        ArrayList <BigDecimal> T = new ArrayList<BigDecimal>(); //Total per iteration
        BigDecimal m = new BigDecimal(0);
        BigDecimal l = new BigDecimal(0);
        BigDecimal x = new BigDecimal(0);
        BigDecimal num = new BigDecimal(0);
        BigDecimal den = new BigDecimal(0);
        BigDecimal summed = new BigDecimal(0);
        for(int i = 0; i <= input; i++)
        {
            /*
             * M
             * (6k)!/((3k)!(k!)^3) 
             */
            BigDecimal k = new BigDecimal(i);
            num = Factorial(k.multiply(new BigDecimal(6)));
            den = (Factorial(k.multiply(new BigDecimal(3))).multiply((Factorial(k)).pow(3)));
            m = num.divide(den, new MathContext(10)); //Always a nice number.
            M.add(m);
            /*
             * L
             * 545140134k + 13591409
             */
            l = (new BigDecimal(13591409)).add(k.multiply(new BigDecimal(545140134)));
            L.add(l);
            /*
             * X
             * (-262537412640768000)^k
             */
            x = (new BigDecimal("-262537412640768000")).pow(i);
            X.add(x);
            //T = ML/X
            T.add((m.multiply(l)).divide(x, new MathContext(10000)));
        }
        BigDecimal Inversion = new BigDecimal(0);
        for(int i = 0; i < T.size(); i++){Inversion = Inversion.add(T.get(i)); /*Complete total*/}
        Inversion = (new BigDecimal("1")).divide(Inversion, new MathContext(10000)); //Inverted total
        summed = Inversion.multiply(C); //Times C
        return summed;
    }

    public static BigDecimal Factorial(BigDecimal x)
    {
        int y = x.intValue();
        if(y == 0)
            return new BigDecimal(1);
        else if(y == 1)
            return new BigDecimal(1);
        else if(y == 2)
            return new BigDecimal(2);
        BigDecimal uno = new BigDecimal(1);
        BigDecimal count = x;
        for(int i = y; i > 1; i--)
        {
            count = count.subtract(uno);
            x = x.multiply(count);
        }
        return x;
    }
}
