import java.util.Scanner;
public class RegionalIndicator
{
    public static void main ()
    {
        System.out.println("Enter your word that you would like to be 'bolded' in discord");
        String x = (new Scanner(System.in)).nextLine().toLowerCase();
        char [] xC = x.toCharArray();
        for(int i = 0; i < xC.length; i++)
        {
            if(xC[i] == (' '))
            System.out.print(" " + xC[i] + " ");
            else
            System.out.print(":regional_indicator_"+xC[i]+": ");
        }
    }
}
