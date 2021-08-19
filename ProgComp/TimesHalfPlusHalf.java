import java.util.*;
/**
 * Write a description of class TimesHalfPlusHalf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimesHalfPlusHalf
{
    public static void main (String [] args)
    {
        System.out.println("Enter a number");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println("Iterations");
        for(int i = 0; i < 100; i++)
        {
            int temp = x/2;
            x = x + temp;
            System.out.println(x);
        }
    }
}
