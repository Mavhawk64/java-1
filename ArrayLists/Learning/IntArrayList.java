package Learning;
import java.util.*;
/**
 * Write a description of class IntArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntArrayList
{
    public static void main(String [] args)
    {
        //Old int array
        System.out.println("Old int array.");
        int [] nums = new int[5];
        for(int i = 0; i < 5; i++)
        {
            nums[i] = (int)Math.pow(i, 2);
            System.out.println(nums[i]);
        }

        //NEW ARRAY LIST
        System.out.println("New Integer array.");
        ArrayList <Integer> x = new ArrayList <Integer>();
        for(int i = 20; i >= 0; i--)
        {
            x.add(i);
            System.out.println(x.get(20 - i));
        }

        System.out.println("Size: " + x.size());

        for(int i = 0; i < x.size(); i++)
        {
            x.add(i);
            System.out.println(x.get(i));
            if(x.size() > 50)
                break;
        }

        x.add(19);
        x.add(19);
        x.add(2934);
        x.add(19);
        x.add(19);
        x.add(19);
        x.add(20);
        System.out.println("The array");
        for(int i = 0; i < x.size(); i++)
        {
            if(x.get(i).equals(19))
            {
                x.remove(i);
                i -= 1; //without having this, or some other way to fix the loop, it would print
                //20 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 20 21 22 23 24 25 26 27 28 29 19 2934 19 19 20 
                //It changes the position without changing i without manually fixing it.
            }
        }
        System.out.println(x);

        /**
         * ALWAYS ITERATE THROUGH AN ARRAY LIST BACKWARDS!!!
         */

        for(int i = x.size() -1; i >= 0; i--)
        {
            x.add(i);
            System.out.println(x.get(i));
        }
        System.out.println("NEWEST LIST:");
        System.out.println(x);
        System.out.println("Testing");
        /* for(int i = 0; i <= x.size(); i++)
        {
        x.remove(i);
        System.out.println(x);
        }*/
        /**Infinite Loop*/
        for(int i = x.size()-1; i >= 0; i--)
        {
            x.remove(i);
            System.out.println(x);
        }
    }
}
