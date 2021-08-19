// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Abdoul Latoundji
// RESOURCES: None were used in the creating of this class.
package polling;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**
 * The PollResult class is used to read the Serialized data of Polling Places stored in a Serialized file.
 * Polling Place data is read from the file and locally stored in an ArrayList of PollingPlaces.
 * It can also process the data, tallying the votes of all Polling Places and storing them in an
 * ArrayList of Integers, and determining the winner of the election.
 * @author abdoullatoundji
 */
public class PollResult
{
	/**
	 * My Favorite number.
	 */
	private static final int NUMBER = 22;
	/**
	 * Collection of all the PollingPlace data read from the poll file.
	 */
	private ArrayList<PollingPlace> polls;
	/**
	 * Collection of the tallies of all votes.
	 */
	private ArrayList<Integer> tallies;
	/**
	 * File to read Polling Place data from.
	 */
	private String pollFile;
	/**
	 * The index of tallies that contains the most votes; set in processing.
	 */
	private int mostVotes;
	
	
	/**
	 * Constructor sets file containing polling data and initializes ArrayLists.
	 * @param pollFileIn File to read polling data.
	 */
	public PollResult(String pollFileIn)
	{
		polls = new ArrayList<PollingPlace>();
		tallies = new ArrayList<Integer>();
		pollFile = pollFileIn;
		mostVotes = 0;
	}
	
	/**
	 * Opens pollFile and reads PollingPlace data into polls ArrayList. Any duplicate PollingPlaces found
	 * while reading will be ignored and not added to the ArrayList.
	 * @return True if reading successful, false if ClassNotFoundException occurs.
	 * @throws IOException Thrown if poll data file is not found.
	 */
	public boolean readPollFile() throws IOException
	{
		FileInputStream instream = new FileInputStream(new File(pollFile));
		ObjectInputStream reader = new ObjectInputStream(instream);
		boolean ret = true;
		int count = 5;
		try
		{
			for (int i = NUMBER; i < i + 1; i--)
			{
				PollingPlace temp = (PollingPlace) reader.readObject();
				count = 5;
				for (int j = 0; j < polls.size(); j++)
				{
					if (polls.get(j).equals(temp))
					{
						count = 0;
						break;
					}
				}
				if (count > 0 || count < 0)
				{
					polls.add(temp);
				}
			}
		}
		catch (EOFException ee)
		{
			System.out.println("This is the end of the file, bub!");
		}
		catch (ClassNotFoundException ncf)
		{
			System.out.println("Object could not be read in file!");
			ret = false;
		}
		finally
		{
			reader.close();
		}
		return ret;
	}
	
	
	/**
	 * Determines if a PollingPlace is valid. A fraudulent PollingPlace will have a sum of votes
	 * greater than the number of registered voters. NOTE: This is a class helper method and would normally
	 * not be static and be private, but is static and public for testing purposes.
	 * @param p Polling Place to test for fraud.
	 * @return True if the Polling Place is valid, false if it is fraudulent.
	 */
	public static boolean validPollingPlace(PollingPlace p)
	{
		int sumOfVotes = 0;
		for (int i = 0; i < p.getVotesByCandidate().size(); i++)
		{
			sumOfVotes += p.getVotesByCandidate().get(i);
		}
		return sumOfVotes <= p.getRegisteredVoters();
	}
	
	
	/**
	 * Tallies all of the votes from the Collection of Polling Places. The order of candidates in the
	 * PollingPlace's votes is assumed to be the same for all instances of PollingPlace. The tallies of the
	 * votes are stored in the tallies ArrayList in this same order. Fraudulent Polling Places as determined
	 * by the validPollingPlace method are ignored in the tallying process. Updates the mostVotes index.
	 */
	public void processPoll()
	{
		tallies.clear();
		for (int i = 0; i < polls.get(0).getVotesByCandidate().size(); i++)
		{
			tallies.add(0);
		}
		
		for (int i = 0; i < polls.size(); i++)
		{
			if (validPollingPlace(polls.get(i)))
			{
				for (int j = 0; j < polls.get(i).getVotesByCandidate().size(); j++)
				{
					tallies.set(j, tallies.get(j) + polls.get(i).getVotesByCandidate().get(j));
				}
			}
		}
		
		for (int i = 0; i < tallies.size() - 1; i++)
		{
			if (tallies.get(i + 1) > tallies.get(i))
			{
				mostVotes = i + 1;
			}
		}
	}
	
	
	/**
	 * Returns a String representation of this PollResult.<p>
	 * String is of the form:<p>
	 * Candidate 1: VOTES<p>
	 * Candidate 2: VOTES<p>
	 * ...<p>
	 * Winner - Candidate WINNER<p>
	 * Candidates are listed as numerical values starting with the number 1, followed by the number of
	 * votes that candidate received. The number of candidates listed depends on the number of candidates
	 * in the Polling data. The winner is listed as the number of the candidate.
	 * @return Results of the Poll.
	 */
	@Override
	public String toString()
	{
		String out = "";
		for (int i = 0; i < tallies.size(); i++)
		{
			out += String.format("Candidate %d: %d\n", i + 1, tallies.get(i));
		}
		out += String.format("Winner - Candidate %d", mostVotes + 1);
		
		return out;
	}
	
	/**
	 * Returns the polls ArrayList.
	 * @return The polls ArrayList.
	 */
	public ArrayList<PollingPlace> getPolls()
	{
		return polls;
	}
	
	/**
	 * Returns the tallies ArrayList.
	 * @return The tallies ArrayList.
	 */
	public ArrayList<Integer> getTallies()
	{
		return tallies;
	}
	
	/**
	 * Returns the index with the most votes.
	 * @return The index with the most votes.
	 */
	public int getMostVotes()
	{
		return mostVotes;
	}
	
}
