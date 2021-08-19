
/**
 * Extension of Clashins_Roy_Roy_Maverick
 */
public class EliteBarbarian
{
    //Attributes
    double damageLevel = 279.0;
    String name = "Elite Barbarians";
    boolean attack = true;

    //Behaviors
    public void destroy()
    {
        System.out.println("RAAH");
    }

    public void skarmy()
    {
        attack = false;        
    }

    public boolean isDead()
    {
        if(damageLevel > 254)
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