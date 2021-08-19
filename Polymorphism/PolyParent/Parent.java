package PolyParent;


/**
 * Write a description of class Parent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parent
{
    public void methodOne()
    {
        System.out.println("A");
        /*this.*/methodTwo(); //even though there is a this here, it would still take the same path and head to the child
    }
    
    public void methodTwo()
    {
        System.out.println("B");
        methodThree();
    }
    
    public void methodThree()
    {
        System.out.println("C");
    }
}
