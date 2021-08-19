package PolyDog;
/**
 * Write a description of class Poodle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poodle extends Dog
{
    public boolean canSwim()
    {
        return true;
    }
    
    public void Who()
    {
        System.out.println("I'm a Poodle");
    }
    
    Poodle()
    {
        Who();
    }
}
