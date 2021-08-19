import java.util.*;
import java.io.*;
public class Hexadecimal
{
    public static void main (String [] args)
    {
        Random y = new Random();
        int count = 0;
        for(int i = 0; i < 390150; i++)
        {
            int x = y.nextInt(16);
            if(x > 9)
            {
                if(x == 10)
                {
                    System.out.print("A");
                    //bw.write("A");
                }
                if(x == 11)
                    System.out.print("B");
                if(x == 12)
                    System.out.print("C");
                if(x == 13)
                    System.out.print("D");
                if(x == 14)
                    System.out.print("E");
                if(x >= 15)
                    System.out.print("F");
            }
            else
                System.out.print(x);
            count++;
            if(count%6 == 0)
                System.out.print(" ");
            if(count%30 == 0)
                System.out.println(" ");
        }
        System.out.println("\n\n\n" + "Number of iterations: " + count);
    }
}
