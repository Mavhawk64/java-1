package FlowerSimulator;
public class Tester extends Plant implements Flower
{    
    @Override
    public void createFlower()
    {
        System.out.println("FLOWER");
    }
    
    @Override
    public void input()
    {
        
    }
    
    public void drawBlossom(){}
    
    Tester()
    {
        super();
        printPot();
    }
}