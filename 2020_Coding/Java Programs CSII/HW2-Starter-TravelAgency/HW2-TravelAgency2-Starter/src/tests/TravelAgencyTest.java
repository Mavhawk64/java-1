// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: I used no external resources in creating this class.

package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import travelgui.VacationPackageCollection;
import org.junit.Test;
import triptypes.*;


/**
 * This tests Class: VacationPackageCollection.
 * @author mberkland and abdoullatoundji
 *
 */
public class TravelAgencyTest
{
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void testFilter()
	{
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		RoadTrip trip = new RoadTrip("Maverick", 6, stops, 2.50, 10, 4, 3);
		AllInclusiveResort trip2 = new AllInclusiveResort("Resort", 5, "Club Med", 4, 105.50, stops);
		
		collection.addVacation(trip);
		collection.addVacation(trip2);
		collection.addVacation(null);
		assertEquals(collection.filterVacationsFor(1).getAllVacations()[0].toString(), trip.toString());
		assertNull(collection.filterVacationsFor(2).getAllVacations());
		}
	
	@Test
	public void testGetItemAt()
	{
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		RoadTrip trip = new RoadTrip("Maverick", 6, stops, 2.50, 10, 4, 3);
		AllInclusiveResort trip2 = new AllInclusiveResort("Resort", 5, "Club Med", 4, 105.50, stops);
		
		assertNull(collection.getItemAt(-10000000));
		assertNull(collection.getItemAt(10000000));
	}
	
	
	@Test
	public void testAddVacationRoadTripValid() 
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		RoadTrip trip = new RoadTrip("Maverick", 6, stops, 2.50, 10, 4, 3);
		
		//call method
		collection.addVacation(trip);
		
