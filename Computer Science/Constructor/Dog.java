package Constructor;


/**
 * Write a description of class Dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog
{
    //Attribute
    boolean likeBones = true;
    String name;
    //Constructor
    Dog(String n)
    {
        name = n;
    }
    public void speak()
    {
        System.out.println("RUFF");
    }
}
