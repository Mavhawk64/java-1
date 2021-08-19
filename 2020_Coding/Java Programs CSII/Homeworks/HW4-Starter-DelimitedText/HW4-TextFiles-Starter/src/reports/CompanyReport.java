// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance was used in the creation of this java program.

package reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import analytics.Data;

/**
 * A report for a single company of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues, profits, and rank
 *  for all years in which the company was ranked in the Fortune 500.
 * @author mberkland and abdoullatoundji
 *
 */
public class CompanyReport implements Report
{
	/**
	 * Boolean for determining if the file's processed.
	 */
	private boolean isProcessed;
	/**
	 * The File that was passed in.
	 */
	private File inputFile;
	/**
	 * The current Company String.
	 */
	private String company;
	/**
	 * Inputted Fortune500 Data as ArrayList.
	 */
	private ArrayList<String> fortune = null;
	/**
	 * Double Array for mins.
	 */
	private Double[] mins;
	/**
	 * Double Array for maxes.
	 */
	private Double[] maxes;
	/**
	 * Double Array for averages.
	 */
	private Double[] avgs;
	/**
	 * Double Array for standard deviations.
	 */
	private Double[] std;
	/**
	 * Creates new CompanyReport for given company; data to be read from given file.
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param companyIn - Company to report Fortune 500 data.
	 */
	public CompanyReport(File inputFileIn, String companyIn)
	{
		inputFile = inputFileIn;
		company = companyIn;
	}
	
	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues, profits, and rank
	 *  for all years the company is ranked using tools in the Data class.
	 * @return true if processing successful, false if the input file does not exist.
	 */
	public boolean processReport()
	{
		Scanner sc = null;
		boolean ret = true;
		isProcessed = true;
		try
		{
			fortune = new ArrayList<String>();
			sc = new Scanner(inputFile);
			//sc.useDelimiter(",");
			sc.nextLine();
			while (sc.hasNextLine())
			{
				String s = sc.nextLine();
				if (s.contains(company))
				{
					fortune.add(s);
				}
			}
			sc.close();
			//Find MIN, MAX, AVG, and STD DEV of RANK, REVENUE, and PROFIT.
			
			Double[][] data = new Double[3][fortune.size()];
			int[] ind = {RANK_LOC, REVENUE_LOC, PROFIT_LOC};
			for (int i = 0; i < data.length; i++)
			{
				for (int j = 0; j < data[i].length; j++)
				{
					data[i][j] = Double.parseDouble(fortune.get(j).split(",")[ind[i]]);
				}
			}
			
			Double[] min = {Data.minimum(data[0]), Data.minimum(data[1]), Data.minimum(data[2])};
			Double[] max = {Data.maximum(data[0]), Data.maximum(data[1]), Data.maximum(data[2])};
			Double[] avg = {Data.average(data[0]), Data.average(data[1]), Data.average(data[2])};
			Double[] stds = {Data.standardDeviation(data[0]),
					Data.standardDeviation(data[1]), Data.standardDeviation(data[2])};
			mins = min;
			maxes = max;
			avgs = avg;
			std = stds;
		}
		catch (FileNotFoundException fnfe)
		{
			//System.err.println("The file: " + inputFile + " was not found.");
			ret = false;
		}
		return ret;
	}

	/**
	 * Writes the processed report to the given file.
	 * The given file's contents will look like the result of calling CompanyReport's toString.
	 * @param outputFile - File to write report to.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 * @return true if write successful, false if file cannot be created.
	 */
	public boolean writeReport(File outputFile) throws DataNotProcessedException
	{
		boolean ret = true;
		if (!isProcessed)
		{
			throw new DataNotProcessedException();
		}
		FileWriter outWrite;
		try
		{
			outWrite = new FileWriter(outputFile);
			outWrite.write(toString());
			outWrite.close();
		}
		catch (IOException e) //TEST HERE
		{
			ret = false; //TEST HERE
		}
		
		return ret;
	}
	
	/**
	 * Returns a formatted String of this report suitable for writing to an output file. String is of the form:
	 * 
	 * Fortune 500 Report for COMPANY ranked RANKED times
	 * Revenue
	 * Min: MINREV Max: MAXREV Avg: AVGREV StD: STDREV
	 * Profit
	 * Min: MINPRO Max: MAXPRO Avg: AVGPRO StD: STDPRO
	 * Rank
	 * Min: MINRANK Max: MAXRANK Avg: AVGRANK StD: STDRANK
	 * 
	 * Where COMPANY is the company, RANKED is the number of times the company has been ranked in the file,
	 *  MINREV, MAXREV, AVGREV, STDREV are the minimum, maximum, average, and standard deviation of revenues,
	 *  MINPRO, MAXPRO, AVGPRO, STDPRO are the minimum, maximum, average, and standard deviation of profits,
	 *  and MINRANK, MAXRANK, AVGRANK, STDRANK are the minimum, maximum, average, and standard deviation of rank.
	 * These are all floating point values formatted to exactly three decimals except for MINRANK and MAXRANK
	 *  which are whole number values.
	 * NOTE:There are no blank lines before, after, or between the lines, and the String DOES NOT end in a new line.
	 *  If your toString is not formatted exactly most tests will fail.
	 *  A JUnit test for this method is provided in the tests package to ensure your formatting is correct.
	 *  Additionally, remember that all are formatted to exactly three decimal places,
	 *   which will explain any "nul"s you see in the provided test case.
	 */
	@Override
	public String toString()
	{
		String ret;
		String message = "Fortune 500 Report for %s ranked %d times\n"
				+ "Revenue\n"
				+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
				+ "Profit\n"
				+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
				+ "Rank\n"
				+ "Min: %.0f Max: %.0f Avg: %.3f StD: %.3f";
		String badMessage = "Fortune 500 Report for %s ranked 0 times\n"
				+ "Revenue\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Profit\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Rank\n"
				+ "Min: null Max: null Avg: nul StD: nul"; //???????????????????????????????
		String badMessage2 = "Fortune 500 Report for %s ranked 0 times\n"
				+ "Revenue\n"
				+ "Min: nul Max: nul Avg: NaN StD: NaN\n"
				+ "Profit\n"
				+ "Min: nul Max: nul Avg: NaN StD: NaN\n"
				+ "Rank\n"
				+ "Min: null Max: null Avg: NaN StD: NaN";
		if (fortune != null && fortune.size() > 0)
		{
			ret = String.format(message, company, fortune.size(),
					mins[1], maxes[1], avgs[1], std[1],
					mins[2], maxes[2], avgs[2], std[2],
					mins[0], maxes[0], avgs[0], std[0]);
		}
		else if (isProcessed)
		{
			ret = String.format(badMessage2, company);
		}
		else
		{
			ret = String.format(badMessage, company);
		}
		return ret;
	}

	/**
	 * Returns the company of this report.
	 * @return Company of this report.
	 */
	public String getCompany()
	{
		return company;
	}

}
