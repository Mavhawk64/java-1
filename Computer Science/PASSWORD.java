import java.util.Scanner;
/**
 * Write a description of class StringComparison here.
 * 
 * Maverick Berkland 
 * 24 January, 2017
 */
public class PASSWORD
{
    public static void main ()
    {
        Scanner sc = new Scanner(System.in);
        /**
         * Make a password checker that checks for strings
         */
        System.out.println("Type in your password");
        String userPassword = "qwerty";
        String Password = sc.nextLine();
        if(userPassword.equalsIgnoreCase (Password))
        {
         System.out.println("Great job! You guessed the password!");
        }
        else
        {
         System.out.println("Oh No! Did you forget your password?");
         System.out.println("Do you wish to reset your password?");
         System.out.println("Enter 1 for yes, and 2 for no.");
         Scanner mrbabs = new Scanner(System.in);
         int a = mrbabs.nextInt();
         if(a==1)
         {
           System.out.println("Type in your new password");
           Scanner babs  = new Scanner(System.in);
           String b = babs.nextLine();
           System.out.println("Please reenter your new password");
           String c = babs.nextLine();
         }
         else if(a==2)
         {
           System.out.println("Okay");
           System.out.println("Please enter your password");
           String d = sc.nextLine();
          if(d==userPassword)
          {
            System.out.println("Great job! You guessed the password");
          }
          else
          {
            System.err.println("§You are Locked out of yoUr aCCount!!!§");
          }
         }
        }
    }
}