// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package triptypes;

import java.text.DecimalFormat;

/**
 * This class represents a RoadTrip vacation that includes a rental car, overnight lodging, and fuel cost estimation.
 * @author bdorn
 *
 */
public class RoadTrip extends VacationPackage
{
	/**
	 * Given Base Price for Hotel.
	 */
	private static final double BASE = 35.20;
	/**
	 * Given Price for 2-seater car.
	 */
	private static final double COUPE = 36.75;
	/**
	 * Given Price for 4-seater car.
	 */
	private static final double SEDAN = 50.13;
	/**
	 * Given Price for 6-seater car.
	 */
	private static final double CROSSOVER = 60.25;
	/**
	 * Given Price for 8-seater car.
	 */
	private static final double SUV = 70.50;
	/**
	 * Given Price for 9+seater bus.
	 */
	private static final double BUS = 150;
	/**
	 * Given Standard Gas Price Per Gallon.
	 */
	private static final double STANDARD_GAS = 2.50;
	/**
	 * Given Gas Mileage for 2-seater car.
	 */
	private static final double COUPE_MPG = 45;
	/**
	 * Given Gas Mileage for 4-seater car.
	 */
	private static final double SEDAN_MPG = 32;
	/**
	 * Given Gas Mileage for 6-seater car.
	 */
	private static final double CROSSOVER_MPG = 28;
	/**
	 * Given Gas Mileage for 8-seater car.
	 */
	private static final double SUV_MPG = 22;
	/**
	 * Given Gas Mileage for 9+seater bus.
	 */
	private static final double BUS_MPG = 15;
	/**
	 * Rounding Format.
	 */
	private static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Amount of days on road trip.
	 */
	private int days;
	/**
	 * Gas price on trip.
	 */
	private double gasPrice;
	/**
	 * Distance in miles of trip.
	 */
	private int dist;
	/**
	 * Number of people on trip.
	 */
	private int persons;
	/**
	 * Amount of stars on hotel.
	 */
	private int stars;
	/**
	 * Name of trip.
	 */
	private String n;
	/**
	 * List of stops.
	 */
	private String[] s;
	/**
	 * Number of stops.
	 */
	private int sCount;
	/**
	 * Creates a newly initialized RoadTrip object using the parameter data.
	 * @param name - The promotional name to use for this RoadTrip in the travel agency system.
	 * @param numDays - The number of days required for this RoadTrip.
	 * @param stops - A list of destinations that will be visited along the way on this RoadTrip.
	 * @param fuelCost - The estimated cost of fuel in US Dollars per Gallon based on current rates.
	 * @param miles - The total number of miles for this RoadTrip, assuming people follow the intended route.
	 * @param maxPersons - The number of people for whom this trip package will be budgeted.
	 * @param hotelStars - The quality level of the hotels used during the RoadTrip,
	 * ranging from 1..5 stars, inclusive. 
	 * Star values outside this range will be adjusted to the closest valid value.
	 */
	public RoadTrip(java.lang.String name, int numDays,
			java.lang.String[] stops, double fuelCost,
			int miles, int maxPersons, int hotelStars)
	{
		super(name, numDays);
		n = name;
		days = numDays;
		s = stops;
		setFuelPrice(fuelCost);
		dist = miles;
		setPersons(maxPersons);
		stars = hotelStars;
		sCount = s.length;
	}
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		if (stars < 1)
		{
			stars = 1;
		}
		else if (stars > 5)
		{
			stars = 5;
		}
		return stars;
	}
	/**
	 * Provides the full price of this RoadTrip object. 
	 * RoadTrip prices are computed based on the total rental car, lodging, and fuel estimated costs.
	 * Specify by getPrice in class VacationPackage
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return getLodgingCost() + getCarCost() + getEstimatedFuelCost();
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object. 
	 * The required deposit for a Road trip includes the full lodging cost plus the full rental car cost.
	 * Specified by getDepositAmount in class VacationPackage
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return getLodgingCost() + getCarCost();
	}
	/**
	 * All RoadTrips must be fully paid in advance, with the exception of fuel costs. 
	 * Fuel costs are paid to the gas station, and not the travel agent. 
	 * Thus, the balance due on RoadTrips is always 0.
	 * Overrides getAmountDue in class VacationPackage
	 * @return The remaining balance to pay the travel agency.
	 */
	@Override
	public double getAmountDue()
	{
		return 0;
	}
	/**
	 * Provides the total lodging cost for a RoadTrip object. 
	 * Lodging is computed based on the length of the vacation, 
	 * the quality of the hotel (in stars),
	 * the number of rooms needed for the party and a base charge of $35.20 per room per night. 
	 * Lodging costs assume a maximum 2 person occupancy per room.
	 * For example, a 5 day road trip for 4 people in 2 star hotels is costed as:
	 *  $35.20 base x 2 star hotels x 4 nights x 2 rooms per night --> $563.20
	 * Specified by getLodgingCost in class VacationPackage
	 * @return - Cost of Lodging / Hotel room.
	 */
	public double getLodgingCost()
	{
		if (getNumPersons() % 2 == 1)
		{
			return BASE * getHotelStars() * (days - 1) * (getNumPersons() + 1) / 2;
		}
		else
		{
			return BASE * getHotelStars() * (days - 1) * (getNumPersons() / 2);
		}
	}
	
	/**
	 * Provides the total cost for the rental car based on the trip duration and the size of car needed. 
	 * Rental cars are billed based on full days, with no partial day rentals allowed. 
	 * Further, the travel agency uses a standard daily
	 * rental car charge based on the number of occupants riding along:
	 * $ 36.75   1-2 passengers
	 * $ 50.13   3-4 passengers
	 * $ 60.25   5-6 passengers
	 * $ 70.50   7-8 passengers
	 * $150.00    9+ passengers (since you'll need a bus)
	 * @return - The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		int people = getNumPersons();
		double price = 0;
		if (people == 1 || people == 2)
		{
			price = COUPE; //36.75
		}
		else if (people == 3 || people == 4)
		{
			price = SEDAN; //50.13
		}
		else if (people == 5 || people == 6)
		{
			price = CROSSOVER; //60.25
		}
		else if (people == 7 || people == 8)
		{
			price = SUV; //70.50
		}
		else if (people >= 9)
		{
			price = BUS; //150
		}
		
		return price * days;
	}
	
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		return sCount;
	}
	
	/**
	 * Updates the number of people to be used for budgeting this RoadTrip within the travel agency.
	 * @param maxPeople - New number of people in calculations.
	 */
	public void setPersons(int maxPeople)
	{
		persons = maxPeople;
		if (persons <= 0)
		{
			persons = 1;
		}
	}
	
	/**
	 * Retrieves the number of people included for budget calculations by this RoadTrip.
	 * @return - Number of persons.
	 */
	public int getNumPersons()
	{
		return persons;
	}
	
	/**
	 * Updates the cost of fuel in US dollars per gallon.
	 * This value is used for projecting out costs for this RoadTrip.
	 * Prices must be positive values,
	 * and a default assumption of $2.50 per gallon will be used if an invalid price is specified.
	 * @param pricePerGallon - New price for gas.
	 */
	public void setFuelPrice(double pricePerGallon)
	{
		if (pricePerGallon > 0)
		{
			gasPrice = pricePerGallon;
		}
		else
		{
			gasPrice = STANDARD_GAS;
		}
	}
	
	/**
	 * Retrieves the current fuel price used for cost projections.
	 * @return Fuel price.
	 */
	public double getFuelPrice()
	{
		return gasPrice;
	}
	
	/**
	 * Provides a projection of the total fuel cost for this trip based on the total number of miles to be traveled,
	 * the fuel efficiency of the rental car, and the cost of fuel.
	 * Standard rental cars used have decreasing fuel efficiency as the size gets bigger.
	 * Thus, efficiency is a function of passenger count.
	 * We assume the following projections:
	 * 45mpg   1-2 passengers
	 * 32mpg   3-4 passengers
	 * 28mpg   5-6 passengers
	 * 22mpg   7-8 passengers
	 * 15mpg    9+ passengers (buses aren't very efficient)
	 * @return - Projected fuel cost.
	 */
	public double getEstimatedFuelCost()
	{
		double mpg = 0;
		int people = getNumPersons();
		if (people == 1 || people == 2)
		{
			mpg = COUPE_MPG; //45
		}
		else if (people == 3 || people == 4)
		{
			mpg = SEDAN_MPG; //32
		}
		else if (people == 5 || people == 6)
		{
			mpg = CROSSOVER_MPG; //28
		}
		else if (people == 7 || people == 8)
		{
			mpg = SUV_MPG; //22
		}
		else
		{
			mpg = BUS_MPG; //15
		}
		return getFuelPrice() * dist / mpg;
	}
	
	/**
	 * Retrieves the list of stops on this RoadTip as
	 * a single string with values separated by a comma and a single space.
	 * The last stop has no punctuation after it.
	 * @return - List of stops.
	 */
	public java.lang.String getStops()
	{
		/**
		 * Array Concatination to String Object.
		 */
		String x = "";
		for (int i = 0; i < s.length - 1; i++)
		{
			x += s[i] + ", ";
		}
		x += s[s.length - 1];
		return x;
	}
	
	/**
	 * Provides a string summary of this RoadTrip.
	 * Promotional details and trip duration are provided as with all VacationPackages,
	 * followed by a summary message about the stops to be made on the
	 * following line with each stop separated by a comma.
	 * The second line should be prefixed with 11 blank spaces for alignment below the trip name.
	 * For example:
	 * $  150.99  Rustic Backpacking at Mt. Rushmore
	 *            A road trip with stops at Carhenge, Chimney Rock, The Corn Palace, Mt. Rushmore.
	 * @return - Formatted String Summary.
	 */
	public java.lang.String toString()
	{
		return "$" + String.format("%8s", df.format(getPrice())) + "  " + n
				+ "\n" + String.format("%11s", " ")
				+ "A road trip with stops at " + getStops();
	}
}
