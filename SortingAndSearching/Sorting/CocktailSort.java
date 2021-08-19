package Sorting;
import java.util.Scanner;
import java.util.Random;
// Java program for implementation of Cocktail Sort
public class CocktailSort
{
    void cocktailSort(int a[])
    {
        boolean swapped = true;
        int start = 0;
        int end = a.length;
 
        while (swapped==true)
        {
            // reset the swapped flag on entering the 
            // loop, because it might be true from a 
            // previous iteration.
            swapped = false;
 
            // loop from bottom to top same as
            // the bubble sort
            for (int i = start; i < end-1; ++i)
            {
                if (a[i] > a[i + 1])
                {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
 
            // if nothing moved, then array is sorted.
            if (swapped==false)
                break;
 
            // otherwise, reset the swapped flag so that it
            // can be used in the next stage
            swapped = false;
 
            // move the end point back by one, because
            // item at the end is in its rightful spot
            end = end-1;
 
            // from top to bottom, doing the
            // same comparison as in the previous stage
            for (int i = end-1; i >=start; i--)
            {
                if (a[i] > a[i+1])
                {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
 
            // increase the starting point, because
            // the last stage would have moved the next
            // smallest number to its rightful spot.
            start = start+1;
        }
    }
     
    /* Prints the array */
    void printArray(int a[])
    {
        int n = a.length;
        for (int i=0; i<n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String[] args)
    {
        CocktailSort ob = new CocktailSort();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a number for a max amount of numbers for me to create.");
        int apple = input.nextInt(); 
        int [] a = new int [apple];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = rand.nextInt(apple);
        }
        long start = System.nanoTime();
        System.out.println("Original array: ");
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        ob.cocktailSort(a);
        System.out.println("");
        System.out.println("Sorted array");
        ob.printArray(a);
        long stop = System.nanoTime() - start;
        System.out.println("In " + stop + " nanoseconds");
    }
}