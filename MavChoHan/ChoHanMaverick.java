package ChoHan;
import java.util.Random;
import java.util.Scanner;

/**
 * This game is made from my resources of this semester
 */
public class ChoHanMaverick
{
    public void Play()
    {
        Scanner scan = new Scanner(System.in);
        DiceMaverick dice = new DiceMaverick();
        
        for(int i = 0; i < 2; i++)
        {
            System.out.println("Would you like to play ChoHan (Odd-Even)?");
            String ans = scan.nextLine();
            if(ans.equalsIgnoreCase("yes"))
            { 

                dice.Dice();
                i--;
            }
            else if(ans.equalsIgnoreCase("no"))
            {
                for(int j = 0; j < 2; j++)
                {
                    System.out.println("Are your sure?");
                    String req = scan.nextLine();
                    if(req.equalsIgnoreCase("yes"))
                    {
                        System.out.println("Ok, I understand.");
                        j++;
                        i++;
                    }
                    else if(req.equalsIgnoreCase("no"))
                    {
                        System.out.println("Ok, resetting game...");
                        i--;
                        j++;
                    }
                    else
                    {
                        System.out.println("Try again");
                        j--;
                    }
                }
            }
            else
            {
                System.out.println("Try again");
                i--;
            }
        }
    }
}