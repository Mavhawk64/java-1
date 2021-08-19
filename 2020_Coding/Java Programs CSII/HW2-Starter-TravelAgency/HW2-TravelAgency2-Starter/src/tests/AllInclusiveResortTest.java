// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package tests;

import static org.junit.Assert.*;
import java.util.Calendar;
import org.junit.Test;
import triptypes.AllInclusiveResort;
import triptypes.Flight;

/**
 * This tests Class: AllInclusiveResort.
 * @author mberkland and abdoullatoundji
 *
 */
public class AllInclusiveResortTest
{
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void testConstructorValid()
	{
		//Setup prior state
		String[] amenities = new String[] {"Towels", "Soap", "Fiji Water"};
		AllInclusiveResort resort = new AllInclusiveResort("Apples", 10, "China Buffet", 2, 50.00, amenities);
		
		//Verify post state
		assertEquals("Apples", resort.getName());
		assertEquals(10, resort.getNumDays());
		assertEquals(2, resort.getGuestsPerRoom());
		assertEquals("Towels, Soap, Fiji Water", resort.getAmenities());
	}
	
	@Test
	public void testGetLodgingCostValid()
	{
		//Setup prior state
		String[] amenities = new String[] {"Towels", "Soap", "Fiji Water"};
		AllInclusiveResort resort = new AllInclusiveResort("Apples", 10, "China Buffet", 2, 50.00, amenities);
		
		//Call Method and verify the return value
		assertEquals(450.00, resort.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetDepositAmountValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		String[] amenities = new String[] {"Towels", "Soap", "Fiji Water"};
		AllInclusiveResort resort = new AllInclusiveResort("Apples", 10, "China Buffet", 2, 50.00, amenities);
		Flight flight = new Flight("AA", 134, "Omaha", "China Buffet", departs, returns, 100.00);
		resort.addFlightLeg(flight);
		
		//Call Method and verify the return value
		assertEquals(325.00, resort.getDepositAmount(), DOUBLE_TOLERANCE);
	}

	@Test
	public void testGetPriceValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		String[] amenities = new String[] {"Towels", "Soap", "Fiji Water"};
		AllInclusiveResort resort = new AllInclusiveResort("Apples", 10, "China Buffet", 2, 50.00, amenities);
		Flight flight = new Flight("AA", 134, "Omaha", "China Buffet", departs, returns, 100.00);
		resort.addFlightLeg(flight);
		
		//Call method and verify the return value
		assertEquals(550.00, resort.getPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToStringValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		String[] amenities = new String[] {"Towels", "Soap", "Fiji Water"};
		AllInclusiveResort resort = new AllInclusiveResort("Apples", 10, "China Buffet", 2, 50.00, amenities);
		Flight flight = new Flight("AA", 134, "Omaha", "China Buffet", departs, returns, 100.00);
		resort.addFlightLeg(flight);
		
//		System.out.println(resort.toString());
//		System.out.println("$  550.00  Apples (Flight Included)" + "\r\n           An all-inclusive stay at China Buffet for 2 people!");
		//Call method and verify the return value
		assertEquals("$  550.00  Apples! (Flight Included)" + "\r\n           An all-inclusive stay at China Buffet for 2 people!", resort.toString());
	}
}