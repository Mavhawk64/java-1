import java.util.Random;
/**
 * Write a description of class Randomness here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Randomness
{
    public static void main (String[] args)
    {
        System.out.println("Here is some randomness.");
        Random r = new Random();
        int xMax = 49;
        int yMax = 54;
        for (int i = 0; i < 10000; i++)
        {
            int xr = r.nextInt(xMax + 1);
            int yr = r.nextInt(yMax + 1);
            System.out.printf("X: %d , Y: %d\n", xr, yr);
            if (xr > xMax)
            {
                System.out.println("X: Out of Bounds: " + xr);
                break;
            }
            if (yr > yMax)
            {
                System.out.println("Y: Out of Bounds: " + yr);
                break;
            }
        }
    }
}