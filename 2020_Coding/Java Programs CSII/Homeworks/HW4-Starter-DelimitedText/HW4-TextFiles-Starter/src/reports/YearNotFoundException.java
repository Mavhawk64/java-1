// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance was used in the creation of this java program.

package reports;

/**
 * An Exception to be thrown if a requested year is not present in the data set.
 * The "serialVersionUID" warning can be suppressed.
 * @author mbberkland and abdoullatoundji
 *
 */
@SuppressWarnings("serial")
public class YearNotFoundException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Requested year not in file".
	 */
	public YearNotFoundException()
	{
		super("Requested year not in file");
	}
}
