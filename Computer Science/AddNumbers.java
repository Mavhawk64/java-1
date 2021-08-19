import java.util.Random;
import java.util.Scanner;
/**
 * Maverick Berkland
 * SUMMATION
 */
public class AddNumbers
{
    public static void main()
    {
        System.out.println("Summation Solver");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number");
        int userNum = scan.nextInt();
        int count = 1;
        int sum = 0;
        while(userNum >= 1)
        {
            sum = userNum + sum;
            userNum = userNum - 1;
        }
        System.out.println("The summation of your number is " + sum);
    }
}
