
package tests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import reports.DataNotProcessedException;
import reports.YearNotFoundException;
import reports.YearReport;

public class YearReportTest {


	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void unprocessedToStringTest()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		String expected = "Fortune 500 Report for 2020\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: nul StD: nul";
		
		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, y.toString());
	}
	@Test
	public void fullThroughTest()
	{
		File file = new File("temp_fullThroughTest.tmp");
		file.delete();
		file.deleteOnExit();
		YearReport y = new YearReport(new File("fortune500.csv"), 1969);
		y.processReport();
		String expected = "Fortune 500 Report for 1969\n" + 
				"Revenue\n" + 
				"Min: 143.700 Max: 22755.400 Avg: 810.546 StD: 1612.262\n" + 
				"Profit\n" + 
				"Min: -77.100 Max: 1731.900 Avg: 48.387 StD: 126.513";
		
		assertEquals("Problem in toString or processReport",
				expected, y.toString());
		assertTrue(y.writeReport(file));
		try
		{
			Scanner filescanner = new Scanner(new FileInputStream(file));
			String written = "";
			while(filescanner.hasNextLine())
			{
				written+=filescanner.nextLine()+"\n";
			}
			
			filescanner.close();
			assertEquals("Write method bad", expected+"\n", written);
		}
		catch(FileNotFoundException e)
		{
			assertTrue("File wasn't written", false);
		}
		assertFalse(y.writeReport(file));
		file.delete();
	}
	@Test
	public void getYearTest()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 1956);
		YearReport y2 = new YearReport(new File("fortune500.csv"), 1964);
		YearReport y3 = new YearReport(new File("fortune500.csv"), 1976);
		YearReport y4 = new YearReport(new File("fortune500.csv"), 1967);
		
		assertEquals(1956, y.getYear());
		assertEquals(1964, y2.getYear());
		assertEquals(1976, y3.getYear());
		assertEquals(1967, y4.getYear());
	}
	/*@Test
	public void dataNotProcessed()
	{
		File file = new File("temp_fullThroughTest.tmp");
		file.delete();
		file.deleteOnExit();
		YearReport y = new YearReport(new File("fortune500.csv"), 1969);
		thrown.expect(DataNotProcessedException.class);
		y.writeReport(file);
	}
	@Test
	public void badFilePath()
	{
		File file = new File("/foo/bar/baz/temp_fullThroughTest.tmp");
		file.delete();
		file.deleteOnExit();
		YearReport y = new YearReport(file, 1969);
		assertFalse(y.processReport());
		y = new YearReport(new File("fortune500.csv"), 1969);
		y.processReport();
		assertFalse(y.writeReport(file));
	}
	@Test
	public void badYear()
	{
		File file = new File("/foo/bar/baz/temp_fullThroughTest.tmp");
		file.delete();
		file.deleteOnExit();
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		thrown.expect(YearNotFoundException.class);
		y.processReport();
	}
	*/
}

