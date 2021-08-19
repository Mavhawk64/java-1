package PolyParent;

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question
{
    public static class Test extends Huh
    {
        public void WHAT()
        {
            System.out.println("Hello World.");
            Cow();
        }

        @Override
        public void Cow()
        {
            System.out.println("*Eats grass*");
            super.Cow();
        }
    }

    public static void main (String [] args)
    {
        Test t1 = new Test();
        t1.WHAT();
    }

    public static class Huh
    {
        public void Cow()
        {
            System.out.println("MOO");
        }
    }
}

