// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Google was used for the verification of Hydrocarbons.

package molecule.test;

import static org.junit.Assert.*;

import molecule.Molecule;
import molecule.exceptions.InvalidSequenceException;

import org.junit.Test;

public class MoleculeTest
{
	/**
	 * 
	 * the expected atomic weight of water (H2O).
	 */
	private static final int WATER_WEIGHT = 18;
	/**
	 * 
	 * the expected atomic weight of glucose (C6H12O6).
	 */
	private static final int SUGAR_WEIGHT = 180;
	/**
	 * invalid sequences.
	 */
	private static final String[] BAD_SEQUENCES = {
		")(HOC)2",
		"(OH",
		"(((H))))"
	};
	@Test
	public void testSetSequence()
	{
		Molecule mo = new Molecule("H2O");
		assertEquals("Error in setSequence", "H2O", mo.getSequence());
		mo.setSequence("H(OH)");
		assertEquals("Error in setSequence", "H(OH)", mo.getSequence());
		mo.setSequence("C12H22O11"); 
		assertEquals("Error in setSequence", "C12H22O11", mo.getSequence());
		mo.setSequence("CH3(CH2)6CH3");
		assertEquals("Error in setSequence", "CH3(CH2)6CH3", mo.getSequence());
		mo.setSequence("CO");
		assertEquals("Error in setSequence", "CO", mo.getSequence());
//		assertThrows(InvalidSequenceException.class, () ->
//		{
//			mo.setSequence(BAD_SEQUENCES[0]);
//		});
//		assertThrows(InvalidSequenceException.class, () ->
//		{
//			mo.setSequence(BAD_SEQUENCES[1]);
//		});
//		assertThrows(InvalidSequenceException.class, () ->
//		{
//			mo.setSequence(BAD_SEQUENCES[2]);
//		});
		
		for (int i = 0; i < BAD_SEQUENCES.length; i++) //HERE.
		{
			boolean thrown = false;

			try
			{
				mo.setSequence(BAD_SEQUENCES[i]);
			}
			catch (InvalidSequenceException e)
			{
				thrown = true;
			}
			assertTrue(thrown);
		}
	}
	
	@Test
	public void testToString()
	{
		String s1 = "C6H12O6";
		String s2 = "H2O";
		String sugarString = "C6H12O6                  : " + SUGAR_WEIGHT;
		String waterString = "H2O                      : " + WATER_WEIGHT;
		Molecule m = new Molecule(s1);
		Molecule m2 = new Molecule(s2);
		assertEquals("Error in toString.", m.toString(), sugarString);
		assertEquals("Error in toString.", m2.toString(), waterString);
	}
	
	@Test
	public void testAtomWeight()
	{
		String s1 = "C6H12O6";
		String s2 = "H2O";
		Molecule m = new Molecule(s1);
		Molecule m2 = new Molecule(s2);
		assertEquals(SUGAR_WEIGHT, m.getWeight());
		assertEquals(WATER_WEIGHT, m2.getWeight());
	}

	@Test
	public void testCompareTo()
	{
		int oxygenWeight = Molecule.atomWeight('O');
		Molecule m = new Molecule("C6H12O6");
		Molecule m2 = new Molecule("C6H12O6");
		Molecule m3 = new Molecule("C6H12O7");
		Molecule m4 = new Molecule("C6H13O7");
		assertEquals(0, m.compareTo(m2));
		assertEquals(-oxygenWeight, m.compareTo(m3));
		assertEquals(-(oxygenWeight + 1), m.compareTo(m4));
		assertEquals(0, m2.compareTo(m));
		assertEquals(oxygenWeight, m3.compareTo(m));
		assertEquals(oxygenWeight + 1, m4.compareTo(m));
	}
	
	@Test
	public void testClone()
	{
		Molecule m = new Molecule("C6H12O6");
		Molecule mclone = (Molecule) m.clone();
		assertFalse(m == mclone);
		assertEquals(0, m.compareTo(mclone));
	}
}
