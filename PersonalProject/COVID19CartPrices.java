import java.util.*;
/**
 * Write a description of class CartPrices here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class COVID19CartPrices
{
    public static void main (String [] args)
    {
        System.out.println("How much is it per golf cart?");
        double cost = (new Scanner(System.in)).nextDouble();
        System.out.println("How many golfers are riding in carts?");
        int riders = (new Scanner(System.in)).nextInt();

        double total1 = cost * riders;
        double total2 = cost * ( ( riders - riders % 2) / 2 + riders % 2);
        int carts = (riders - riders%2)/2 + riders%2;
        System.out.println("The original cost for everyone to be riding separately due to COVID-19 is $" + total1 + " with " +  riders + " carts, but since I'm a nice guy, I will give you a discounted rate.");
        System.out.println("The discounted rate follows these rules: 2 people can fit in a cart during normal times, so if you have an even number of riders, divide the total cost by two.");
        System.out.println("If you have an odd amount of riders, I will subtract one and divide the remaining number by two, then add one and multiply by the cost per cart.");
        System.out.println("That being said, your price comes out to be: $" + total2 + " with the price at " + carts + " carts during normal times.");
    }
}
