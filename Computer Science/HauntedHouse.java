
public class HauntedHouse
{
    public static void main (String [] args)
    {
        Ghost g1 = new Ghost();
        Ghost g2 = new Ghost();
        Ghost g3 = new Ghost();
        g1.color = "pink";
        g2.color = "blue";
        g3.color = "yellow";
        System.out.println(g1.color);
        System.out.println(g2.color);
        System.out.println(g3.color);
        System.out.println(g1.flow);
        System.out.println("GHOST BUSTED!");
        g1.flow = false;
        System.out.println(g1.flow);
        System.out.println(g2.flow);
        //Below is a variable
        g1.scaryLevel -= 6;
        //Below is an action or method
        System.out.println("Can the ghost catch Player1? " + g1.isCaught());
        g1.eatFruit(true);
        System.out.println("Can the ghost catch Player1 after he eats fruit? " + g1.isCaught());
        g1.eatFruit(true);
        System.out.println("Can the ghost catch Player1 after he eats more fruit? " + g1.isCaught());
        g1.eatFruit(true);
        System.out.println("Can the ghost catch Player1 after he eats more fruit? " + g1.isCaught());
        g1.eatFruit(true);
        System.out.println("Can the ghost catch Player1 after he eats more fruit? " + g1.isCaught());
    }
}