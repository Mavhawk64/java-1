import java.util.*;
/**
 * Write a description of class ArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayListMav
{
    public void mainArray()
    {
        long start = System.nanoTime();
        ArrayList <Integer> HipHip = new ArrayList <Integer> ();
        for(int i = 0; i < 101020; i++)
        {
            HipHip.add(i);
        }
        long stop = System.nanoTime() - start;
        long start2 = System.nanoTime();
        for(int i = 0; i < 101020; i++)
        {
            HipHip.get(i);
        }
        long stop2 = System.nanoTime() - start2;
        long start3 = System.nanoTime();
        for(int i = HipHip.size() - 1; i >= 0; i--)
        {
            HipHip.remove(i);
        }
        long stop3 = System.nanoTime() - start3;
        System.out.println("------ArrayList Stats------");
        if(stop >= 1000000)
        {
            stop = stop/1000000;
            System.out.println("Add: " + stop + " milliseconds");
        }
        else if(stop >= 1000000000)
        {
            stop = stop/1000000000;
            System.out.println("Add: " + stop + " seconds");
        }
        else
        System.out.println("Add: " + stop + " nanoseconds.");
        
        if(stop2 >= 1000000)
        {
            stop2 = stop2/1000000;
            System.out.println("Get: " + stop2 + " milliseconds");
        }
        else if(stop2 >= 1000000000)
        {
            stop2 = stop2/1000000000;
            System.out.println("Get: " + stop2 + " seconds");
        }
        else
        System.out.println("Get: " + stop2 + " nanoseconds.");
        
        if(stop3 >= 1000000)
        {
            stop3 = stop3/1000000;
            System.out.println("Remove: " + stop3 + " milliseconds");
        }
        else if(stop3 >= 1000000000)
        {
            stop3 = stop3/1000000000;
            System.out.println("Remove: " + stop3 + " seconds");
        }
        else
        System.out.println("Remove: " + stop3 + " nanoseconds.");
    }
}
