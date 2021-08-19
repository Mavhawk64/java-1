import java.util.*;
/**
 * Write a description of class BubbleSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BubbleSort extends SortAlgorithm
{
    @Override
    public void sort(int [] array)
    {
        //    int count = 0;
        for(int i = 0; i < array.length-1; i++)
        {
            if( array[i] > array[i+1] )
            {
                //temporary variable
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                i = -1;
                //      count++;
            }
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
        return "Bubble Sort";
    }

}