		//test post state
		assertEquals(1, collection.getNumTrips());
		assertEquals(trip.getName(), collection.getItemAt(0).getName());
	}
	
	@Test
	public void testAddVacationCruiseValid() 
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		
		//call method
		collection.addVacation(cruise);
		
		//test post state
		assertEquals(1, collection.getNumTrips());
		assertEquals(cruise.getName(), collection.getItemAt(0).getName());
	}
	@Test
	public void testNoTrips()
	{
		VacationPackageCollection collection = new VacationPackageCollection();
		assertNull(collection.getAllVacations());
	}
	@Test
	public void testAddVacationAllInclusiveValid() 
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] amenities = new String[] {"Free MacBook Pro", "Lifetime Supply of Toilet Paper", "$1,000,000"};
		AllInclusiveResort resort = new AllInclusiveResort("Maverick", 10, "UA", 2, 50.00, amenities);
		
		//call method
		collection.addVacation(resort);
		
		//test post state
		assertEquals(1, collection.getNumTrips());
		assertEquals(resort.getName(), collection.getItemAt(0).getName());
	}
	
	@Test
	public void testAddVacationInValidTooMany()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		
		for (int i = 0; i < 25; i++)
		{
			collection.addVacation(new RoadTrip("Maverick " + (i + 1), 6, stops, 2.50, 10, 4, 3));
		}
		
		//call method and verify post state
		collection.addVacation(new RoadTrip("Maverick 26", 6, stops, 2.50, 10, 4, 3));
		
	}
	
	
	@Test
	public void testAddVacationInValidAlreadyIn()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		RoadTrip trip = new RoadTrip("Maverick", 6, stops, 2.50, 10, 4, 3);
		collection.addVacation(trip);
		
		//call method
		collection.addVacation(trip);
		
		//test post case
		assertEquals(trip.getName(), collection.getItemAt(0).getName());
		assertEquals(null, collection.getItemAt(26));
	}

	@Test
	public void testFilterVacationsForRoadTripValid()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		VacationPackageCollection test = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		String[] amenities = new String[] {"Free MacBook Pro", "Lifetime Supply of Toilet Paper", "$1,000,000"};
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		
		for (int i = 0; i < 25; i++)
		{
			if (i < 10)
			{
				collection.addVacation(new RoadTrip("Maverick " + (i + 1), 6, stops, 2.50, 10, 4, 3));
				test.addVacation(new RoadTrip("Maverick " + (i + 1), 6, stops, 2.50, 10, 4, 3));
			}
			else if (i < 15)
			{
				collection.addVacation(new Cruise("Maverick " + (i + 1), 10, "S. S. Minnow", "Omaha", departs, returns, 50.00));
			}
			else
			{
				collection.addVacation(new AllInclusiveResort("Maverick " + (i + 1), 10, "UA", 2, 50.00, amenities));
			}
		}
		
		//call method
		VacationPackageCollection output = collection.filterVacationsFor(1);
		
		//verify post state
		assertEquals(test.getNumTrips(), output.getNumTrips());
		for(int a = 0; a < test.getNumTrips(); a++)
		{
			//System.out.println(test.getItemAt(a).getName() + " vs " + output.getItemAt(a).getName());
			
			assertEquals(test.getItemAt(a).getName(), output.getItemAt(a).getName());
		}
		
	}

	@Test
	public void testFilterVacationsForCruiseValid()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		VacationPackageCollection test = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		String[] amenities = new String[] {"Free MacBook Pro", "Lifetime Supply of Toilet Paper", "$1,000,000"};
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		
		for (int i = 0; i < 25; i++)
		{
			if (i < 10)
			{
				collection.addVacation(new RoadTrip("Maverick " + (i + 1), 6, stops, 2.50, 10, 4, 3));
			}
			else if (i < 15)
			{
				collection.addVacation(new Cruise("Maverick " + (i + 1), 10, "S. S. Minnow", "Omaha", departs, returns, 50.00));
				test.addVacation(new Cruise("Maverick " + (i + 1), 10, "S. S. Minnow", "Omaha", departs, returns, 50.00));
			}
			else
			{
				collection.addVacation(new AllInclusiveResort("Maverick " + (i + 1), 10, "UA", 2, 50.00, amenities));
			}
		}
		
		//call method
		VacationPackageCollection output = collection.filterVacationsFor(2);
		
		//verify post state
		assertEquals(test.getNumTrips(), output.getNumTrips());
		for(int a = 0; a < test.getNumTrips(); a++)
		{
			assertEquals(test.getItemAt(a).getName(), output.getItemAt(a).getName());
		}
		
	}
	
	@Test
	public void testFilterVacationsForResortValid()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		VacationPackageCollection test = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		String[] amenities = new String[] {"Free MacBook Pro", "Lifetime Supply of Toilet Paper", "$1,000,000"};
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		
		for (int i = 0; i < 25; i++)
		{
			if (i < 10)
			{
				collection.addVacation(new RoadTrip("Maverick " + (i + 1), 6, stops, 2.50, 10, 4, 3));
			}
			else if (i < 15)
			{
				collection.addVacation(new Cruise("Maverick " + (i + 1), 10, "S. S. Minnow", "Omaha", departs, returns, 50.00));
			}
			else
			{
				collection.addVacation(new AllInclusiveResort("Maverick " + (i + 1), 10, "UA", 2, 50.00, amenities));
				test.addVacation(new AllInclusiveResort("Maverick " + (i + 1), 10, "UA", 2, 50.00, amenities));
			}
		}
		
		//call method
		VacationPackageCollection output = collection.filterVacationsFor(3);
		
		//verify post state
		assertEquals(test.getNumTrips(), output.getNumTrips());
		for(int a = 0; a < test.getNumTrips(); a++)
		{
			assertEquals(test.getItemAt(a).getName(), output.getItemAt(a).getName());
		}
		
	}
	
	@Test
	public void testGetFlightDetailsValid()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		returns.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		Flight details = new Flight("AA", 123, "OMA", "MCO", departs, returns, 100.00);
		Flight details2 = new Flight("AA", 124, "MCO", "OMA", departs, returns, 100.00);
		cruise.addFlightLeg(details);
		cruise.addFlightLeg(details2);
		collection.addVacation(cruise);
		//call method and verify post state
		System.out.println(collection.getFlightDetails(0));
		String test = collection.getFlightDetails(0);
		System.out.println(test + " vs " + "AA 123 Departs: OMA at 06:30 04-12-2020; Arrives MCO at 06:30 04-22-2020" +
				"\nAA 124 Departs: MCO at 06:30 04-12-2020; Arrives OMA at 06:30 04-22-2020");
		assertEquals("AA 123 Departs: OMA at 06:30 04-12-2020; Arrives MCO at 06:30 04-22-2020" +
				"\nAA 124 Departs: MCO at 06:30 04-12-2020; Arrives OMA at 06:30 04-22-2020", test);
		
		
	}
	
	
	@Test
	public void testGetFlightDetailsInValidOutOfRange()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		
		//call method and verify output
		assertEquals("ERROR: Index is out of range!",collection.getFlightDetails(-5));
		assertEquals("ERROR: Index is out of range!",collection.getFlightDetails(27));
	}
	
	@Test
	public void testGetFlightDetailsInValidNoFlightsForType()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		collection.addVacation(new RoadTrip("Maverick", 6, stops, 2.50, 10, 4, 3));
		
		//call method and verify output
		assertEquals("ERROR: No flights are allowed for this type of trip!",collection.getFlightDetails(0));
	}
	
	@Test
	public void testGetFlightDetailsInValidNoDetails()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		returns.set(2020, 3, 22, 6, 30);
		Cruise cruise = new Cruise("Maverick", 10, "S. S. Minnow", "Omaha", departs, returns, 50.00);
		collection.addVacation(cruise);
		
		//call method and verify post state
		String test = collection.getFlightDetails(0);
		assertEquals("ERROR: The selected trip has no flight information.",test);
		cruise.addFlightLeg(null);
		assertEquals("ERROR: The selected trip has no flight information.",test);
	}
	
	@Test
	public void testSortCollectionInvalid()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		
		//call method and verify post state
		collection.sortCollection(true);
		for (int i = 0; i < 25; i ++)
		{
			assertEquals(null, collection.getItemAt(i));
		}
		
		
	}
	
	@Test
	public void testSortCollectionByPrice()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		String[] amenities = new String[] {"Free MacBook Pro", "Lifetime Supply of Toilet Paper", "$1,000,000"};
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		
		for (int i = 0; i < 25; i++)
		{
			if (i < 10)
			{
				collection.addVacation(new RoadTrip("Maverick " + (i + 1), 6 + i, stops, 2.50, 10, 4, 3));
			}
			else if (i < 15)
			{
				collection.addVacation(new Cruise("Maverick " + (i + 1), 10, "S. S. Minnow", "Omaha", departs, returns, 50.00 + i));
			}
			else
			{
				collection.addVacation(new AllInclusiveResort("Maverick " + (i + 1), 10, "UA", 2, 50.00 - i, amenities));
			}
		}
		
		//call method and verify post state
		collection.sortCollection(true);
		int sorted = 0;
		//System.out.println(collection.getNumTrips());
		//System.out.println("$" + collection.getItemAt(0).getPrice());
		for (int a = 0; a < collection.getNumTrips() - 1; a++)
		{
			assertNotNull(collection.getItemAt(a));
			assertNotNull(collection.getItemAt(a + 1));
			//System.out.println("$" + collection.getItemAt(a).getPrice());
			if (collection.getItemAt(a).getPrice() <= collection.getItemAt(a + 1).getPrice())
			{
				sorted++;
				//System.out.println(sorted);
			}
		}
		assertEquals(24, sorted);
	}
	
	@Test
	public void testSortCollectionName()
	{
		//setup prior state
		VacationPackageCollection collection = new VacationPackageCollection();
		String[] stops = new String[]{"McDonalds", "Nowhere", "UNO", "Omaha"};
		String[] amenities = new String[] {"Free MacBook Pro", "Lifetime Supply of Toilet Paper", "$1,000,000"};
		Calendar departs = Calendar.getInstance();
		departs.set(2020, 3, 12, 6, 30);
		Calendar returns = Calendar.getInstance();
		departs.set(2020, 3, 22, 6, 30);
		
		for (int i = 0; i < 25; i++)
		{
			if (i < 10)
			{
				collection.addVacation(new RoadTrip("Maverick" + (i + 1), 6 + i, stops, 2.50, 10, 4, 3));
			}
			else if (i < 15)
			{
				collection.addVacation(new Cruise("Maverick" + (i + 1), 10, "S. S. Minnow", "Omaha", departs, returns, 50.00 + i));
			}
			else
			{
				collection.addVacation(new AllInclusiveResort("Maverick" + (i + 1), 10, "UA", 2, 50.00 - i, amenities));
			}
		}
		
		//call method and verify post state
		collection.sortCollection(false);
		VacationPackage[] test = collection.getAllVacations();
		for (int a = 0; a < collection.getNumTrips(); a++)
		{
			assertEquals(test[a].getName(), collection.getItemAt(a).getName());
		}
	}
}