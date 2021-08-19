// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import triptypes.CabinType;
import triptypes.Cruise;
import java.util.Calendar;

/**
 * This tests Class: Cruise.
 * @author mberkland and abdoullatoundji
 *
 */
public class CruiseTest
{
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void testTOSTRING()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		
		//TEST
		assertEquals(cruise.toString(), "$   50.00  Maverick (Flight Not Included)\n" + String.format("%11s", " ") + "Cruising from Omaha on the S. S. Minnow");
		
			
	}
	
	@Test
	public void testCabinTypes()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.BALCONY);
		assertEquals(cruise.getCabinType(), CabinType.BALCONY);
		cruise.setCabinType(CabinType.INTERIOR);
		assertEquals(cruise.getCabinType(), CabinType.INTERIOR);
		cruise.setCabinType(CabinType.OCEAN_VIEW);
		assertEquals(cruise.getCabinType(), CabinType.OCEAN_VIEW);
		cruise.setCabinType(CabinType.SUITE);
		assertEquals(cruise.getCabinType(), CabinType.SUITE);
	}
	
	@Test
	public void testAddExcursion()
	{
		//Setup prior state
				Calendar departs = Calendar.getInstance();
				departs.set(2020, 3, 12, 6, 30);
				Calendar returns = Calendar.getInstance();
				departs.set(2020, 3, 22, 6, 30);
				Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
				
		cruise.addExcursion(" ", 25.43);
		cruise.addExcursion("",  0);
		cruise.addExcursion(null, 45);
		assertEquals(0, cruise.getNumExcursions());
		for (int i = 0; i < 20; i++)
		{
			cruise.addExcursion("Valid " + i, 10+i);
		}
		for (int i = 0; i < 10; i++)
		{
			assertEquals(cruise.getExcursions()[i], "Valid " + i);
		}
		assertEquals(cruise.getNumExcursions(), 10);
	}
	
	@Test
	public void testConstructorValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		assertEquals("Maverick", cruise.getName());
		assertEquals(10, cruise.getNumDays());
		assertEquals("S. S. Minnow", cruise.getVesselName());
		assertEquals("Omaha", cruise.getHomePort());
		assertEquals(departs, cruise.getDepartureDate());
		assertEquals(returns, cruise.getReturnDate());
	}

	@Test
	public void testAddExcursionValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//Call method being tested
		cruise.addExcursion("Shuffle board", 25.00);
		
		//Post State
		assertEquals(1, cruise.getNumExcursions());
		assertEquals("Shuffle board", cruise.getExcursions()[0]);
		assertEquals(25.00, cruise.getExcursionCosts(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testAddExcursionInValidNull()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//Call method being tested
		cruise.addExcursion(null, 25.00);
		
		//Post State
		assertEquals(0, cruise.getNumExcursions());
		assertEquals(null, cruise.getExcursions()[0]);
		assertEquals(0.00, cruise.getExcursionCosts(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testAddExcursionInValidEmpty()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//Call method being tested
		cruise.addExcursion("", 25.00);
		
		//Post State
		assertEquals(0, cruise.getNumExcursions());
		assertEquals(null, cruise.getExcursions()[0]);
		assertEquals(0.00, cruise.getExcursionCosts(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testAddExcursionInValidNegative()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//Call method being tested
		cruise.addExcursion("Shuffle board", -25.00);
		
		//Post State
		assertEquals(1, cruise.getNumExcursions());
		assertEquals("Shuffle board", cruise.getExcursions()[0]);
		assertEquals(0.00, cruise.getExcursionCosts(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testSetCabinTypeValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//Call method being tested
		cruise.setCabinType(CabinType.INTERIOR);
		
		//Post State
		assertEquals(CabinType.INTERIOR, cruise.getCabinType());
	}
	
	@Test
	public void testSetCabinTypeInValidNull()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//Call method being tested
		cruise.setCabinType(null);
		
		//System.out.println(cruise.getCabinType());
		//Post State
		assertEquals(CabinType.INTERIOR, cruise.getCabinType());
	}
	
	@Test
	public void testGetLodgingCostInteriorValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.INTERIOR);
		
		//Call method and verify the return value
		assertEquals(50.00, cruise.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetLodgingCostOceanViewValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.OCEAN_VIEW);
		
		//Call method and verify the return value
		assertEquals(75.00, cruise.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetLodgingCostBalconyValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.BALCONY);
		
		//Call method and verify the return value
		assertEquals(150.00, cruise.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetLodgingCostSuiteValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.SUITE);
		
		//Call method and verify the return value
		assertEquals(250.00, cruise.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetDepositAmountValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.INTERIOR);
		
		//Call method and verify the return value
		assertEquals(25.00, cruise.getDepositAmount(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetPriceValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.INTERIOR);
		cruise.addExcursion("Shuffle board", 25.00);
		
		//Call method and verify the return value
		assertEquals(75.00, cruise.getPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToStringNoExcValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.INTERIOR);
//		System.out.println("$   50.00  Maverick (Flight Not Included)\n" + String.format("%11s", " ") + "Cruising from Omaha on the S. S. Minnow");
//		System.out.println(cruise.toString());
		//Call method and verify the return value
		assertEquals("$   50.00  Maverick (Flight Not Included)\n" + String.format("%11s", " ") + "Cruising from Omaha on the S. S. Minnow", cruise.toString());
	}
	
	@Test
	public void testToStringWithExcValid()
	{
		//Setup prior state
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		cruise.setCabinType(CabinType.INTERIOR);
		cruise.addExcursion("Shuffle board", 25.00);
		
		System.out.println("$   75.00  Maverick (Flight Not Included)\n" + String.format("%11s", " ") + "Cruising from Omaha on the S. S. Minnow (includes 1 excursions)");
		System.out.println(cruise.toString());
		//Call method and verify the return value
		assertEquals("$   75.00  Maverick (Flight Not Included)\n" + String.format("%11s", " ") + "Cruising from Omaha on the S. S. Minnow (includes 1 excursions)", cruise.toString());
	}
}	