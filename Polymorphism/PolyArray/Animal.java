package PolyArray;
import java.awt.*;

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal
{
    public void makeNoise()
    {
        System.out.println("SOUND");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println("DEAD");
        }
        Toolkit.getDefaultToolkit().beep();
    }
}
