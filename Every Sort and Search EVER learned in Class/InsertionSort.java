import java.util.*;
/**
 * Write a description of class BubbleSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsertionSort extends SortAlgorithm
{
    @Override
    public void sort(int [] array)
    {
        int n = array.length; 
        for (int i = 1; i < n; ++i) { 
            int key = array[i]; 
            int j = i - 1; 
  
            /* Move elements of array[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && array[j] > key) { 
                array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = key; 
        } 
        System.out.println("Array in order: ");
        for(int i = 0; i < array.length; i++)
        {
            if(i < array.length - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.println(array[i]);
        }
        //System.out.println("Finished in " + count + " iterations");
    }

    @Override
    public String getName()
    {
        return "Insertion Sort";
    }

}
