package PolyParent;

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
        System.out.println("----Child Creator----");
        Parent p1 = new Child();
        p1.methodOne();
    }
}
