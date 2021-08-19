
/**
 * Maverick Berkland
 * The For Loop
 */
public class ForLoop
{
    public static void main (String [] args)
    {
        /**
         * Remember:
         * For the while loop to iterate over a specified interval (Ex: numbers 1-10)
         * We needed 3 things:
         * A counter
         * A condition
         * An incrementer
         */
        
        int count = 0;
        while (count < 10)
        {
            System.out.println(count);
            count = count + 1;
        }
        System.out.println("Next loop");
        System.out.println(" ");
        for(int counter = 0; counter < 10; counter++)
        {
            System.out.println(counter);
        }
        
        /**
         * Increment Operators
         * ++ => increments by 1 (count = count + 1)
         * -- => decrements by 1 (count = count - 1)
         * x += y => x increments by y
         * x -= y => x decrements by y
         */
        //i for iteration
        System.out.println("Next loop");
        System.out.println(" ");
        for(int i = 0; i < 5; i++)
        {
            i+=2;
            System.out.println(i);
        }
        //i is Private
        /**
         * Private i LOL :)
         */
        System.out.println("Next loop");
        System.out.println(" ");
        for(int i = 0; i < 5; i++)
        {
            System.out.println(i);
        }
        System.out.println("Next loop");
        System.out.println(" ");
        for(int i = 10; i >= 1; i--)
        {
            System.out.println(i);
            /**
             * Countdown (10 to 1)
             */
        }
        System.out.println("Next loop");
        System.out.println(" ");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(i+2);
        }
        System.out.println("Next loop");
        System.out.println(" ");
        for(int i = 10; i <= 15; i++)
        {
            System.out.println(i);
        }
        System.out.println("Next loop");
        System.out.println(" ");
        for(int i = 100; i >= 50; i--)
        {
            System.out.println(i);
        }
    }
}

