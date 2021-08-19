package VirtualPet;

public class RunnerMaverick
{
   public static void main (String [] args)
   {
       Pet sparky = new Pet();
       System.out.println("Are you a Master Trainer?");
       while(sparky.checkLife()==true && sparky.checkTrained() == false)
       {
             sparky.giveCommands();
        }
    }
}
