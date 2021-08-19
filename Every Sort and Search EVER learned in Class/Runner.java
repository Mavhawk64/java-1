import java.util.*;
/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main (String [] args)
    {
        boolean heck = false;
        ArrayList forSearch = new ArrayList<Integer>();
        System.out.println("Would you like to sort with bogo?");
        Scanner scan = new Scanner(System.in);
        String frick = scan.nextLine();
        System.out.println("How many numbers would you like to search or sort through?");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        long totstart = System.nanoTime();
        Random rand = new Random();
        /**int apple = rand.nextInt(input);*/
        int [] array = new int [input]; //input is size
        long arrstart = System.nanoTime();
        for (int i = 0; i < array.length; i++)
        {
            if(input >= 100)
                array[i] = rand.nextInt(101);
            else
                array[i] = rand.nextInt(input+1);
            forSearch.add(array[i]);
        }
        System.out.println("Original List");
        for(int i = 0; i < array.length; i++)
        {
            if(i < array.length - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.println(array[i]);
        }
        long arrstop = System.nanoTime() - arrstart;
        double arrstopd = arrstop/1000000;
        System.out.println("Array created in " + arrstopd + " ms");
        System.out.println(" ");
        int [] copy1 = copyArray(array);
        int [] copy2 = copyArray(array);
        int [] copy3 = copyArray(array);
        int [] copy4 = copyArray(array);
        int [] copy5 = copyArray(array);
        int [] copy6 = copyArray(array);
        int [] copy7 = copyArray(array);
        int [] copy8 = copyArray(array);
        SortAlgorithm [] algs = {new BubbleSort(), new SelectionSort(), new InsertionSort(), new HeapSort(), new MergeSort(), new QuickSort(), new RecSelectionSort(), new BogoSort()};
        int [] [] arrs = {copy1, copy2, copy3, copy4, copy5, copy6, copy7, copy8};
        int bogo = frick.toLowerCase().contains("y") ? 0 : 1;
        for (int i = 0; i < algs.length - bogo; i++)
        {
            long start = System.nanoTime();
            System.out.println(algs[i].getName());
            System.out.println(toString(arrs[i]));
            algs[i].sort(arrs[i]);
            long end = System.nanoTime();
            System.out.println("Sorted in " + (end - start) + " nanoseconds"); 
        }
       
        long line = System.nanoTime();
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.getName());
        int eng = 0;
        if(input < 200)
            eng = (int)forSearch.get(input/2);
        else
            eng = (int)forSearch.get(50);
        ls.search(array, eng);
        long ln = System.nanoTime() - line;
        double lin = ln/1000000;
        System.out.println("Searched for " + eng + " in " + lin + " ms\n");

        long bin = System.nanoTime();
        BinarySearch bn = new BinarySearch();
        System.out.println(bn.getName());
        bn.search(array, eng);
        long bs = System.nanoTime() - bin;
        double bind = bs/1000000;
        System.out.println("Searched for " + eng + " in " + bind + "ms\n");

        long stop = System.nanoTime() - totstart;
        double ended = stop/1000000;
        while(!heck)
        {
            if(ended < 1000 && !heck)
            {
                System.out.println("This program took a total of " + ended + " milliseconds to complete");
                heck = true;
                break;
            }
            ended = ended/1000;
            if(ended < 60 && !heck)
            {
                System.out.println("This program took a total of " + ended + " seconds to complete");
                heck = true;
                break;
            }
            ended = ended/60;
            if(ended < 60 && !heck)
            {
                System.out.println("This program took a total of " + ended + " minutes to complete");
                heck = true;
                break;
            }
            ended = ended/60;
            if(ended < 60 && !heck)
            {
                System.out.println("This program took a total of " + ended + " hours to complete");
                heck = true;
                break;
            }
            ended = ended/24;
            if(!heck)
                System.out.println("This program took a total of " + ended + " days to complete");
            heck = true;
        }
    }

    public static String toString(int [] arrayIn)
    {
        String x = "";
        for (int i = 0; i < arrayIn.length - 1; i++)
        {
            x += arrayIn[i] + ", ";
        }
        x += arrayIn[arrayIn.length - 1] + " ";
        return x;
    }
    
    public static int [] copyArray(int [] arrayIn)
    {
        int [] result = new int[arrayIn.length];
        for (int i = 0; i < arrayIn.length; i++)
        {
            result[i] = arrayIn[i];
        }
        return result;
    }
}
