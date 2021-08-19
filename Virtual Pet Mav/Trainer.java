package VirtualPet;

import java.util.Random;
/**
 * This Class represents the ability
 * to be trained. It keeps track 
 * of the Pets learning.
 */
public class Trainer
{
 
    //Attributes
    Random rand = new Random();
    int level = 0;
    int chance = 0;
    
    //Behaviors
    public int randomChance()
    {
        //Only 1 - 6
        chance = rand.nextInt(6)+1;
        //As you level up, it gets harder
        if(chance > level)
        {
            level++;
        }
        return level;
    }
    
    public String printStatus()
    {
        if(level == 0)
        {
            return ("is 0% trained");
        }
        else if(level == 1)
        {
             return ("is 16% trained");
        }
        else if(level == 2)
        {
             return ("is 33% trained");
        }
        else if(level == 3)
        {
            return ("is 50% trained");
        }
        else if(level == 4)
        {
            return ("is 66% trained");
        }
        else if(level == 5)
        {
             return ("is 83% trained");
        }
        else if(level == 6)
        {
             return ("is 100% trained");
        }
        else
        {
            return ("Trainer Class Error");
        }
    }
    
    
}
