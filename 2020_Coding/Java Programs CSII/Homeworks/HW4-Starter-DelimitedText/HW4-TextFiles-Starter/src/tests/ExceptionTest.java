// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance was used in the creation of this java program.
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import reports.DataNotProcessedException;
import reports.YearNotFoundException;

public class ExceptionTest
{
	@Test
	public void messageTest()
	{
		Exception ynf = new YearNotFoundException();
		Exception dnp = new DataNotProcessedException();
		assertEquals("YearNotFoundException constructor is wrong", 
				"Requested year not in file", ynf.getMessage());
		assertEquals("DataNotProcessedException constructor is wrong", 
				"Data not processed, cannot write report", dnp.getMessage());
	}
}
