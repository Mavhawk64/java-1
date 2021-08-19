
public class Ghost
{
    //Attributes
    int scaryLevel = 10;
    String color = "white";
    boolean flow = true;

    //Behaviors
    public void scare()
    {
        System.out.println("BOO!");
    }

    public void bust()
    {
        flow = false;
    }
    //This is a return type method
    //It returns a boolean value
    public boolean isCaught ()
    {
        if(scaryLevel > 7)
        {
            return true;
        }
        return false;
    }

    public void eatFruit (boolean fruit)
    {
        if(fruit == true)
        {
            scaryLevel++;
        }
    }
    
    public void printCaught()
    {
        if(isCaught())
        {
            System.out.println("I'm caught ;(");
        }
    }
}