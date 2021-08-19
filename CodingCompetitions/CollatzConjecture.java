import java.util.*;
/**
 * Write a description of class CollatzConjecture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CollatzConjecture
{
    public static void main (String [] args)
    {
        System.out.println("Please enter a number");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println(go(x));
    }

    public static int go(int x)
    {
        int count = 0;
        while(x != 1)
        {
            if(x == 0)
                x = 3*x+1;
            else if(x%2 == 0)
                x = x/2;
            else
                x = 3*x+1;
            System.out.println("New x: " + x);
            count++;
        }
        return count;
    }
}
