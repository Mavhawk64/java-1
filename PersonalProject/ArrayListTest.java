import java.util.*;
/**
 * Write a description of class ArrayListTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListTest
{
    public static void main ()
    {
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("potato");
        wordList.add("frick");
        wordList.add("gamer");
        int [] b = new int [wordList.size()];
        b[0] = 2;
        b[1] = 3;
        b[2] = 1;
        
        for(int i = 0; i < b.length - 1; i++)
        {
            if(b[i] > b[i+1])
            {
                int tampon = b[i];
                b[i] = b[i+1];
                b[i+1] = tampon;
        
                String temporary = wordList.get(i);
                wordList.set(i, wordList.get(i+1));
                wordList.set(i+1, temporary);
                i = -1;
            }
        }
        System.out.println(wordList);
    }
}
