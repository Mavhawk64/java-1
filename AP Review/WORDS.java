
/**
 * Write a description of class WORDS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WORDS
{
    public static void main (String [] args)
    {
        String word1 = "snow";
        String word2 = "rain";
        String word3 = "hail";
        word2 = word3;
        word1 = word3;
        word3 = word1;
        boolean egual = (word1 == word2 && word2 == word3 && word3 == word1);
        System.out.println(egual);
        
    }
}
