
public class Runner
{
   public static void main (String [] args)
    {
        EliteBarbarian eb1 = new EliteBarbarian();
        EliteBarbarian eb2 = new EliteBarbarian();
        eb1.name = "Level 10 Elite Barbarian 1 is on the tower!";
        eb2.name = "Level 10 Elite Barbarian 2 is on the tower!";
        System.out.println(eb1.name);
        System.out.println(eb2.name);
        System.out.println("Is Elite Barbarian 1 attacking? " + eb1.attack);
        System.out.println("Is Elite Barbarian 2 attacking? " + eb2.attack);
        RoyalGiant rg = new RoyalGiant();
        rg.name = "Level 10 Royal Giant is firing tower!";
        System.out.println(rg.name);
        System.out.println("Is the Royal Giant attacking? " + rg.attack);
        System.out.println("Without rage, Royal Giant fires " + rg.damageLevel);
        int i = 61 + 174;
        System.out.println("With rage, Royal Giant fires " + i);
        int damage = 377;
        System.out.println("With rage, Elite Barbarian 1 is hitting " + damage);
    }
}
