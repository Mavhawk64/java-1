// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.
package triptypes;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 * This is the Flight class.
 * @author mberkland and abdoullatounji
 *
 */
public class Flight
{
	/**
	 * Airline XX.
	 */
	private String a;
	/**
	 * Flight number ####.
	 */
	private int n;
	/**
	 * Departure Location.
	 */
	private String f;
	/**
	 * Arrival Location.
	 */
	private String t;
	/**
	 * Departure Time.
	 */
	private Calendar l;
	/**
	 * Arrival Time.
	 */
	private Calendar r;
	/**
	 * Flight Ticket Price.
	 */
	private double p;
	/**
	 * Creates a new flight leg in the system.
	 * @param airline - The two letter airline code (e.g, "DL", "AA")
	 * @param flightNum - The unique flight number on a given day
	 * @param from - The three letter airport code for the departure airport (e.g, "OMA")
	 * @param to - The three letter airport code for the arrival airport (e.g., "CDG")
	 * @param leavesAt - The departure time
	 * @param arrives - The arrival time
	 * @param price - The price for this flight in US Dollars.
	 */
	public Flight(java.lang.String airline, int flightNum,
			java.lang.String from, java.lang.String to,
			java.util.Calendar leavesAt, java.util.Calendar arrives, double price)
	{
		a = airline;
		n = flightNum;
		f = from;
		t = to;
		l = leavesAt;
		r = arrives;
		this.p = price;
	}
	
	/**
	 * Retrieves the price of this flight.
	 * @return - Price.
	 */
	public double getPrice()
	{
		return this.p;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Flight. Strings will be formatted as:
	 * XX#### Departs: AIR at HH:mm MM-dd-YYYY; Arrives POR at HH:mm MM-dd-YYYY
	 * Where XX is the two letter airline abbreviation and #### is the flight number,
	 * which may be 1-4 digits in length and is right aligned in a 4 character wide field.
	 * AIR and POR are the departure and arrival airport codes, respectively.
	 * The HH:mm MM-dd-YYYY values correspond to the departure and arrival time formats using a 24-hour clock.
	 * (see, e.g., java.util.SimpleDateFormat). For example:
	 * DL 123 Departs: OMA at 15:25 03-15-2019; Arrives ATL at 18:01 03-15-2019
	 */
	@Override
	public java.lang.String toString()
	{
		//Adjust l and r to read properly.
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		String d = formatter.format(l.getTime());
		String b = formatter.format(r.getTime());
		
		return a + String.format("%4d",  n) + " Departs: " + f + " at " + d + "; Arrives " + t + " at " + b;
	}
}
