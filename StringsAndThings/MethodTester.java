import java.util.Scanner;
/**
 * This Will Call The Methods
 */
public class MethodTester
{
    public static void main (String [] args)
    {
        Methods m1 = new Methods();
        m1.SayHello();
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        Methods.SayHelloStatic();
        double y = Math.pow(2,3); //Nothing happens
        System.out.println(Math.pow(2,3));
        Math.pow(2,3);
        System.out.println(m1.Numbers());
        int z = m1.Numbers();
        String word = "Jon";
        m1.MakeExciting(word);
        System.out.println(word);
        //or
        m1.MakeExciting("JOHNNY");
        System.out.println(word);
        //String v = m1.MakeExciting(word);
        //Doesn't work because word is a void type, no return is available
        System.out.println(Math.pow(2,10));
        System.out.println(m1.Power(2,10));
        
        char [] r = new char[5];
        m1.test(2,3,"JON", r, scan);
        System.out.println(m1.test(2,3,"JON", r, scan));
    }
}