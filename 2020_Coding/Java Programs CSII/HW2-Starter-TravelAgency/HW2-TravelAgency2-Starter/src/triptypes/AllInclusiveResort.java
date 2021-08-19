// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package triptypes;

import java.text.DecimalFormat;

/**
 * This class encapsulates details related to an all-inclusive resort vacation package. 
 * Flight information to/from the resort location can be added an additional price. 
 * Once at the resort,
 * all-inclusive packages are billed using a flat fee,
 * regardless of the number of included amenities.
 * @author bdorn
 *
 */
public class AllInclusiveResort extends FlightOptionalPackage
{
	/**
	 * Rounding Format.
	 */
	private static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Trip name.
	 */
	private String n;
	/**
	 * Amount of days.
	 */
	private int days;
	/**
	 * Resort name.
	 */
	private String resortName;
	/**
	 * Amount of people allowed in a room.
	 */
	private int capacity;
	/**
	 * Price in one night.
	 */
	private double nightPrice;
	/**
	 * List of amenities.
	 */
	private String[] amenities;
	
	/**
	 * Creates a new AllInclusiveResort package.
	 * @param name - The promotional name for this package.
	 * @param numDays - The number of days included in this vacation package.
	 * @param resort - The name of the resort.
	 * @param guestsPerRoom - The number of guests allowed per room at the included price.
	 * @param pricePerNight - The price of the stay per night.
	 * @param amenitiesList - A list of amenities available for free at the resort.
	 */
	public AllInclusiveResort(java.lang.String name, int numDays, java.lang.String resort, 
			int guestsPerRoom, double pricePerNight, java.lang.String[] amenitiesList)
	{
		super(name, numDays);
		n = name;
		days = numDays;
		resortName = resort;
		capacity = guestsPerRoom;
		nightPrice = pricePerNight;
		amenities = amenitiesList;
		
	}
	/**
	 * Retrieves a single String containing all of the available amenities at the resort. 
	 * Individual amenities should be separated by a single comma and space character, 
	 * with no such separator at the end of the string.
	 * @return The amenities list.
	 */
	public java.lang.String getAmenities()
	{
		/**
		 * String concatination of amenities array.
		 */
		String listConcat = "";
		for (int i = 0; i < amenities.length - 1; i++) //Either Error, or not Tested enough
		{
			listConcat += amenities[i] + ", ";
		}
		listConcat += amenities[amenities.length - 1];
		return listConcat;
	}
	
	/**
	 * Retrieves the number of guests allowed per room at the specified rate.
	 * @return The number of guests per room.
	 */
	public int getGuestsPerRoom()
	{
		return capacity; //Not Tested enough
	}
	
	/**
	 * The full price for this all-inclusive package, including any optional flight pricing.
	 * Specify by getPrice in class VacationPackage
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return getLodgingCost() + super.getFlightCosts(); //Not Tested enough
	}
	
	/**
	 * The required deposit amount to be made at the time of booking. 
	 * All upfront flight-related costs and 50% of the total lodging costs for this trip must be paid as a deposit.
	 * @specifyby getDepositAmount in class VacationPackage
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount() //Not Tested enough
	{
		return super.getFlightCosts() + getLodgingCost() / 2;
	}
	
	/**
	 * A formatted summary string with details about this all-inclusive resort package. 
	 * The string will contain information as described by FlightOptionalPackage 
	 * followed by details about the resort and the number of people included at the specified price. 
	 * The second line should be prefixed with 11 blank spaces for alignment below the trip name. For example:
$  450.35  Punta Cana Fiesta! (Flight Included)
           An all-inclusive stay at Flip Flops for 2 people!
	 * @override toString in class FlightOptionalPackage
	 * @return The formatted string summary.
	 */
	public java.lang.String toString()
	{
		if (super.hasFlights())
		{
			return "$  " + df.format(getPrice()) + "  " + n
					+ "! (Flight Included)\r\n           An all-inclusive stay at "
					+ resortName + " for " + capacity + " people!";
		}
		else
		{
			return "$  " + df.format(getPrice()) + "  " + n
					+ "! (Flight Not Included)\r\n           An all-inclusive stay at "
					+ resortName + " for " + capacity + " people!";
		}
	}
	
	
	
	/**
	 * Retrieves the subtotal for lodging associated with this all inclusive resort stay 
	 * based on the number of nights in the package and the base price.
	 * @specifyby getLodgingCost in class VacationPackage
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost() //Not Tested enough
	{
		return (days - 1) * nightPrice;
	}
	
	

}