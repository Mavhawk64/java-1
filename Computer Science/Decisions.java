import java.util.Scanner;
import java.awt.Color;

/**
 * Talking about conditional logic
 * 
 * Making a decision using a if-else
 * 
 * Program by Maverick Berkland
 * 
 * 1/23/17
 */
public class Decisions
{
  public static void main (String [] args)
  {
      if(true)
      {
          System.out.println("Hello World.");
        }
        boolean lightSwitch = true;
        if(lightSwitch)
        {
            System.out.println("Henlo spooder, crawl your 8 hairy legs out of here!");
        }
        int x = 3;
        int y = 4;
        x = y;
        
        System.out.println("The value of x WAS 3, now it is: " + x);
        
        /**
         * Comparison Operators
         * (How an int can behave like a boolean (T or F))
         * < less than
         * > greater than
         * <= less than or equal to
         * >= greater than or equal to
         * == equal to
         * != not equal to
         */
        if(x>=y)
        {
            System.out.println("Yes, x IS greater than or equal to y!!!");
    }
   
    System.out.println("How old are you?");
    Scanner scan = new Scanner(System.in);
     int age = scan.nextInt();
    if(age>=60)
    {
        System.out.println("Henlo person, you are old!");
    }
    else
    {
        System.out.println("You are still young.");
    }
    System.out.println("Type in your password");
    int userPassword = 1341;
    int password = scan.nextInt();
    if(userPassword==password)
    {
        System.out.println("Great job! You guessed the password!");
    }
    else
    {
        System.out.println("Oh No! Did you forget your password?");
        System.out.println("Do you wish to reset your password?");
        System.out.println("Enter 1 for yes, 2 for no");
        Scanner babs = new Scanner(System.in);
        int a = babs.nextInt();
        if(a==1)
        {
        System.out.println("Type in your new password");
        int b = babs.nextInt();
        System.out.println("Please reenter your new password");
        int c = babs.nextInt();
    }
    else if(a==2)
    {
        System.out.println("Okay");
        System.out.println("Please enter your password");
        int d = babs.nextInt();
        if(d==1341)
        {
            System.out.println("Great job! You guessed the password");
        }
        else
        {
            System.err.println("§You are locked out of your account!!!§");
        }
    }
}
}
}