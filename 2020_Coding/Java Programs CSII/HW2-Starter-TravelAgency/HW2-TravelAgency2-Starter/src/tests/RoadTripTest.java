// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import triptypes.*;

/**
 * This tests Class: RoadTrip.
 * @author mberkland and abdoullatoundji
 *
 */
public class RoadTripTest
{
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void testGetAmountDue()
	{
		String[] stops = new String[] {"Here", "There"};
		RoadTrip x = new RoadTrip("On the road again", 2, stops, 2.50, 10, 4, 3);
//		System.out.println(x.getAmountDue());
		assertEquals(x.getAmountDue(), 0, DOUBLE_TOLERANCE);
//		System.out.println(x.getPrice());
	}
	
	@Test
	public void testGetCarCost()
	{
		String[] stops = new String[] {"Here", "There"};
		RoadTrip[] x = new RoadTrip[20];
		double[] prices = {36.75,50.13,60.25,70.50,150};
		
		for (int i = 0; i < x.length; i++)
		{
			x[i] = new RoadTrip("On the road again", 2, stops, 2.50, 10, i, 3);
		}
		int j = 0;
		for (int i = 0; i < x.length; i++)
		{
			assertEquals(x[i].getCarCost(), 2*prices[j], DOUBLE_TOLERANCE);
			if (i > 0 && i%2 == 0 && i < 10)
				j++;
		}
	}
	
	@Test
	public void testEstimatedFuelCost()
	{
		String[] stops = new String[] {"Here", "There"};
		RoadTrip[] x = new RoadTrip[20];
		int[] mpg = {45,32,28,22,15};
		
		for (int i = 0; i < x.length; i++)
		{
			x[i] = new RoadTrip("On the road again", 2, stops, 2.50, 10, i, 3);
		}
		int j = 0;
		for (int i = 0; i < x.length; i++)
		{
			assertEquals(x[i].getEstimatedFuelCost(), 2.50*10/mpg[j], DOUBLE_TOLERANCE);
			if (i > 0 && i%2 == 0 && i < 10)
				j++;
		}
	}
	
	@Test
	public void testConstructor()
	{
		//Call method being tested
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 10, 4, 3);
		RoadTrip trip2 = new RoadTrip("Test", 6, stops, 2.50, 10, 4, -1);
		RoadTrip trip3 = new RoadTrip("Test", 6, stops, 2.50, 10, 4, 10);
		
		//Verify post-state of the object
		assertEquals("Test", trip.getName());
		assertEquals(6, trip.getNumDays());
		assertEquals("alien, Computer, Maverick's House, Abdoul's House", trip.getStops());
		assertEquals(4, trip.getNumStops());
		assertEquals(2.50, trip.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(4, trip.getNumPersons());
		assertEquals(3, trip.getHotelStars());
		assertEquals(1, trip2.getHotelStars());
		assertEquals(5, trip3.getHotelStars());
	}
	
	@Test
	public void testSetNameInValid()
	{
		//Call method being tested
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 10, 4, 3);
		
