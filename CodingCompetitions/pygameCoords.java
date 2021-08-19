
/**
 * Write a description of class pygameCoords here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pygameCoords
{
    public static void main ()
    {
        boolean done = false;
        int width = 1000;
        int height = 1000;
        int x = 0;
        int y = 0;
        boolean going_left = false;
        boolean going_up = false;
        int count = 0;
        while(!done)
        {
            count++;
            if(x == 0 || x+60 == width)
            going_left = !going_left;
            if(y == 0 || y+60 == height)
            going_up = !going_up;
            if(going_up && y>0)
            y-= 2;
            if(!going_up && y+60 < height)
            y+=2;
            if(going_left && x > 0)
            x-=2;
            if(!going_left && x+60 < width)
            x+=2;
            try
            {
                Thread.sleep(60);
            }
            catch(Exception e)
            {
                System.err.println(e);
            }
            System.out.println("("+x+", "+y+")");
            if(count == 1000)
            done = true;
        }
    }
}
