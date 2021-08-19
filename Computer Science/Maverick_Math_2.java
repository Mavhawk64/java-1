import java.util.Scanner;
public class Maverick_Math_2
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
        
        Scanner sd = new Scanner(System.in);
        System.out.println("Please enter two more numbers!");
        int a = sd.nextInt();
        int b = sd.nextInt();
        double quot = a/b;
        System.out.println(" ");
        System.out.println("The quotient of the first and second number is:");
        System.out.println(quot);
        
        Scanner sa = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Please enter three more numbers!");
        int c = sa.nextInt();
        int d = sa.nextInt();
        int e = sa.nextInt();
        int mult = c*d*e;
        System.out.println(" ");
        System.out.println("The product of all three numbers is:");
        System.out.println(mult);
        System.out.println(" ");
        
        Scanner sb = new Scanner(System.in);
        System.out.println("Please enter two more numbers!");
        int f = sb.nextInt();
        int g = sb.nextInt();
        int diff = f-g;
        System.out.println(" ");
        System.out.println("The difference of the second and third numbers is:");
        System.out.println(diff);
    }
}