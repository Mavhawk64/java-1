package PolyArray;


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
        System.out.println("Welcome to Animal Simulator");
        int [] nums = new int[3];
        Animal [] arr = new Animal[4];
        arr[0] = new Cat();
        arr[1] = new Cow();
        arr[2] = new Pig();
        arr[3] = new Animal();
        for(int i = 0; i < arr.length; i++)
        {
            arr[i].makeNoise();
        }
    }
}
