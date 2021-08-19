import java.util.Scanner;
/**
 * Maverick Berkland
 * 7 February, 2017
 */
public class Traveler
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello!");
        System.out.println("How many hours did you travel?");
        int hours = scan.nextInt();
        System.out.println("How fast were you going?");
        int speed = scan.nextInt();
        System.out.println("Hours                     Distance (mi)");
        System.out.println("---------------------------------------");
        int distance = 0;
        for(int i = 1; i <= hours; i++)
        {
            distance = speed * i;
            System.out.println(i + "                                 " + distance);
        }
    }
}
