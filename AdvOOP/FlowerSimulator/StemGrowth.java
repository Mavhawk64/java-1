package FlowerSimulator;
import java.util.*;
public class StemGrowth
{
    public static void main(String [] args)
    {
        int poison = 0;
        double y = 0.0;
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Growth option as an integer");
        int x = sc.nextInt();
        System.out.println("A");
        System.out.println("B");
        String choose = scan.nextLine();
        int growth = 0;
        if(choose.equalsIgnoreCase("A"))
        {
            growth = (int)(Math.log(x));
            y = (Math.log(x));
        }
        else
        {
            growth = (int)(Math.log(x*5));
            poison = poison + growth;
            y = (Math.log(x*5));
        }
        poison = poison + growth;
        String percent = Double.toString(y);
        percent = percent.substring(2,4);
        if(poison > 100)
        {
            growth = 0;
        }
        
        for(int i = 1; i <= growth; i++)
        {
            System.out.println("  |" + i + "|");
        }
        System.out.println("Your plant is " + percent + "% away from growing");
    }
}
