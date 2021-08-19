import java.util.*;
import java.math.*;
public class WindChill
{
	public static void main ()
	{
		System.out.println("Hello! Welcome to the Wind Chill Calculator!\nPlease enter whether you would like to solve for wind speed, temperature, or wind chill:");
		String input = (new Scanner(System.in)).nextLine();
		if(input.toLowerCase().trim().contains("speed"))
		{
			System.out.println("Input taken as WIND SPEED");
			windSpeed();
		}
		else if(input.toLowerCase().trim().contains("temp"))
		{
			System.out.println("Input taken as TEMPERATURE");
			temp();
		}
		else
		{
			System.out.println("Input taken as WIND CHILL");
			windChill();
		}
	}

	public static void windSpeed()
	{
		System.out.println("Please enter the Temperature (*F)");
		double t = (new Scanner(System.in)).nextDouble();
		System.out.println("Please enter the Wind Chill or Real-Feal (*F)");
		double c = (new Scanner(System.in)).nextDouble();
		double v = 0.000042799380*Math.pow(((-7.2690058479533*(t-1.609010458568*(c-35.74)))/(t-83.625730994152)), 6.25);
		System.out.println("With the conditions: " + t + "*F as the temperature and " + c + "*F as the Real-Feel or Wind Chill,\nthe Wind Speed is calculated as " + v + " mph.");
		againQ();
	}

	public static void temp()
	{
		System.out.println("Please enter the Wind Speed (mph)");
		double v = (new Scanner(System.in)).nextDouble();
		System.out.println("Please enter the Real-Feel or Wind Chill (*F)");
		double c = (new Scanner(System.in)).nextDouble();
		double t = (83.6257309942*(Math.pow(v,0.16)+0.027972027972*(c-35.74)))/(Math.pow(v,0.16)+1.45380116959);
		System.out.println("With the conditions: " + v + " mph as the wind speed and " + c + "*F as the Real-Feel or Wind Chill,\nthe Temperature is " + t + "*F.");
		againQ();
	}

	public static void windChill()
	{
		System.out.println("Please enter the Wind Speed in Miles Per Hour (mph)");
		double v = (new Scanner(System.in)).nextDouble();
		System.out.println("Please enter the Temperature in Farenheit (*F)");
		double t = (new Scanner(System.in)).nextDouble();
		double chili = 35.74 + 0.6215*t-35.75*Math.pow(v, 0.16)+0.4275*t*Math.pow(v,0.16);
		System.out.println("With the conditions: " + v + " mph as the wind speed and " + t + "*F as the temperature,\nthe Real-Feel or Wind Chill is " + chili + "*F.");
		againQ();
	}

	public static void againQ()
	{
		System.out.println("\n\nWould you like to try this again?");
		if((new Scanner(System.in).nextLine().toLowerCase().trim().contains("y")))
		{
			main();
		}
	}
}