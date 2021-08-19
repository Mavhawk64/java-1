import java.util.Random;
/**
 * Write a description of class RandomStringChooser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomStringChooser
{
    static Random rand = new Random();
    static String [] wordArray = {"wheels","on","the","bus"};
    static boolean [] isPicked = new boolean[wordArray.length];
    static int count = 0;
    public static void main (String [] args)
    {
        for(int i = 0; i < 6; i++)
        {
            System.out.println(getNext());
        }
    }

    private static String getNext()
    {
        int x = rand.nextInt(wordArray.length);
        if( isPicked[x] == false )
        {
            isPicked[x] = true;
            count++;
            return wordArray[x];
        }
        else if( count == 4)
        {
            return "None";
        }
        else
        {
            return getNext();
        }
    }
}

