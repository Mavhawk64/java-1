// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package triptypes;

import java.text.DecimalFormat;
/**
 * This class is the Cruise class.
 * @author mavberk and abdoullatounji.
 *
 */
public class Cruise extends FlightOptionalPackage
{
	/**
	 * Rounding Format.
	 */
	private static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Given Max Amount of Excursions.
	 */
	private static final int MAX_EX = 10;
	/**
	 * Port City (Departure Location).
	 */
	private String port;
	/**
	 * Vessel Name.
	 */
	private String vessel;
	/**
	 * Base Price for Cabin.
	 */
	private double base;
	/**
	 * Departing Date.
	 */
	private java.util.Calendar depDate;
	/**
	 * Returning Date.
	 */
	private java.util.Calendar retDate;
	/**
	 * Current CabinType.
	 */
	private CabinType curr = CabinType.INTERIOR;
	/**
	 * Amount of Excursions.
	 */
	private int numEx;
	/**
	 * List of Excursions.
	 */
	private String[] exList;
	/**
	 * List of costs for Excursions.
	 */
	private double[] cost;
	/**
	 * Input name of trip.
	 */
	private String n;
	/**
	 * Creates a new Cruise trip with specified values for all data except optional excursions.
	 * @param name - The promotional name of the travel package.
	 * @param numDays - The number of days for this travel package.
	 * @param vesselName - The ship name for this Cruise.
	 * @param portCity - The departure port for this Cruise.
	 * @param departs - The time and date of departure from the port.
	 * @param returns - The time and date of return to the port.
	 * @param basePrice - The base price for the cheapest tier cabin (interior) on the ship.
	 * Cabin upgrades can be accommodated through a subsequent setter call.
	 */
	public Cruise(java.lang.String name, int numDays, java.lang.String vesselName, java.lang.String portCity,
			java.util.Calendar departs, java.util.Calendar returns, double basePrice)
	{
		super(name, numDays);
		n = name;
		vessel = vesselName;
		port = portCity;
		depDate = departs;
		retDate = returns;
		base = basePrice;
		numEx = 0;
		exList = new String[MAX_EX];
		cost = new double[MAX_EX];
	}
	
	/**
	 * Adds a named excursion to this Cruise.
	 * Excursions may or may not have an additional charge associated.
	 * A maximum of 10 excursions can be added.
	 * @param excursion - The name of the excursion to add to this package.
	 * Empty excursion values are invalid and should not result in a change to the Cruise package configuration.
	 * @param price - The price of the excursion.
	 * Prices must be >= 0, with any negative values being treated as equivalent to 0.
	 */
	public void addExcursion(java.lang.String excursion, double price)
	{
		if (numEx < MAX_EX && excursion != null && !excursion.equals(" ") && !excursion.equals(""))
		{
			exList[numEx] = excursion;
			cost[numEx] = price > 0 ? price : 0;
			numEx++;
				
		}
	}
	
	/**
	 * Retrieves an array containing all of the excursions which have been added to this Cruise,
	 * in the order in which they were added.
	 * @return The list of excursions.
	 */
	public java.lang.String[] getExcursions()
	{
		return exList;
	}
	
	/**
	 * Updates the cabin configuration for this Cruise.
	 * This method can be used to upgrade a cruise from the base price
	 * corresponding to the cheapest cabin (an interior cabin without any ocean view).
	 * @param cabin - A valid alternate cabin level for this package.
	 */
	public void setCabinType(CabinType cabin)
	{
		if (cabin == CabinType.BALCONY)
		{
			curr = CabinType.BALCONY;
		}
		else if (cabin == CabinType.OCEAN_VIEW)
		{
			curr = CabinType.OCEAN_VIEW;
		}
		else if (cabin == CabinType.SUITE)
		{
			curr = CabinType.SUITE;
		}
		else
		{
			curr = CabinType.INTERIOR;
		}
	}
	
	/**
	 * Retrieves the cabin level currently associated with this Cruise package.
	 * @return The current cabin level.
	 */
	public CabinType getCabinType()
	{
		return curr;
	}
	
	/**
	 * Retrieves the home port of the cruise ship for this package.
	 * @return - The city from which this Cruise departs.
	 */
	public java.lang.String getHomePort()
	{
		return port;
	}
	
	/**
	 * Retrieves the date and time of departure for this Cruise.
	 * @return - Departure time at port.
	 */
	public java.util.Calendar getDepartureDate()
	{
		return depDate;
	}
	
