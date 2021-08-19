import java.util.Scanner;
/**
 * Maverick Berkland
 * I am Maverick Berkland, and I made this code from the resources of this semester
 * 16 March, 2017
 */
public class Maverick_4_Characters
{
    public static void main (String [] args)
    {
        System.out.println("Welcome to the Hacking Program, where we hack your 4 character password!!!");
        char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','1','2','3','4','5','6','7','8','9','0','!','@','#','$','%','^','&','*','(',')','_','-','=','+','Q','W','E','R','T','Y','U','I','O','P','|','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','<','>','/','?'};
        Scanner scan = new Scanner(System.in);
        System.out.println("I can't believe I did this, but I finally got it after about an hour of working!");
        System.out.println("Would you like to proceed with the program?");
        for(int x = 0; x < 2; x++)
        {
            String Input = scan.nextLine();
            if(Input.equalsIgnoreCase("yes"))
            {
                for(int i = 0; i < alphabet.length; i++)
                {
                    for(int j = 0; j < alphabet.length; j++)
                    {
                        for(int k = 0; k < alphabet.length; k++)
                        {
                            for(int l = 0; l < alphabet.length; l++)
                            {
                                char [] key = {alphabet[i],alphabet[j],alphabet[k],alphabet[l]};
                                System.out.println(key);
                            }
                        }
                    }
                }
                x++;
            }
            else if(Input.equalsIgnoreCase("no"))
            {
                System.out.println("Are you serious?!?");
                System.out.println("Thanks, weirdo!");
                x++;
            }
            else
            {
                System.out.println("If you typed something incorrectly, please type your answer correctly");
                System.out.println("Case does not matter");
                x--;
            }
        }
    }
}