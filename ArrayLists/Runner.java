import java.util.*;
/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main(String [] args)
    {
        System.out.println("How many tests do you want?");
        Scanner c = new Scanner(System.in);
        int input = c.nextInt();
        System.out.println("------Lists Stats------");
        for(int i = 0; i < input; i++)
        {
            ArrayListMav ALM = new ArrayListMav();
            ALM.mainArray();
            LinkedListMav LLM = new LinkedListMav();
            LLM.mainLinked();
        }
    }
}
