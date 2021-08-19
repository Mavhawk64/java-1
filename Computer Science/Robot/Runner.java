package Robot;


/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main (String [] args)
    {
        Rob r = new Rob();
        RobotShapes shapes = new RobotShapes();
        try
        {
            Runtime.getRuntime().exec("mspaint.exe");
            Thread.sleep(2000);
            r.print(shapes.newHollowRectangle(30,30));
            r.print(shapes.newCircle(590000));
        }
        catch(Exception err)
        {
            System.out.println("CAN'T DO THAT!!!");
        }
    }
}
