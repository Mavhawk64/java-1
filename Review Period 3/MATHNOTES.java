
/**
 * Maverick Berkland
 * Millard North 17 August, 2017
 * Math Class Notes
 */
public class MATHNOTES
{
    public static void main (String [] args)
    {
        int x = 4;
        double y = Math.sqrt(x);
        System.out.println(y);
        int z = (int)(Math.pow(x,2));
        
        //Now I do the 10 Math Class problems
        //1.
        double a = 15.999;
        double a1 = Math.signum(a);
        if(a1 > 0)
        {
            System.out.println("Answer is above 0, therefore signum of " + a + " is ");
            System.out.println(a1);
        }
        else
        {
            System.out.println("Answer is 0 or below, therefore signum of " + a + " is ");
            System.out.println(a1);
        }
        //2.
        double b = 1234;
        double b1 = Math.nextUp(b);
        System.out.println("nextUp of " + b);
        System.out.println(b1);
        //3.
        double c = 123;
        double c1 = Math.log10(c);
        System.out.println("log10 of " + c);
        System.out.println(c1);
        //4.
        double d = 98765432.0;
        double d1 = Math.cbrt(d);
        System.out.println("Cube Root of " + d);
        System.out.println(d1);
        //5.
        int e = -765;
        int e1 = Math.abs(e);
        System.out.println("Absolute Value of " + e);
        System.out.println(e1);
        //6.
        double f = 1234.765;
        double f1 = Math.ulp(f);
        System.out.println("ulp of " + f);
        System.out.println(f1);
        //7.
        double g = 7653;
        double g1 = Math.tan(g);
        System.out.println("Tangent of " + g);
        System.out.println(g1);
        //8.
        double h = 6543;
        double h1 = Math.acos(h);
        System.out.println("Arc Cosine of " + h);
        System.out.println(h1);
        //9.
        double i = 123487.6;
        double i1 = Math.ceil(i);
        System.out.println("Round up " + i);
        System.out.println(i1);
        //10.
        double j = 65;
        double k = 98;
        double jk = Math.atan2(k,j);
        System.out.println("Arc Tan of " + j + " and " + k);
        System.out.println(jk);
        
        
        //Notes
        
        System.out.println("Random Number Generator via Math.random");
        System.out.println("It's a random number between 0-1");
        double ran = Math.random();
        System.out.println(ran);
        //Moving it up 2 decimal places
        System.out.println("Times 100");
        System.out.println(ran*100);
        System.out.println("Times 10, then Plus 10");
        System.out.println((ran*10)+10);
    }
}
