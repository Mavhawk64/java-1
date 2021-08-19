package PolyArray;
import java.awt.*;
public class Cat extends Animal
{
    @Override
    public void makeNoise()
    {
        System.out.println("MEOW");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println("DEAD");
        }
        final Runnable runnable =
            (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
        if(runnable != null) runnable.run();
    }
}