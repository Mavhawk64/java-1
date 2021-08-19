// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: The classes that were given to us as reference. Classmate assistance.

package molecule;

import java.util.Iterator;
import java.util.LinkedList;

import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * A collection of Molecules maintained in a LinkedList.
 *  Allows for adding, sorting, and updating Molecules in the collection.
 *  A List of the Molecules can also be retrieved;
 *  the returned list is a deep copy of the list held in the MoleculeCollection.
 * @author mberkland and abdoullatoundji
 *
 */
public class MoleculeCollection
{
	/**
	 * This is the list of all of the molecules in our collection.
	 */
	private LinkedList<Molecule> internalList;
	/**
	 * Creates a new MoleculeCollection containing no Molecules yet.
	 */
	public MoleculeCollection()
	{
		this(null); //Big Brain moment.
	}
	
	/**
	 * Creates a new MoleculeCollection based upon an existing list of Molecules.
	 * The newly created MoleculeCollection will store a deep copy of the data in
	 *  moleculeListIn to enforce encapsulation.
	 * If the passed reference is null, the created MoleculeCollection will be empty.
	 * @param moleculeListIn - LinkedList of Molecules used to create a new MoleculeCollection.
	 */
	public MoleculeCollection(LinkedList<Molecule> moleculeListIn)
	{
		if (moleculeListIn == null)
		{
			internalList = new LinkedList<Molecule>();
		}
		else
		{
			internalList = new LinkedList<Molecule>(moleculeListIn);
		}
	}
	/**
	 * Adds a copy of a given Molecule to this MoleculeCollection at the given index.
	 * Future external changes to the original Molecule will not impact values in the collection.
	 * If add is null, this MoleculeCollection is unchanged. If the given index is out of range,
	 *  the Molecule will be added to the end of the Collection
	 * @param index - The index in which to add the Molecule
	 * @param add - Molecule to be added to the Collection
	 */
	public void addMolecule(int index, Molecule add)
	{
		if (add != null)
		{
			if (index >= internalList.size() || index < 0)
			{
				internalList.add((Molecule) add.clone());
			}
			else
			{
				internalList.add(index, (Molecule) add.clone());
			}
		}
	}
	
	/**
	 * Reorders the MoleculeCollection based on atomic weight.
	 * Molecules with the same weights should appear in their original order of insertion
	 *  relative to one another (ie., sort() is a stable sorting algorithm).
	 */
	public void sort()
	{
		
		
		//BUBBLE SORT: (Keep just in case).
		
		for (int i = 1; i < internalList.size(); i++)
		{
			if (internalList.get(i).getWeight() < internalList.get(i - 1).getWeight())
			{
				Molecule temp = internalList.get(i);
				internalList.set(i, internalList.get(i - 1));
				internalList.set(i - 1, temp);
				i = 0;
			}
		}
	}
	
	/**
	 * Sums the weights of all Molecules in the MoleculeCollection.
	 * @return The sum of all weights in the collection.
	 */
	public int moleculeWeights()
	{
		Iterator<Molecule> itr = internalList.iterator();
		int sum = 0;
		while (itr.hasNext())
		{
			Molecule next = itr.next();
			sum += next == null ? 0 : next.getWeight();
		}
		return sum;
	}
	
	/**
	 * Generates and returns a deep copy of a list containing all of the Molecules in this MoleculeCollection.
	 * Modifying the returned list will not impact the contents of this MoleculeCollection in any way.
	 * @return Deep copy of the Molecules
	 */
	public LinkedList<Molecule> getMoleculeList()
	{
		LinkedList<Molecule> copiedList = new LinkedList<Molecule>();
		for (Molecule m : internalList)
		{
			copiedList.add((Molecule) m.clone());
		}
		return copiedList;
	}
	
	/**
	 * Changes the sequence of a Molecule in the collection at the specified index.
	 * This does not create a new Molecule, rather modifies an existing Molecule.
	 * If the provided sequence is not valid due to either an invalid sequence or an invalid atom,
	 *  the original state of the Molecule at the specified index should be unaffected and
	 *  the resulting exception will be thrown to the caller.
	 * @param index - Location of the Molecule to update
	 * @param newSequence - New sequence of the specified Molecule
	 * @throws InvalidAtomException - Thrown if the new sequence is invalid due to unknown atom
	 * @throws InvalidSequenceException - Thrown if the new sequence is invalid due to format
	 */
	public void changeSequence(int index, String newSequence) throws InvalidAtomException, InvalidSequenceException
	{
		if (index < internalList.size() && index > 0)
		{
			internalList.get(index).setSequence(newSequence);
		}
	}

}
