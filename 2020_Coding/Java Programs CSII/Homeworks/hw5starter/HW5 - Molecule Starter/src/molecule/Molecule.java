// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance and the given classes were used in the process
//            of this class.

package molecule;

import java.util.Stack;

import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * Objects of the Molecule class represent a single chemical molecule made up of any number
 *  of hydrogen, carbon, and oxygen atoms.
 *  The class provides functionality to compute the atomic weight of the molecule.
 *  @author mberkland and abdoullatoundji
 */
public class Molecule implements Comparable<Molecule>, Cloneable
{
	/**
	 * Given H weight.
	 */
	private static final int HYDROGEN_WEIGHT = 1;
	/**
	 * Given C weight.
	 */
	private static final int CARBON_WEIGHT = 12;
	/**
	 * Given O weight.
	 */
	private static final int OXYGEN_WEIGHT = 16;
	/**
	 * Our sequence that will be passed in.
	 */
	private String sequence;
	/**
	 * The total weight of the Molecule.
	 */
	private int weight;
	/**
	 * Creates a new Molecule made up of the H, C, and O atoms in the configuration specified by sequenceIn.
	 * @param sequenceIn - The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn or
	 *  incoming sequence is null or empty String.
	 */
	public Molecule(String sequenceIn)
	{
		setSequence(sequenceIn);
	}
	
	/**
	 * Checks whether the given sequence contains any non C, H, O atoms.
	 * @param sequenceIn - The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn.
	 */
	private void checkCharacters(String sequenceIn)
	{
		if (sequenceIn == null || sequenceIn.isEmpty() || !sequenceIn.matches("[choCHO1234567890\\(\\)]+"))
		{
			throw new InvalidAtomException(sequenceIn
					.replaceAll("[choCHO1234567890\\(\\)]+", "").toCharArray()[0]);
		}
	}
	
	/**
	 * This method parses the number from the Stack.
	 * @param myStack - The stack that is being passed in.
	 * @return - An int that is popped off of the stack.
	 */
	private int parseNumber(Stack<Character> myStack)
	{
		int workingInt = 0;
		while (myStack.peek() >= '0' && myStack.peek() <= '9')
		{
			workingInt = workingInt * 10 + myStack.pop() - '0';
			if (myStack.empty())
			{
				break;
			}
		}
		return workingInt;
	}
	
	/**
	 * This method removes the -1.
	 * @param theStack - The stack that is being passed in.
	 */
	private void rollup(Stack<Integer> theStack)
	{
		int bufferInt = 0;
		while (theStack.peek() != -1)
		{
			bufferInt += theStack.pop();
			if (theStack.empty())
			{
				throw new InvalidSequenceException();
			}
		}
		theStack.pop(); //eliminates the -1
		theStack.push(bufferInt);
	}
	/**
	 * Updates the sequence of atoms represented by this Molecule.
	 * @param sequenceIn - The new molecular sequence to be used for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn
	 */
	public void setSequence(String sequenceIn)
	{
		checkCharacters(sequenceIn);
		Stack<Integer> theStack = new Stack<Integer>();
		char[] sequenceAsArray = sequenceIn.toCharArray();
		Stack<Character> myStack = new Stack<Character>();
		for (int i = sequenceAsArray.length - 1; i >= 0; i--) 
		{
			myStack.push(sequenceAsArray[i]);
		}
		theStack.push(-1);
		while (!myStack.empty())
		{
			Character c = myStack.peek();
			if (c >= '0' && c <= '9')
			{
				theStack.push(theStack.pop() * parseNumber(myStack));
			}
			else if (c.toString().matches("[cChHoO]"))
			{
				theStack.push(atomWeight(myStack.pop()));
			}
			else if (c == '(')
			{
				theStack.push(-1);
				myStack.pop();
			}
			else if (c == ')')
			{
				rollup(theStack);
				myStack.pop();
			}
		}
		rollup(theStack);
		int tempWeight = theStack.pop();
		if (!theStack.empty())
		{
			throw new InvalidSequenceException();
		} ///This is for parenthetical mismatch
		sequence = sequenceIn;
		weight = tempWeight;
	}
	
	/**
	 * Retrieves a String containing this Molecule's sequence of atoms.
	 * @return Molecular sequence of the Molecule.
	 */
	public String getSequence()
	{
		return sequence;
	}
	
	/**
	 * Retrieves this Molecule's weight, which is calculated based on the Molecule's 
	 * sequence per the algorithm specified.
	 * @return Weight of the Molecule.
	 */
	public int getWeight()
	{
		return weight;
	}
	
	/**
	 * Generates and returns a String with the Molecule's sequence and weight. The format of the String is
	 * 
	 * [SEQUENCE               ]: WEIGHT
	 * 
	 * Where SEQUENCE has a field width of 25 and is left justified
	 * (square brackets are just placeholders and will not appear in actual return values).
	 * WEIGHT should be left-justified. There is no space following the SEQUENCE field and the colon.
	 * @return The generated String.
	 */
	@Override
	public String toString()
	{
		return String.format("%-25s:%s", getSequence(), " " + getWeight());
	}

	/**
	 * 	Static utility method to return the atomic weight of a given atom.
	 *  Supported atoms are Carbon (C), Hydrogen (H), and Oxygen (O), and the value of the atom parameter
	 *   corresponds to the single letter abbreviation for these atoms (case insensitive).
	 *  Atomic weights are given in their nearest whole number:
	 *   Hydrogen - 1 
	 *   Carbon - 12 
	 *   Oxygen - 16
	 * @param atom - Character for atom abbreviation
	 * @return Atomic weight of passed atom
	 * @throws molecule.exceptions.InvalidAtomException - Thrown if an unsupported atom is passed
	 */
	public static int atomWeight(char atom) throws InvalidAtomException
	{
		int atomWeight = 0;
		if (atom == 'H' || atom == 'h')
		{
			atomWeight = HYDROGEN_WEIGHT;
		} 
		else if (atom == 'C' || atom == 'c')
		{
			atomWeight = CARBON_WEIGHT;
		} 
		else if (atom == 'O' || atom == 'o')
		{
			atomWeight = OXYGEN_WEIGHT;
		}
		else
		{
			throw new InvalidAtomException(atom);
		}
		return atomWeight;
	}

	/**
	 * Compares this Molecule to a passed Molecule, determining natural order.
	 * Molecules with the same weight (regardless of sequence) are considered equal.
	 * All others are ordered relative to the magnitude of their weights.
	 * @param other - Incoming Molecule to be compared with this (local) Molecule.
	 * @return Returns an int less than 0 if the local Molecule is less than the passed Molecule,
	 *  an int greater than 0 if the local Molecule is greater than the passed Molecule,
	 *  and a 0 if the Molecules are equal.

	 */
	public int compareTo(Molecule other)
	{
		return weight - other.getWeight();
	}
	
	/**
	 * Returns a deep copy of the Molecule.
	 * The reference returned should refer to a completely separate molecule with no direct or
	 *  indirect aliasing of any instance data in the original Molecule.
	 *  NOTE: This method should NOT throw a CloneNotSupportedException.
	 *  @return Deep copy of the calling Molecule.
	 */
	@Override
	public Object clone()
	{
		try //This got rid of the error.
		{
			super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return new Molecule(sequence);
	}

}
