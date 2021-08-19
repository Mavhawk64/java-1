
/**
 * Maverick Berkland
 * Object Oriented Programming Review
 * 29 August, 2017
 */
public class Zoo
{
    public static void main (String [] args)
    {
        Giraffe Jeff = new Giraffe();
        Giraffe Jane = new Giraffe();
        //Void Method
        System.out.print("Jeff: ");
        Jeff.makeNoise();
        System.out.println("Jane: ");
        Jane.makeNoise();
        //Return Method
        boolean test1 = Jeff.isAlive();
        boolean test2 = Jane.isAlive();
        //Parameter Method
        Jeff.flipIt(false);
        Jane.flipIt(true);
    }
}
