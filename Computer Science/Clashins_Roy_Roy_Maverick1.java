
/**
 * This Good Game is made by Maverick
 * I used the resources from this semester
 */
public class Clashins_Roy_Roy_Maverick1
{
    //Attributes
    double damageLevel = 174.0;
    String name = "Royal Giant";
    boolean attack1 = true;

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
    boolean rage = true;
    public void getRage(boolean rage)
    {
        if(rage == true)
        {
            damageLevel *= 1.35;
        }
    }

    //Attributes
    double damageLeveleb = 279.0;
    String name1 = "Elite Barbarians";
    boolean attack = true;

    //Behaviors
    public void kill()
    {
        System.out.println("RAAH");
    }

    public boolean isMuerte()
    {
        if(damageLevel > 254)
        {
            return true;
        }
        return false;
    }

    
}

