
/**
 * Write a description of class Convertor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Convertor
{
    public static void main ()
    {
        double [] d = {20,18,16,14,12,10,8,6,4};
        for(int i = 0; i < d.length; i++)
        {
            d[i] = d[i]*0.01;
            System.out.println(d[i]);
        }
    }
}
