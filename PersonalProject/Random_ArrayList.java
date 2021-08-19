import java.util.*;
import java.util.concurrent.*;
import java.math.*;
/**
 * This gives a random ArrayList of numbers through a certain range (and amount), and it sorts them.
 *
 * @author Maverick Berkland
 * @version 15 September, 2019
 */
public class Random_ArrayList
{
    public static void main ()
    {
        System.out.println("Hello, welcome to the Random ArrayList Creator!\nPlease insert the amount of numbers!");
        int x = (new Scanner(System.in)).nextInt();
        System.out.println("Now enter the bottom number of the range");
        int b = (new Scanner(System.in)).nextInt();
        System.out.println("Enter the highest number of the range");
        int t = (new Scanner(System.in)).nextInt();
        ArrayList<Integer> ran = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < x; i++)
        {
            int r = ThreadLocalRandom.current().nextInt(b, t + 1);
            if(!ran.contains(r) && (t-b >= x))
                ran.add(r);
            else if(x > t-b)
                ran.add(r);
            else
                i--;
        }
        System.out.println(ran);
        System.out.println("Sorted: " + pleaseSort(ran));
    }

    public static ArrayList<Integer> pleaseSort(ArrayList<Integer> ran)
    {
        for(int i = 0; i < ran.size() - 1; i++)
        {
            if(ran.get(i) > ran.get(i+1))
            {
                Integer temp = ran.get(i);
                ran.set(i, ran.get(i+1));
                ran.set(i+1, temp);
                i = -1;
            }
        }
        return ran;
    }
}
