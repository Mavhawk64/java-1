// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package travelgui;

import triptypes.VacationPackage;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;
/**
 * This class serves as a collection to store, filter,
 * and explore VacationPackages within the trip search user interface. 
 * Up to 25 VacationPackages can be stored in a single collection.
 * @author  mberkland and abdoullatoundji
 *
 */
public class VacationPackageCollection
{
	/**
	 * Given max amount of trips.
	 */
	private static final int MAX_TRIPS = 25;
	/**
	 * Given max amount of flights.
	 */
	private static final int MAX_FLIGHTS = 12;
	/**
	 * Array of Vacation Packages.
	 */
	private VacationPackage[] vacaPack;
	/**
	 * Total Number of trips.
	 */
	private int numTrips;
	/**
	 * Creates a new empty VacationPackageCollection.
	 */
	public VacationPackageCollection()
	{
		vacaPack = new VacationPackage[MAX_TRIPS];
		numTrips = 0;
	}
	
	/**
	 * Retrieves the number of trip packages that have
	 * been added to this collection for purchase.
	 * @return The total number of available packages.
	 */
	public int getNumTrips()
	{
		return numTrips;
	}
	
	/**
	 * Retrieves an array of all available packages from the collection.
	 * Valid packages are guaranteed to be stored contiguously in
	 * the left most array cells. Any empty cells will appear to
	 * the right of the last valid VacationPackage.
	 * Unless a sort has occurred, packages will appear in
	 * the order in which they were added.
	 * @return The list of available packages, or null if no packages exist.
	 */
	public VacationPackage[] getAllVacations()
	{
		return numTrips == 0 ? null : vacaPack;
	}
	
	/**
	 * Adds a single trip package to the collection at the next available position.
	 * If adding this trip would result in
	 * more than 25 total packages, it will not be added to the collection.
	 * @param trip - The trip to add to the collection.
	 */
	public void addVacation(VacationPackage trip)
	{
		if (numTrips < MAX_TRIPS)
		{
			vacaPack[numTrips] = trip;
			numTrips++;
		}
	}
	
	/**
	 * Retrieves a filtered subcollection of trips corresponding to a specific subtype.
	 * Should no trips of a specified type be present in this
	 * VacationPackageCollection an empty collection containing zero
	 * packages will be returned.
	 * @param selection - An integer signaling what type
	 * of packages to extract.
	 * 1 represents RoadTrips,
	 * 2 represents Cruises,
	 * and 3 represents All-Inclusive Resort packages.
	 * @return The filtered subcollection of packages,
	 * or an empty collection if no matching packages
	 * exist in this collection.
	 */
	public VacationPackageCollection filterVacationsFor(int selection) //0E, 1R, 2C, 3A
	{ //Either Error, or not Tested enough
		/**
		 * Forcible String variable that contains strings of all tripTyes.
		 */
		String[] myString = {"", "road", "Cruis", "all-"};
		VacationPackage[] filter = this.getAllVacations();
		VacationPackageCollection output = new VacationPackageCollection();
		for (int i = 0; i < filter.length; i++)
		{
			if (filter[i] != null && filter[i].toString().contains(myString[selection]))
			{
				output.addVacation(filter[i]);
			}
		}
		return output;
	}
	
	/**
	 * Produces a summary of flight information
	 * inside a VacationPackage for detail display elsewhere.
	 * In addition to properly extracting flight details
	 * when the given index corresponds to a FlightOptionalPackage
	 * with one or more flight legs, this method will also detect
	 * various error conditions. In erroneous situations,
	 * one of the following strings will be produced:
	 * 
	 * ERROR: Index is out of range!
	 * ERROR: No flights are allowed for this type of trip!
	 * ERROR: The selected trip has no flight information.
	 * 
	 * Each of these errors corresponds to invalid range
	 * input, packages for which flights cannot
	 * be added in the first place, and packages
	 * which potentially could (but do not yet) have flight data.
	 * @param index - The index position in the collection
	 * from which to extract flight information.
	 * @return - The formatted flight details,
	 * with one Flight per line and each Flight
	 * displayed as detailed in Flight.toString.
	 */
	public java.lang.String getFlightDetails(int index) //Either Error, or not Tested enough
	
