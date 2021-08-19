import java.util.*;
import java.math.*;
/**
 * Write a description of class Factor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Factor
{
    public int factor(int x)
    {
        int count = 0;
        for(int i = 1; i <= x; i++)
        {
            if(x % i == 0)
                count++;
        }

        int [] y1 = new int [count];
        int [] y = new int [count-1];
        int a = 0;
        for(int i = 1; i <= x; i++)
        {
            if(x % i == 0)
            {
                y1[a] = i;
                if(x != i)
                    y[a] = i;
                a++;
            }
        }

        for(int i = 0; i < count; i++)
        {
            if(i != count-1)
                System.out.print(y1[i] + ", ");
            else
                System.out.println(y1[i]);
        }
        
        return 0;
    }
}
