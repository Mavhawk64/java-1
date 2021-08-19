import java.util.*;
/**
 * Write a description of class APCOMPSCIROCKS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class APCOMPSCIROCKS
{
    public static void main(String [] args)
    {
        ArrayList <String> wordList = new ArrayList<String>();
        wordList.add("AP");
        wordList.add("COMP");
        wordList.add("SCI");
        wordList.add("ROCKS");
        int width = 2;
        int left = 2;
        int amtgap = 3;
        int sum = 0;
        for(int i = amtgap; i > 0; i--)
        {
            for(int j = width; j > 0; j--)
            {
                wordList.add(i," ");
            }
        }
        /*
        for(int i = left; i > 0; i--)
        {
            wordList.add(i, " ");
            left--;
        }
        */
        System.out.println(wordList);
    }
}
