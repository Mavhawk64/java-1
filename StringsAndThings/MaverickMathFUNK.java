import java.util.Scanner;
/**
 * Maverick Berkland
 * FUNKtions of our own MATH Class
 * 13 September, 2017
 */
public class MaverickMathFUNK
{
    public static int Square ()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = scan.nextInt();
        x = x*x;
        System.out.println(x);
        return x;
    }
    
    public static int Max()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers to find which one is bigger than the other");
        int x = scan.nextInt();
        int y = scan.nextInt();
        if(x > y)
        {
            System.out.println(x + " is greater than " + y);
        }
        else if(x == y)
        {
            System.out.println(x + " is equal to " + y);
        }
        else
        {
            System.out.println(y + " is greater than " + x);
        }
        return x;
    }
    
    public static int Min()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers to find which one is smaller than the other");
        int x = scan.nextInt();
        int y = scan.nextInt();
        if(x < y)
        {
            System.out.println(x + " is less than " + y);
        }
        else if(x == y)
        {
            System.out.println(x + " is equal to " + y);
        }
        else
        {
            System.out.println(y + " is less than " + x);
        }
        return x;
    }
    
    public static int Absolute()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter one integer to find the absolute value of it");
        int x = scan.nextInt();
        if(x < 0)
        {
            System.out.println(-x);
        }
        else
        {
            System.out.println(x);
        }
        return x;
    }
    
    public static int Exponent()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers to find x (first number) to the y (second number)");
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = x;
        for(int i = 1; i < y; i++)
        {
            x = x*z;
        }
        System.out.println(x);
        return x;
    }
    
    public static int Round()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter one decimal number to find the rounded version.");
        double x = scan.nextDouble();
        x = x + 0.5;
        System.out.println((int)x);
        return (int)x;
    }
}
