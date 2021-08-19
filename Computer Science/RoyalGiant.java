
/**
 * Extension of Clashings_Roy_Roy_Maverick
 */
public class RoyalGiant
{
    //Attributes
    double damageLevel = 174.0;
    String name = "Royal Giant";
    boolean attack = true;
    
    //Behaviors
    public void destroy()
    {
        System.out.println("OOOF!");
        System.out.println("*Shoots Cannon*");
    }

    public void skarmy()
    {
        attack = false;
    }
    
    public boolean isDead()
    {
        if(damageLevel > 159)
        {
            return true;
        }
        return false;
    }
    
    public void getRage(boolean rage)
    {
        if(rage == true)
        {
            damageLevel *= 1.35;
        }
    }
}
