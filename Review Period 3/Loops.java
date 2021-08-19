
/**
 * Maverick Berkland
 * Loops
 * 23 August, 2017
 */
public class Loops
{
    public static void main (String [] args)
    {
        int counter = 0;
        System.out.println("While Loop");
        while(counter < 5)
        {
            counter++; //Counter = 0, but Prints 1... etc.
            System.out.println("Hello " + counter);
            //counter++; Counter = 0 and Prints 0... etc.
        }
        System.out.println("For Loop");
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Hello " + i);
        }
        System.out.println("Do While Loop");
        boolean check = false;
        do
        {
            System.out.println("HELLO");
        }
        while(check);
    }
}
