
/**
 * Write a description of class Minus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Minus
{
    public static void main ()
    {
        int x = 73;
        int y = 92;
        int x1 = x - 1;
        int y1 = y - 1;
        int xy = x*y;
        int xy1 = x1*y1;
        int guess = x + y - 1;
        int real = xy - xy1;
        System.out.println("Guess " + guess + " vs Real " + real);
    }
}
