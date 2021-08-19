package Sorting;
import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class BogoSortHelp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BogoSortHelp
{
    static long start = System.nanoTime();
    static Random r1 = new Random();
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int [] array = {4,3,2,5,45,22};
    static int [] temp = new int [array.length];
    static int [] order = new int [array.length];
    /**
     * @BogoSort
     */
    public static void main (String [] args)
    {
        //Real Code
        System.out.println("Original array: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }

        System.out.println(" ");
        System.out.println(" ");

        while(!(isSorted()))
        {
            Randomize();
        }

        System.out.println("Array in order: ");
        for(int i = 0; i < temp.length; i++)
        {
            System.out.print(array[order[i]] + "  ");
        }
        long end = (System.nanoTime() - start)/1000000000;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Finished in " + end + " seconds");
    }

    private static void Randomize ()
    {
        int count = 0;
        boolean [] beenVisited = new boolean [array.length];
        int index = 0;
        int x = r1.nextInt(array.length);
        while(count < array.length)
        {
            x = r1.nextInt(array.length);
            if(!beenVisited[x])
            {
                order[index] = x;
                index++;
                beenVisited[x] = true;
                count++;
            }
        }
    }

    private static boolean isSorted ()
    {
        int sortCount = 0;
        for(int i = 0; i < array.length - 1; i++)
        {
            if(array[order [i]] < array[order [ i + 1]])
            {
                sortCount++;
            }
        }

        if(sortCount == array.length - 1)
        {
            return true;
        }
        else
        {
            return false;   
        }
    }
}
