import java.util.Scanner;
public class LETTERS
{
    public int LETTERs(int point)
    {
        System.out.println("Welcome to LETTERS - ENTER A WORD!");
        Scanner scan = new Scanner(System.in);
        point = 0;
        String Letters = scan.nextLine();
        Letters = Letters.toLowerCase();
        char [] key = Letters.toCharArray();
        
        for(int i = 0; i < key.length; i++)
        {
            int f = (int)key[i];
            if(f==(97) || f==(101) || f==(105) || f==(111) || f==(117))
            {
                point += 1;
                System.out.println("Vowel " + point);
            }
            else
            {
                point += 2;
                System.out.println(point);
            }
        }
        System.out.println("TOTAL POINTS!");
        return point;
    }
}
