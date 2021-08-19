package ChoHan;
import java.util.Random;
import java.util.Scanner;
/**
 * Extension of ChoHanMaverick
 */
public class DiceMaverick
{
    public void Dice ()
    {
        Scanner scan = new Scanner(System.in);
                System.out.println("How much would you like to bet? If you win, you get 2 times the amount put in, but if you lose, you lose half of what you bet.");
        Scanner sc = new Scanner(System.in);
        int bet = sc.nextInt();
        Random dice = new Random();
        int d1 = dice.nextInt(6) + 1;
        int d2 = dice.nextInt(6) + 1;
        int result = d1 + d2;
        System.out.println("Which one, odd or even?");
        String guess = scan.nextLine();
        System.out.println(result);
        if(result == 2 || result == 4 || result == 6 || result == 8 || result == 10 || result == 12)
        {
            System.out.println("Even");
            if(guess.equalsIgnoreCase("even"))
            {
              bet *= 2;
              System.out.println("Your winnings are now... " + bet);
            }
            else
            {
                bet /= 2;
                System.out.println("Your winnings are now... " + bet);
            }
        }
        else
        {
            
            System.out.println("Odd");
            if(guess.equalsIgnoreCase("odd"))
            {
                bet *= 2;
                System.out.println("Your winnings are now..." + bet);
            }
            else
            {
                bet /= 2;
                System.out.println("Your winnings are now.. " + bet);
            }
        }
        
        
    }
}
