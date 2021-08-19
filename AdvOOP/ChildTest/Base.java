package ChildTest;
public abstract class Base
{
    protected int value;
    protected int value2;
    Base()
    {
        value = 1;
        value2 = 2;
    }
    
    public void doStuff()
    {
        System.out.println("Value 1: " + value);
        System.out.println("Value 2: " + value2);
    }
    
    //Prints a horizontal line
    /**
     * Overridden by child class (Derived)
     */
    public void printALine(int length)
    {
        for(int i = 0; i < length*2; i++)
        {
            System.out.print("_");
        }
    }
    
    public abstract void count(int x); 
}
