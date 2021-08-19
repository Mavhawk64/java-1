package PolyParent;


/**
 * Write a description of class Child here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Child extends Parent
{
    @Override
    public void methodOne()
    {
        super.methodOne();
        System.out.println("D");
        methodTwo();
    }
    
    @Override
    public void methodTwo()
    {
        super.methodTwo();
        System.out.println("E");
    }
    
    @Override
    public void methodThree()
    {
        super.methodThree();
        System.out.println("F");
    }
}