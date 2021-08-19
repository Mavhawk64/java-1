
import java.util.Random; 
public class ChoHanPractice
{
    public static void main (String [] args)
    {
        Random dice = new Random();
        int x = 5;
        int y = 5%2;
        int di = 8;
        if(di%2 == 0)
        {
            System.out.println("Even");
        }
        else
        {
            System.out.println("Odd");
        }
        //int result = dice.nextInt(11) + 2;
        int d1 = dice.nextInt(6) + 1;
        int d2 = dice.nextInt(6) + 1;
        int result = d1 + d2;
        System.out.println(result);
    }
}
