
/**
 * Write a description of class testMe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testMe
{
    public static void main ()
    {
        String temp = "Uther Pendragon";
        char [] y = new char[2];
        int k = 0;
        for(int j = 0; j < temp.length(); j++)
        {
            if(j == 0)
            {
                y[k] = temp.charAt(j);
                System.out.println("K = 0: " + y[k]);
                k++;
            }
            else if(temp.charAt(j) == ' ')
            {
                y[k] = temp.charAt(j+1);
                System.out.println("K = "+k+": " +y[k]);
                k++;
            }
        }
        System.out.println((int)y[0] + " " + (int)y[1]);
        int a = (int)y[0];
        for(int i = 0; i < y.length; i++)
        {
            if(a > (int)y[i])
            a = (int)y[i];
        }
        System.out.println(a + " is smallest");
    }
}
