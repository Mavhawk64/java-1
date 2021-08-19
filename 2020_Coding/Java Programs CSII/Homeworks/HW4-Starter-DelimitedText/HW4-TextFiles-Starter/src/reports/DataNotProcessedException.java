// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance was used in the creation of this java program.

package reports;

/**
 * An Exception to be thrown if it is attempted to write a report that has not been processed.
 * The "serialVersionUID" warning can be suppressed.
 * @author mberkland and abdoullatoundji
 *
 */
@SuppressWarnings("serial")
public class DataNotProcessedException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Data not processed, cannot write report".
	 */
	public DataNotProcessedException()
	{
		super("Data not processed, cannot write report");
	}

}