	{
		String g = "";
		if (index < 0 || index >= MAX_FLIGHTS)
		{
			g =  "ERROR: Index is out of range!";
		}
		else if (vacaPack[index] instanceof FlightOptionalPackage)
		{
			FlightOptionalPackage flight = (FlightOptionalPackage) vacaPack[index];
			if (flight.hasFlights())
			{
				Flight[] flights = flight.getFlightItinerary();
				for (int i = 0; i < flights.length; i++)
				{
					g += flights[i].toString();
					if (flights[i + 1] != null)
					{
						g += "\n";
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				g = "ERROR: The selected trip has no flight information.";
			}
		}
		else
		{
			g = "ERROR: No flights are allowed for this type of trip!";
		
		}
		return g;
	}
	
	/**
	 * Provides 0-based indexed access to the VacationPackageCollection.
	 * @param index - The index position whose VacationPackage should be returned.
	 * @return - The selected VacationPackage when index is valid.
	 * The method will return null otherwise.
	 */
	public VacationPackage getItemAt(int index)
	{
		if (index < 0 || index > numTrips)
		{
			return null;
		}
		else
		{
			return vacaPack[index];
		}
	}
	
	/**
	 * Produces a stable sort of the contents of
	 * this VacationPackageCollection, with the
	 * sort order determined by an externally
	 * specified criteria. When byPrice is true,
	 * the method will sort all available packages
	 * in ascending order by total package price.
	 * When false, the method sorts packages in
	 * standard lexicographically ascending order
	 * by package name
	 * (see, https://en.wikipedia.org/wiki/Lexicographical_order).
	 * @param byPrice - A flag which sets the sort criteria as described above.
	 */
	public void sortCollection(boolean byPrice)
	{
		if (byPrice)
		{
			bubblePrice();
		}
		else
		{
			bubbleName();
		}
	}
	
	/**
	 * This method is the Bubble Sort for sorting by price.
	 */
	private void bubblePrice()
	{
		
		double[] prices = new double[MAX_TRIPS];
		
		for (int i = 0; i < prices.length; i++)
		{
			if (vacaPack[i] != null)
			{
				prices[i] = vacaPack[i].getPrice();
			}
			
		}
		boolean sorted;
		for (int pass = 0; pass < prices.length - 1; pass++)  // count passes
		{	
			sorted = true;
			for (int comp = 0; comp < prices.length - 1; comp++) // check order
			{
			
				if (prices[comp] > prices[comp + 1]) //Either Error, or not Tested enough
				{
					sorted = false;
					double t = prices[comp];
					VacationPackage temp = vacaPack[comp];
					prices[comp] = prices[comp + 1];
					vacaPack[comp] = vacaPack[comp + 1];
					prices[comp + 1] = t;
					vacaPack[comp + 1] = temp;
				}				
			}
			if (sorted) //Either Error, or not Tested enough
			{
				break;
			}
		}
	}	

		
	
	
	/**
	 * This method is the Bubble Sort for sorting by name.
	 */
	private void bubbleName()
	{
		String[] str = new String[numTrips];
		for (int i = 0; i < str.length; i++)
		{
			str[i] = vacaPack[i].toString().substring(
					vacaPack[i].toString().indexOf(vacaPack[i].getName()),
					vacaPack[i].toString().length());
		}
		
		for (int i = 0; i < str.length; i++)
		{
			for (int j = i + 1; j < str.length; j++) //Either Error, or not Tested enough
			{
				if (str[i].compareToIgnoreCase(str[j]) > 0) //Either Error, or not Tested enough
				{
					String t = str[i];
					VacationPackage temp = vacaPack[i];
					str[i] = str[j];
					vacaPack[i] = vacaPack[j];
					str[j] = t;
					vacaPack[j] = temp;
				}
			}
		}
	}
}