		//Call method and verify post state
		trip.setName("");
		assertEquals("PACKAGE NAME TBD", trip.getName());
		trip.setName(null);
		assertEquals("PACKAGE NAME TBD", trip.getName());
	}
	
	@Test
	public void testSetLengthInValid()
	{
		//Call method being tested
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 10, 4, 3);
		
		//Call method and verify post state
		trip.setLength(0);
		assertEquals(1, trip.getNumDays());
	}
	
	@Test
	public void testEqualsValid()
	{
		//Call method being tested
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 10, 4, 3);
		RoadTrip trip2 = new RoadTrip("Bob", 6, stops, 2.50, 10, 4, 3);
		Calendar depart = Calendar.getInstance();
		
		//Call method and verify post state
		assertEquals(false, trip.equals(trip2));
		assertEquals(true, trip.equals(trip));
		assertEquals(false, trip.equals(depart));
	}
	
	@Test
	public void testEqualsInValid()
	{
		//Call method being tested
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 10, 4, 3);
		String[] amenities = new String[] {"Chair", "Bed", "Fan"};
		AllInclusiveResort resort = new AllInclusiveResort("Bob", 10, "UA", 2, 50.00, amenities);
		AllInclusiveResort resort2 = new AllInclusiveResort("Test", 10, "UA", 2, 50.00, amenities);
		
		
		//Call method and verify post state
		assertEquals(false, trip.equals(null));
		assertEquals(false, trip.equals(resort));
		assertEquals(true, trip.equals(resort2));
	}

	@Test
	public void testGetPriceValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify post return value
		assertEquals(1364.5925, trip.getPrice(), DOUBLE_TOLERANCE);
	}

	@Test
	public void testGetDepositAmountValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify return value
		assertEquals(1356.78, trip.getDepositAmount(), DOUBLE_TOLERANCE);
	}

	@Test
	public void testGetAmountDueValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify return value
		System.out.println(trip.getAmountDue());
		assertEquals(0.00, trip.getAmountDue(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetLodgingCostValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		RoadTrip trip2 = new RoadTrip("Test", 1, stops, 2.50, 100, 1, 1);
		
		//Call the method being tested and verify return value
		assertEquals(1056.0, trip.getLodgingCost(), DOUBLE_TOLERANCE);
		trip.setPersons(1);
		assertEquals(528.0, trip.getLodgingCost(), DOUBLE_TOLERANCE);
		trip.setPersons(6);
		assertEquals(1584.0, trip.getLodgingCost(), DOUBLE_TOLERANCE);
		trip.setPersons(8);
		assertEquals(2112.0, trip.getLodgingCost(), DOUBLE_TOLERANCE);
		trip.setPersons(10);
		assertEquals(2640.00, trip.getLodgingCost(), DOUBLE_TOLERANCE);
		assertEquals(0, trip2.getLodgingCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetCarCostValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify return value
		assertEquals(300.78, trip.getCarCost(), DOUBLE_TOLERANCE);
		trip.setPersons(1);
		assertEquals(220.5, trip.getCarCost(), DOUBLE_TOLERANCE);
		trip.setPersons(6);
		assertEquals(361.5, trip.getCarCost(), DOUBLE_TOLERANCE);
		trip.setPersons(8);
		assertEquals(423.00, trip.getCarCost(), DOUBLE_TOLERANCE);
		trip.setPersons(10);
		assertEquals(900, trip.getCarCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetEstimatedFuelCostValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify post return value
		assertEquals(7.8125, trip.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		trip.setPersons(1);
		assertEquals(5.5556, trip.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		trip.setPersons(6);
		assertEquals(8.928, trip.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		trip.setPersons(8);
		assertEquals(11.3636, trip.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		trip.setPersons(10);
		assertEquals(16.6667, trip.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
	}

	@Test
	public void testSetPersonsValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify return value
		trip.setPersons(10);
		assertEquals(10, trip.getNumPersons());
		trip.setPersons(-5);
		assertEquals(1, trip.getNumPersons());
	}
	
	@Test
	public void testSetFuelPriceValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify return value
		trip.setFuelPrice(3.50);
		assertEquals(3.50, trip.getFuelPrice(), DOUBLE_TOLERANCE);
	}
	
	public void testSetFuelPriceInValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
		
		//Call the method being tested and verify return value
		trip.setFuelPrice(-5);
		assertEquals(2.5, trip.getFuelPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToStringValid()
	{
		//Setup prior state of object
		String[] stops = new String[]{"alien", "Computer", "Maverick's House", "Abdoul's House"};
		RoadTrip trip = new RoadTrip("Test", 6, stops, 2.50, 100, 4, 3);
			
		//Call the method being tested and verify return value
		assertEquals("$ 1364.59  Test\n" + String.format("%11s", " ") + "A road trip with stops at alien, Computer, Maverick's House, Abdoul's House", trip.toString());
	}
}