	/**
	 * Retrieves the date and time of arrival for this Cruise.
	 * @return - Arrival time.
	 */
	public java.util.Calendar getReturnDate()
	{
		return retDate;
	}
	
	/**
	 * Retrieves the name of ship sailing for this Cruise.
	 * @return - Ship name.
	 */
	public java.lang.String getVesselName()
	{
		return vessel;
	}
	
	/**
	 * Retrieves the total cost for all added excursions on this Cruise.
	 * @return - Excursion Costs.
	 */
	public double getExcursionCosts()
	{
		/**
		 * Summation of costs of excursions.
		 */
		double sum = 0;
		for (int i = 0; i < MAX_EX; i++)
		{
			sum += cost[i];
		}
		return sum;
	}
	
	/**
	 * Retrieves the number of excursions which have been added to this Cruise package.
	 * @return - Number of excursions.
	 */
	public int getNumExcursions()
	{
		return numEx;
	}
	
	/**
	 * Retrieves the full price of this Cruise package,
	 * including pre-cruise flight arrangements (as applicable),
	 * full lodging costs,
	 * and any additional excursion costs.
	 * 
	 * Specified by:
	 * getPrice in class VacationPackage.
	 * 
	 * @return - Price of vacation package.
	 */
	public double getPrice()
	{
		return super.getFlightCosts() + getLodgingCost() + getExcursionCosts();
	}
	
	/**
	 * Retrieves the deposit amount required upfront for this Cruise.
	 * Cruise packages require that all applicable flight costs
	 * and 50% of expected lodging costs are paid at the time of booking.
	 * Optional excursion costs are not included in the deposit amount,
	 * but must be paid prior to departure.
	 * @return - The Deposit.
	 */
	public double getDepositAmount()
	{
		return super.getFlightCosts() + getLodgingCost() / 2;
	}
	
	/**
	 * Retrieves the lodging charge for this Cruise package,
	 * calculated from the base price scaled based on the
	 * cabin level according to the following fee schedule:
	 * 
	 * Interior Room:     100% of base price
	 * Ocean View Room:   150% of base price
	 * Balcony Room:      300% of base price
	 * Luxury Suite:      500% of base price
	 * 
	 * Specified by:
	 * getLodgingCost in class VacationPackage.
	 * 
	 * @return - Lodging Subtotal.
	 */
	public double getLodgingCost()
	{
		double temp = -1;
		if (getCabinType() == CabinType.BALCONY)
		{
			temp = base + base + base;
		}
		else if (getCabinType() == CabinType.INTERIOR)
		{
			temp = base;
		}
		else if (getCabinType() == CabinType.OCEAN_VIEW)
		{
			temp = base + base / 2;
		}
		else if (getCabinType() == CabinType.SUITE)
		{
			temp = base + base + base + base + base;
		}
		return temp;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Cruise package.
	 * The required format for this string includes information as
	 * described by FlightOptionalPackage followed by cruise details on the next line.
	 * The second line should be prefixed with 11 blank spaces for alignment below the trip name.
	 * An example of this format is shown here:
	 * $ 2499.99  Bermuda Triangle...and Maybe Back (Flight Not Included)
	 * 			  Cruising from Miami on the Caribbean Princess
	 * If optional excursions have been added,
	 * a parenthetical suffix will be added indicating how many excursions are included:
	 * $ 2499.99  Bermuda Triangle...and Maybe Back (Flight Not Included)
     *            Cruising from Miami on the Caribbean Princess (includes 4 excursions).
     * @return - Formatted String Summary.
	 */
	@Override
	public java.lang.String toString()
	{
		String adj = super.hasFlights() ? "" : "Not ";
		if (numEx > 0)
		{
			return "$" + String.format("%8s", df.format(getPrice())) + "  " + n
					+ " (Flight " + adj + "Included)\n"
					+ String.format("%11s", " ") + "Cruising from "
					+ getHomePort() + " on the " + getVesselName()
					+ " (includes " + numEx + " excursions)";
		}
		else
		{
			return "$" + String.format("%8s", df.format(getPrice())) + "  " + n
					+ " (Flight " + adj + "Included)\n"
					+ String.format("%11s", " ") + "Cruising from "
					+ getHomePort() + " on the " + getVesselName();
		}
	}
}
