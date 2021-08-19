import java.util.*;
public class PrintNums
{
    public static void main (String [] args)
    {
        System.out.println("Enter a number you would like to count to (no spaces, commas, or new lines");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for(int i = 0; i <= num; i++)
        {
            System.out.print(i);
        }
    }
}
