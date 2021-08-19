package ChildTest;
public class Derived2 extends Base implements SmallBase
{
    Derived2()
    {
        //Super calls parent's constructor
        super();
    }

    @Override
    public void count(int x)
    {
        for(int i = x; i > 0; i--)
        {
            System.out.println(x);
            x--;
        }
    }
    
    public void oof(String Test)
    {
        Test = "Hello";
    }
    
    @Override
    public String makeExciting(String y)
    {
        y = y.toUpperCase();
        System.out.println(y);
        return y;
    }
}
