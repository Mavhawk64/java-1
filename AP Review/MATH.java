
/**
 * Write a description of class MATH here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MATH
{
    public static void main (String [] args)
    {
        //System.out.println(Math.abs(2));
        int a = 5, b = 2, temp;
        temp = 0;
        for (int i=1; i<=4; i++)
        {
            temp = a;
            a = i + b;
            b = temp - i;
        }
        System.out.println("a " + a + " b " + b + " temp " + temp);
        System.out.println(mystery(4));
    }

    public static int mystery(int n)
    {
        if (n == 0)
            return 1;
        else
            return 3 * mystery (n - 1);
    }
}
