// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance was used in the creation of this java program.
package tests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import reports.CompanyReport;
import reports.DataNotProcessedException;

public class CompanyReportTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	//selected test companies
	@Test
	public void unprocessedToStringTest()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		String expected = "Fortune 500 Report for Nike ranked 0 times\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Rank\n" + 
				"Min: null Max: null Avg: nul StD: nul";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());
	}
	@Test
	public void fakeCompanyTest()
	{
		File file;
		try
		{
			file = File.createTempFile("fakeCompany", null);
		} catch (IOException e1)
		{
			file = new File("fakeCompany.tmp");
			//e1.printStackTrace();
		}
		file.deleteOnExit();
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		c.processReport();
		String expected = "Fortune 500 Report for Nike ranked 0 times\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: NaN StD: NaN\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: NaN StD: NaN\n" + 
				"Rank\n" + 
				"Min: null Max: null Avg: NaN StD: NaN";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());
		assertTrue(c.writeReport(file));
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
	}
	@Test
	public void badFileInIsBad()
	{
		CompanyReport c = new CompanyReport(new File("nonexistant.csv"), "Nike");
		assertFalse(c.processReport());
	}
	@Test
	public void exceptionOnWriteBeforeProcessed() throws DataNotProcessedException
	{
		File file = new File("temp_exceptionOnWriteBeforeProcessed.tmp");
		file.delete();
		file.deleteOnExit();
		CompanyReport c = new CompanyReport(new File("nonexistant.csv"), "Nike");
		thrown.expect(DataNotProcessedException.class);
		c.writeReport(file);
	}
	@Test
	public void getCompanyTest()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "asf");
		CompanyReport d = new CompanyReport(new File("fortune500.csv"), "ywer");
		CompanyReport e = new CompanyReport(new File("fortune500.csv"), "SDG E gfewsf");
		
		assertEquals("asf".intern(), c.getCompany().intern());
		assertEquals("ywer".intern(), d.getCompany().intern());
		assertEquals("SDG E gfewsf".intern(), e.getCompany().intern());
	}
	@Test
	public void goodFileInIsGood()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		assertTrue(c.processReport());
		String expected = "Fortune 500 Report for Nike ranked 0 times\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: NaN StD: NaN\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: NaN StD: NaN\n" + 
				"Rank\n" + 
				"Min: null Max: null Avg: NaN StD: NaN";
		
		assertEquals("Problem in processReport handling of companies not in file",
				expected, c.toString());
	}
	@Test
	public void normalUseTest()
	{
		File file = new File("temp_normalUseTest.tmp");
		file.delete();
		file.deleteOnExit();
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "PepsiCo");
		assertTrue(c.processReport());
		String expected = "Fortune 500 Report for PepsiCo ranked 26 times\n" + 
				"Revenue\n" + 
				"Min: 74.200 Max: 5090.600 Avg: 1182.981 StD: 1363.336\n" + 
				"Profit\n" + 
				"Min: 6.200 Max: 264.900 Avg: 62.335 StD: 68.334\n" + 
				"Rank\n" + 
				"Min: 57 Max: 364 Avg: 180.423 StD: 101.462";
		
		assertEquals("Problem in processData algorithm or toString",
				expected, c.toString());
		assertTrue(c.writeReport(file));
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
		assertTrue(c.writeReport(file));
		file.delete();
	}
	/*@Test
	public void fileCannotBeCreatedTest()
	{
		File file = new File("/foo/bar/baz/temp_normalUseTest.tmp");
		file.delete();
		file.deleteOnExit();
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "PepsiCo");
		assertTrue(c.processReport());
		assertFalse(c.writeReport(file));
		file.delete();
	}*/
	
}
