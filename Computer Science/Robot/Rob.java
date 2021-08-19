package Robot;
import java.awt.Robot;
import java.awt.Dimension;
import java.awt.event.InputEvent;
/**
 * Write a description of class ROB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rob
{
    public void print(int [][] toPrint)
    {
        int [][] array = toPrint;
        try
        {
            Robot r = new Robot();
            int startX = 1920/2;
            int startY = 1080/2;
            for(int i = 0; i < array.length; i++)
            {
                for(int j = 0; j < array[i].length; j++)
                {
                    if(array[i][j] == 0)
                    {

                    }
                    else
                    {
                        r.mouseMove(startX + i, startY + j);
                        r.mousePress(InputEvent.BUTTON1_MASK);
                        r.mouseRelease(InputEvent.BUTTON1_MASK);
                    }
                }
            }
        }
        catch(Exception err)
        {
            System.out.print("CAN'T DO THAT!!!");
        }
    }
}
