import java.util.Scanner;
public class Maverick_Math
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter three numbers!");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int sum = x+y+z;
        System.out.println(" ");
        System.out.println("This is the answer for the sum of all three numbers:");
        System.out.println(sum);
        System.out.println(" ");
        System.out.println("The quotient of the first and second number is:");
        double quot = x/y;
        System.out.println(quot);
        System.out.println(" ");
        System.out.println("The product of all three numbers is:");
        int mult = x*y*z;
        System.out.println(mult);
        System.out.println(" ");
        System.out.println("The difference of the second and third numbers is:");
        int diff = y-z;
        System.out.println(diff);
        int i = 0;
        int j = 9;
        int div0 = j/i;
    }
}
