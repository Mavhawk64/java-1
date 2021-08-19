import java.util.*;
public class Linked
{
    public static void main (String [] args)
    {
        LinkedList <Integer> nums = new LinkedList <Integer>();
        nums.add(9);
        nums.add(5);
        nums.add(-3);
        nums.set(0,3);
        nums.remove(0);
        //Better at Deleting and Inserting
        nums.add(1, 77);
        System.out.println(nums.get(2)); //Slower than ArrayList
        
        List <Integer> numbers = new ArrayList <Integer>(); //??? Upcasting??? Polymorphism???
        List <Integer> numeros = new LinkedList<Integer>();
    }
}