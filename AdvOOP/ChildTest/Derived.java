package ChildTest;
public class Derived extends Base implements SmallBase
{
    Derived()
    {
        super();
        value = 48752;
    }

    //Prints a vertical line
    /**
     * Overriding the Base/Parent class
     */
    public void printALine(int length)
    {
        for(int i = 0; i < length; i++)
        {
            System.out.println("|");
        }
    }

    @Override
    public void count(int x)
    {
        for(int i = 1; i <= x; i++)
        {
            System.out.println(i);
        }
    }
    
    @Override
    public String makeExciting(String y)
    {
        y = y + "!!!";
        System.out.println(y);
        return y;
    }
}