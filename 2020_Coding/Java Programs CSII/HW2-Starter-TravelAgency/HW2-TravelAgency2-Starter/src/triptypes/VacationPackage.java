// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.
package triptypes;
import java.text.DecimalFormat;
/**
 * This is a class that is the abstract
 * of multiple sub-categories of vacation types.
 * @author mberkland and abdoullatoundji
 *
 */
public abstract class VacationPackage
{
	/**
	 * Rounding Format.
	 */
	private static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Amount of days.
	 */
	private int days;
	/**
	 * Name of trip.
	 */
	private String n;
	
	
	/**
	 * Initializes a VacationPackage with provided values.
	 * @param name - Promotional marketing name.
	 * @param numDays - Number of days on trip.
	 */
	public VacationPackage(java.lang.String name, int numDays)
	{
		setName(name);
		setLength(numDays);
	}
	
	/**
	 * Updates the VacationPackage's externally facing promotional name.
	 * Due to travel agency policy, this name is never allowed to be empty
	 * as it would be confusing for agents and customers interacting with the system.
	 * Names that do not comply with this policy will be ignored
	 * and the package will be given the name "PACKAGE NAME TBD" as a placeholder.
	 * @param name - Updated name for package.
	 */
	public void setName(java.lang.String name)
	{
		n = name;
		if (n == null || n.equals(""))
		{
			n = "PACKAGE NAME TBD";
		}
	}
	
	/**
	 * Updates the length of this VacationPackage.
	 * All packages must have a minimum of one day.
	 * @param numDays - New number of days for vacation.
	 */
	public void setLength(int numDays)
	{
		if (numDays >= 1)
		{
			days = numDays;
		}
		else
		{
			days = 1;
		}
	}
	
	/**
	 * Retrieves the promotional name of this package.
	 * @return - The name.
	 */
	public java.lang.String getName()
	{
		return n;
	}
	
	/**
	 * Retrieves the number of days included in this package.
	 * @return - Number of days for trip.
	 */
	public int getNumDays()
	{
		return days;
	}
	
	/**
	 * This method provides the full price of a vacation package,
	 * which must be computed based on the specific kind of trip being booked.
	 * @return - Total price of vacation.
	 */
	public abstract double getPrice();
	
	/**
	 * This method provides the required upfront deposit amount for a given vacation.
	 * This must be computed based on rules determined by specific package types, per travel agency policies.
	 * @return - The deposit amount required.
	 */
	public abstract double getDepositAmount();
	
	/**
	 * This method provides the remaining amount
	 * due to the travel agent for this trip less any deposit made upfront.
	 * @return - Remaining balance to pay.
	 */
	public double getAmountDue()
	{
		return getLodgingCost() + getPrice() - getDepositAmount();
	}
	
	/**
	 * This method provides the subtotal for a trip related to lodging expenses
	 * (ie, not including flights, meals, and incidentals).
	 * Lodging rates are determined by specific package types.
	 * @return - Lodging subtotal.
	 */
	public abstract double getLodgingCost();
	
	/**
	 * This method produces a String summary of a VacationPackage.
	 * Strings will be prefixed with the $ symbol,
	 * followed by trip total price rounded to two decimal places in a 8 character wide field.
	 * Price details should be followed by two spaces and the promotional name of this trip. For example:
	 * $ 1234.56  Spring Break at the Beach
	 * $  150.99  Rustic Backpacking at Mt. Rushmore
	 */
	@Override
	public java.lang.String toString()
	{
		return "$ " + df.format(getPrice()) + "  " + getName();
	}
	
	/**
	 * Provides a logical equality comparison for VacationPackages and any other object type.
	 * @param other - Reference to another object, compared to this one.
	 * @return true iff this VacationPackage shares the same promotional name as one referred to by other.
	 * false when other is not a valid VacationPackage object or the names do not match.
	 */
	@Override
	public boolean equals(java.lang.Object other)
	{
		boolean ret = false;
		if (other instanceof VacationPackage)
		{
			VacationPackage vaca = (VacationPackage) other;
			ret = this.getName() == vaca.getName();
		}
		return ret;
	}
}
