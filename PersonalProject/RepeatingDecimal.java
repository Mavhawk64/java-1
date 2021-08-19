import java.util.*;
/**
 * This program asks for three repeating iterations of a number. It gets the number by
 * dividing the inputted string in thirds after establishing the front number (the number
 * before the decimal) and the decimal. An example is inputting the string: "1.123123123",
 * in which it will take off the first number, "1", and get the decimal, "123123123", and
 * divide the decimal into three, using the length of the string divided by three, leaving
 * us with "123". This will be converted into an int after getting the length of the string
 * left over, 3. The numerator will be calculated by my own algorithm, and divided by a
 * summation equation, such that the denominator will be 9, 99, 999, 9999,... etc. 
 *
 * @Maverick Berkland
 * @7 July, 2019
 */
public class RepeatingDecimal
{
    public static void main ()
    {
        println("Please enter a repeating decimal with exactly 3 repetitions. \n Examples: 1.123123123 or 3.333 (or 3.333333333 or 3.333333) or 9.121212.");
        println("P.S. Without a version of three repetitions, the computing gets messed up.\nAlso, if the size of the number is too large, it will mess up.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int rep = getRep(input);
        int first = getFirst(input);
        int n = getN(rep);
        int denom = getDenom(n);
        int numer = getNum(rep, first, n);
        String fraction = numer + "/" + denom;
        println("Your fraction is... " + fraction);
        double backwards = (double)numer/denom;
        println("The decimal dividing those two numbers is... " + backwards + "\n PSA: This may have a rounding error at the \n very last digit, such as when you use 3.333.");
        println("\n\n\nWould you like to go again?");
        Scanner resp = new Scanner(System.in);
        String yesorno = resp.nextLine();
        yesorno = (yesorno.trim()).toLowerCase();
        if(yesorno.contains("y"))
            main();
    }

    public static int getRep (String input)
    {
        //Using 1.123123123 as example
        input = input.substring(input.indexOf(".")+1, input.length());
        input = input.substring(0, input.length()/3);
        int rep = Integer.parseInt(input);
        return rep;   
    }

    public static int getFirst(String input)
    {
        input = input.substring(0, input.indexOf("."));
        int first = Integer.parseInt(input);
        return first;
    }

    public static int getN (int rep)
    {
        int n = 0;
        while(rep >= 1)
        {
            rep = rep/10;
            n++;
        }
        return n;
    }

    public static int getDenom (int n)
    {
        int denom = 0;
        for(int k = 0; k < n; k++)
            denom += (9*((int)(Math.pow(10,k))));
        return denom;
    }

    public static int getNum(int rep, int front, int n)
    {
        int numerator = front*((int)(Math.pow(10, n))) + rep - front;
        return numerator;
    }

    //Just for cleanliness
    public static String print(String x)
    {
        System.out.print(x);
        return "0";
    }

    public static String println(String x)
    {
        System.out.println(x);
        return "0";
    }
}
