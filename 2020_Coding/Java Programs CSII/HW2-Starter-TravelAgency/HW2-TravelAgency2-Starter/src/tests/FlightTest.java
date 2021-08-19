// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package tests;

import static org.junit.Assert.*;
import triptypes.Flight;
import triptypes.Cruise;
import triptypes.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Test;

/**
 * This tests Class: Flight.
 * @author mberkland and abdoullatoundji
 *
 */
public class FlightTest
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
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		returns.set(2020, 3, 22, 6, 30);
		Flight flight = new Flight("AA", 123, "Omaha", "St. Louis-Lambert", departs, returns, 6969.69);
		
		//Verify post state
		assertEquals(6969.69, flight.getPrice(), DOUBLE_TOLERANCE);
	}

	@Test
	public void testGetFlightCosts()
	{
		String[] am = {"Towels","Soaps","Showers","Pools"};
		AllInclusiveResort x = new AllInclusiveResort("NULL", 10, "Cancun", 4, 20, am);
		assertEquals(x.getFlightCosts(), 0, DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToString()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		returns.set(2020, 3, 22, 6, 30);
		Flight flight = new Flight("AA", 123, "OMA", "STL", departs, returns, 6969.69);
		
//		System.out.println(flight.toString());
//		System.out.println("AA 123 Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020");
		
		//Call method and verify post state
		assertEquals("AA 123 Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020", 
				flight.toString());
	}
	
	@Test
	public void testAddFlightLegInValid()
	{
		//setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		returns.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Vroom", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		Flight details = new Flight("AA", 123, "OMA", "STL", departs, returns, 6969.69);
		
		//call method and verify post state
		cruise.addFlightLeg(null);
		assertNull(null , cruise.getFlightItinerary());
		for (int i = 0; i < 12; i++)
		{
			cruise.addFlightLeg(new Flight("AA", 123 + i, "OMA", "STL", departs, returns, 6969.69));
		}
		cruise.addFlightLeg(details);
	}
	
	@Test
	public void testToStringDigits()
	{
		//Setup prior state
				Calendar departs = Calendar.getInstance();
				departs.set(2020, 3, 12, 6, 30);
				Calendar returns = Calendar.getInstance();
				returns.set(2020, 3, 22, 6, 30);
				Flight flight = new Flight("AA", 1, "OMA", "STL", departs, returns, 6969.69);
				Flight flight2 = new Flight("AA", 12, "OMA", "STL", departs, returns, 6969.69);
				Flight flight3 = new Flight("AA", 123, "OMA", "STL", departs, returns, 6969.69);
				Flight flight4 = new Flight("AA", 1234, "OMA", "STL", departs, returns, 6969.69);
				
				//Call method and verify post state
//				System.out.println(flight.toString());
//				System.out.println("AA" + String.format("%4d", 1) +" Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020");
				assertEquals("AA" + String.format("%4d", 1) +" Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020", 
						flight.toString());
				assertEquals("AA" + String.format("%4d", 12) +" Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020", 
						flight2.toString());
				assertEquals("AA" + String.format("%4d", 123) +" Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020", 
						flight3.toString());
				assertEquals("AA" + String.format("%4d", 1234) +" Departs: OMA at 06:30 04-12-2020; Arrives STL at 06:30 04-22-2020", 
						flight4.toString());
	}
}