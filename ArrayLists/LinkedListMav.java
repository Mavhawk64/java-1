import java.util.*;
/**
 * Write a description of class LinkedList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkedListMav
{
    public void mainLinked()
    {
        long start = System.nanoTime();
        LinkedList <Integer> Link = new LinkedList <Integer> ();
        for(int i = 0; i < 101020; i++)
        {
            Link.add(i);
        }
        long stop = System.nanoTime() - start;
        long start2 = System.nanoTime();
        for(int i = 0; i < 101020; i++)
        {
            Link.get(i);
        }
        long stop2 = System.nanoTime() - start2;
        long start3 = System.nanoTime();
        for(int i = Link.size() - 1; i >= 0; i--)
        {
            Link.remove(i);
        }
        long stop3 = System.nanoTime() - start3;
        System.out.println("------LinkedList Stats------");
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
    }
}