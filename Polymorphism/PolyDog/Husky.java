package PolyDog;
/**
 * Write a description of class Husky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Husky extends Dog
{
    public boolean dealsWithWinter()
    {
        return true;
    }
    
    public void Who()
    {
        System.out.println("I'm a Husky");
    }
    
    Husky()
    {
        Who();
    }
}
