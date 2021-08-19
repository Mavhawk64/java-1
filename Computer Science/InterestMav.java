import java.util.Scanner;
/**
 * Maverick Berkland
 * I am Maverick Berkland and I made this code with the resources from this semester.
 * 10 February, 2017
 */
public class InterestMav
{
    public static void main ()
    {
        System.out.println("Hello, welcome to the Compound-Interest Program!");
        System.out.println("");
        System.out.println("Please enter your principle value");
        Scanner scan = new Scanner(System.in);
        double p = scan.nextDouble();
        System.out.println("");
        System.out.println("Please enter your total amount of years you are saving for");
        double y = scan.nextDouble();
        System.out.println("");
        System.out.println("Please enter your interest rate (10% = 0.1)");
        double r = scan.nextDouble();
        System.out.println("");
        System.out.println("Years Until Final year\t\tTotal Compound Amount");
        System.out.println("-----------------------------------------------");
        for(double i = y; i >= 0; i--)
        {
            p = p+y*r-1;
            System.out.println(i + "\t\t" + p);
        }
    }
}
