import java.util.Scanner;
/**
 * Maverick Berkland
 * I made this Temperature conversion chart with my own knowledge from this semester.
 * 8 February, 2017
 */
public class Temperature
{
    public static void main ()
    {
        System.out.println("Welcome to the Fahrenheit-Celsius Converter!");
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Give me a reasonable temperature range:");
        System.out.println("");
        System.out.println("Please give me your maximum temperature (°F)");
        int maxTemp = scan.nextInt();
        System.out.println("");
        System.out.println("Now enter your minimum temperature (°F)");
        int minTemp = scan.nextInt();
        System.out.println("Fahrenheit\t\tCelsius");
        System.out.println("-------------------------------");
        for(double i = minTemp; i <= maxTemp; i++)
        {
            double celsius = 0.0;
            celsius = (i - 32)/1.8;
            System.out.println(i + "\t\t" + celsius);
        }
    }
}