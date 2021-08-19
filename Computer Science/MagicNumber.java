import java.util.Random;
import java.util.Scanner;
/**
 * Maverick Berkland
 * 2 February, 2017
 * This code is made from my resouces from this semester
 */
public class MagicNumber
{
   public static void main ()
   {
       System.out.println("Welcome to the Magic Number Game!");
       System.out.println("");
      
       //Enter the random number and scanner
       Scanner scan = new Scanner(System.in);
       Random rand = new Random();
       int x = rand.nextInt(101);
       int count = 0;
       int y = 0;
       while(y!=x)
       {
           System.out.println("Please guess a number between 1-100!");
           y = scan.nextInt();
           if (y>x)
           {
               count = count+1;
               System.out.println("Go lower");
           }
           else if (y<x)
           {
               count = count+1;
               System.out.println("Go higher");
            }
       }
       if (y==x)
       {
          System.out.println("Great job, you guessed the number in " + count + " tries!");
       }
   }
}
