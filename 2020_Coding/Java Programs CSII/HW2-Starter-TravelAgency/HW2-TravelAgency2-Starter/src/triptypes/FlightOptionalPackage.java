// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.
package triptypes;

/**
 * This is the Optional Flight Package.
 * @author mavberk and abdoullatoundji
 *
 */
public abstract class FlightOptionalPackage extends VacationPackage
{
	/**
	 * Maximum amount of flights.
	 */
	private static final int MAX_FLIGHTS = 12;
	/**
	 * Counts amount of flights.
	 */
	private int flights;
	/**
	 * List of Flights.
	 */
	private Flight[] flightList;
	/**
	 * Initializes details for a newly created FlightOptionalPackage.
	 * Upon creation, this package will contain no flight bookings.
	 * However, flight legs can be added at a later point.
	 * @param name - Name of package.
	 * @param numDays - Number of days package covers.
	 */
	public FlightOptionalPackage(java.lang.String name, int numDays)
	{
		super(name, numDays);
		flights = 0;
		flightList = new Flight[MAX_FLIGHTS];
	}
	/**
	 * Adds a single one-way flight to this package.
	 * Round trips and layovers are handled by multiple calls to addFlightLeg with one call for each flight.
	 * Flights must be added in chronological order, with the soonest flight added first.
	 * A maximum of up to 12 flights can be stored within a FlightOptionalPackage.
	 * @param details - A valid flight object to append to this itinerary.
	 * Invalid values (ie, null) or flights in excess of the 12 maximum will be
	 * ignored and will not impact this FlightOptionalPackage object.
	 */
	public void addFlightLeg(Flight details)
	{
		if (flights < MAX_FLIGHTS && details != null)
		{
			flightList[flights] = details;
			flights++;
		}
	}
	
	/**
	 * A predicate method for identifying whether a concrete object has at least one flight attached to it.
	 * @return - true when at least one flight.
	 */
	public boolean hasFlights()
	{
		return flights > 0;
	}
	
	/**
	 * Retrieves the current itinerary for this travel package.
	 * Flights are positioned in the returned array in the order
	 * in which they were added to this FlightOptionalPackage.
	 * @return - Current Itinerary array. Null when no flights.
	 */
	public Flight[] getFlightItinerary()
	{
		if (hasFlights())
		{
			return flightList;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * The total cost of all legs in this FlightOptionalPackage.
	 * @return - Sum of individual flight costs in package.
	 */
	public double getFlightCosts()
	{
		double sum = 0;
		if (hasFlights() && this.getFlightItinerary() != null)
		{
			for (int i = 0; i < flights; i++)
			{
				sum += this.getFlightItinerary()[i].getPrice(); //here
			}
		}
		return sum;
	}
	
	/**
	 * Retrieves a formatted string summary of this travel package.
	 * This string will be formatted exactly as prescribed by the TravelPackage class,
	 * with a postfix indicating whether flight information is included or not.
	 * For example, the strings below show two versions of a trip for each possible state.
	 * $1234.56 Spring Break at the Beach (Flight Included)
	 * $1234.56 Spring Break at the Beach (Flight Not Included).
	 * @return - Formatted String Summary.
	 */
	@Override
	public java.lang.String toString()
	{
		/**
		 * Combinatoric String.
		 */
		String s = "";
		for (int i = 0; i < flights; i++)
		{
			s += flightList[i] + "\r\n";
		}
		return s;
	}
}
